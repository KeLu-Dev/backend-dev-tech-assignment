package com.example.RestfulJukebox.controller;
import com.example.RestfulJukebox.Error.FaultyPageParamException;
import com.example.RestfulJukebox.Error.ModelDneException;
import com.example.RestfulJukebox.Error.SettingDneException;
import com.example.RestfulJukebox.entity.Jukebox;
import com.example.RestfulJukebox.service.JukeboxService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author GrQuil
 */
@RestController
@RequestMapping("/jukeboxapi")
public class RestfulJukeboxController {
    
    @Autowired
    private JukeboxService jukeboxService;
	
    /**
     * Controller method for finding all jukeboxes with a specific Setting
     * @param settingId : Required : settingId of setting to check for
     * @param model : Optional : Model to filter by 
     * @param offset : Optional : Offset of page start 
     * @param limit : Optional : max size of page
     * @return
     * @throws java.lang.Exception
     */
    @GetMapping("/jukeboxesBySetting")
    public ResponseEntity<Object> returnSettingJukeboxes(@RequestParam(required=true) String settingId, @RequestParam(required=false) String model, 
                                                @RequestParam(required=false) Integer offset,@RequestParam(required=false) Integer limit ) throws Exception {

        List<Jukebox> jukeboxesById= jukeboxService.getJukeboxesBySettingId(settingId, model, offset,limit);
        return new ResponseEntity<Object>(jukeboxesById, HttpStatus.OK);
    }

    @ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Missing Required Param settingId. Please add a settingId param and try again.")
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public void handleMissingSettingId(MissingServletRequestParameterException ex){
        
    }
    
    @ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Given Model parameter does not exist. Please verify or remove faulty model param, and try again.")
    @ExceptionHandler(ModelDneException.class)
    public void handleModelDneException(ModelDneException ex){
        
    }
    
    @ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="No Settings match given settingId. Please verify or replace faulty setttingId and try again. ")
    @ExceptionHandler(SettingDneException.class)
    public void handleSettingDneException(SettingDneException ex){
        
    }
    
    @ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Either offset is greater than result set, or limit is less than one. Please verify and try again. ")
    @ExceptionHandler(FaultyPageParamException.class)
    public void handleFaultyPageParamException(FaultyPageParamException ex){
        
    }
    
    @ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Offset and limit must be Integers. Please fix and try again. ")
    @ExceptionHandler(NumberFormatException.class)
    public void handleNumberFormatException(NumberFormatException ex){
        
    }
}

