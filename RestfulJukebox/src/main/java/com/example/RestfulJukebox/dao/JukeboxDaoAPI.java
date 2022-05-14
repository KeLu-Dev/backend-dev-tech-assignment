package com.example.RestfulJukebox.dao;

import com.example.RestfulJukebox.entity.Jukebox;
import java.util.List;
import org.springframework.stereotype.Repository;
import java.net.URI;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
/**
 * Class for accessing data of Jukebox Objects 
 * implements Jukebox Dao: specifically gets data from API Call 
 * @author GrQuil
 */
@Repository
public class JukeboxDaoAPI implements JukeboxDao{
    private RestTemplate restTemplate = new RestTemplate();
    
    /**
     * Method to get a list of jukeboxes via API call
     * @return
     */
    @Override
    public List<Jukebox> getAllJukeboxes() {
        //Make Call to API to get jukebox Data 
        ResponseEntity<List<Jukebox>> responce = 
                restTemplate.exchange("http://my-json-server.typicode.com/touchtunes/tech-assignment/jukes", HttpMethod.GET, null, 
                        new ParameterizedTypeReference<List<Jukebox>>(){});
        
        //Convert data from Json to Java Object and then retrurn 
        List<Jukebox> jukeboxes = responce.getBody();
        return jukeboxes;
        
   
    }
    
}
