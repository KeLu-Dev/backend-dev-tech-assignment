package com.example.RestfulJukebox.dao;


import com.example.RestfulJukebox.entity.Setting;
import com.example.RestfulJukebox.entity.settingJsonResponce;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

/**
 * Class for accessing data of Settings Objects 
 * implements Settings Dao: specifically gets data from API Call 
 * @author GrQuil
 */
@Repository
public class SettingDaoAPI implements SettingDao{
    private RestTemplate restTemplate = new RestTemplate();

    /**
     * Method to get a list of Settings via API call
     * @return List Settings
     */
    @Override
    public List<Setting> getAllSettings() {
        //Make Call to API to get Settings Data 
        ResponseEntity<settingJsonResponce> responce = 
                restTemplate.exchange("http://my-json-server.typicode.com/touchtunes/tech-assignment/settings", HttpMethod.GET, null, 
                        new ParameterizedTypeReference<settingJsonResponce>(){});
        
        //Convert data from Json to Java Object and then retrurn list of settings
        List<Setting> settings = responce.getBody().getSettings();
        return settings;
    }
    
}
