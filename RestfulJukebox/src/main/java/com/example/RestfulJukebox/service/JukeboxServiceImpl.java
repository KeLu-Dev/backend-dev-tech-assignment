package com.example.RestfulJukebox.service;

import com.example.RestfulJukebox.Error.FaultyPageParamException;
import com.example.RestfulJukebox.Error.ModelDneException;
import com.example.RestfulJukebox.Error.SettingDneException;
import com.example.RestfulJukebox.dao.JukeboxDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.RestfulJukebox.dao.SettingDao;
import com.example.RestfulJukebox.entity.Component;
import com.example.RestfulJukebox.entity.Jukebox;
import com.example.RestfulJukebox.entity.Setting;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GrQuil
 */
@Service
public class JukeboxServiceImpl implements JukeboxService{
    @Autowired 
    private JukeboxDao jukeboxdao;
    
    @Autowired 
    private SettingDao settingDao;

    /**
     * Method looks for all Jukeboxes that have a specific setting 
     * Results can be filtered by model or paginated depending on inputs
     * @param settingId : Can not be Null: SettingID of setting to search for 
     * @param model : Can be Null: model to filter by 
     * @param offset : Can be Null: offset results by this amount  
     * @param limit : Can be Null: max page size of results 
     * @return
     * @throws java.lang.Exception - Throw exception based on faulty settingId, model, offset or limit params
     */
    @Override
    public List<Jukebox> getJukeboxesBySettingId(String settingId, String model, Integer offset, Integer limit) throws Exception {
        
        List<Jukebox> jukeboxes = jukeboxdao.getAllJukeboxes();
        List<Setting> settings = settingDao.getAllSettings(); 
        List<Jukebox> matchingJukeboxes = new ArrayList<Jukebox>();
        Setting toFindSetting = findSettingById(settings, settingId);
        
        //If model is not null then we filter the jukboxes to only be those of that model 
        if(model != null){
            jukeboxes = filterJukeboxesByModel(jukeboxes, model);
            //If result set is empty then model does not exist and we throw a bad request response 
            if(jukeboxes.isEmpty()){
                throw new ModelDneException();
            }
        }
        
        //If setting for given settingID does not exist then we throw a bad request response 
        if(toFindSetting == null){
            throw new SettingDneException();
        }
        
        if(toFindSetting.getRequires().size() != 0){
             for(Jukebox jukebox : jukeboxes){
                 List<String> jukeComponents = extractComponents(jukebox);
                 //jukebox must have atleast enough components to fit setting
                 if(jukeComponents.size() >= toFindSetting.getRequires().size() ){
                     //Check if Setting components is a subset of Jukebox compoents
                    if(jukeComponents.containsAll(toFindSetting.getRequires())){
                        matchingJukeboxes.add(jukebox);
                    } 
                 }
            }
        //if required component size is zero then all jukboxes must have the setting     
        }else{
            matchingJukeboxes = jukeboxes;
        }
        
        //If user provides offset or limit then we tailor the results 
        if(offset != null || limit != null){
            matchingJukeboxes = paginateList(matchingJukeboxes, offset, limit);    
        }
        
        return matchingJukeboxes;
    }
    

    
      /**
     * Method filters a list of Jukeboxes to be that of a specific model
     * @param jukeboxes
     * @param model : model to filter by 
     * @return : filtered list of Jukeboxes  
     */
    public List<Jukebox> filterJukeboxesByModel(List<Jukebox> jukeboxes , String model){
        List<Jukebox> found = new ArrayList<Jukebox>();
        
        for(Jukebox jukebox : jukeboxes){
            if(jukebox.getModel().equals(model)){
                found.add(jukebox);
            }
        }
        
        return found;
    }
    
    
    /**
     * Method looks for supplied setting by ID in list of settings
     * @param settings
     * @return returns the found Setting, or Null if setting DNE
     */
    public Setting findSettingById( List<Setting> settings, String settingID ){
        
        Setting foundSetting = new Setting();
        
        for(Setting setting : settings ){
            if(setting.getId().equals(settingID) ){
                foundSetting = setting;
                return foundSetting;
            }
        }
        return null;
    }
    
    /**
     * Converts the component list of a Jukebox into a list of strings of names
     * @param jukebox 
     * @return: a list of component names 
     */
    public List<String> extractComponents(Jukebox jukebox){
        
        List<String> stringComponents = new ArrayList<String>();
        
        for(Component component : jukebox.getComponents()){
            stringComponents.add(component.getName());
        }
        
        return stringComponents;
        
    }
    
    /**
     * Returns a paginated tailored result based on User Input
     * @param jukeboxes  
     * @param offset : offset of results set 
     * @param limit : max size of page to be returned 
     * @return : returns the tailored result set 
     * @throws java.lang.Exception - If limit or offset is nonsensical 
     */
    public List<Jukebox> paginateList(List<Jukebox> jukeboxes , Integer offset, Integer limit)throws Exception{
        Integer off = offset;
        Integer lim = limit;
        
        //Can be considered default value for offset 
        if(offset == null ){
            off = 0;
        }
        //Can be considered default value for limit
        if(limit == null){
            lim = jukeboxes.size();
        }
        
        //If offset or limit is nonsenical then we return bad Request response 
        if(off > jukeboxes.size() || lim <= 0 || off < 0 ){
               throw new FaultyPageParamException();
        }
        
        //Ensure we don't have an outof bounds exception 
        if(lim + off > jukeboxes.size() ){
            return jukeboxes.subList(off, jukeboxes.size());
        }else{
            return jukeboxes.subList(off, lim + off);
        }
        
    }

}


