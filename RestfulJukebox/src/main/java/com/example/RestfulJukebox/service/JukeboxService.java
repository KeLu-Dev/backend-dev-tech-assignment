package com.example.RestfulJukebox.service;

import com.example.RestfulJukebox.entity.Jukebox;
import java.util.List;

/**
 * Interface for Jukebox Service Layer 
 * @author GrQuil
 */
public interface JukeboxService {
    
     /**
     * Required method to get a list of Jukeboxes that support a specific id 
     * @param settingId : Required : settingId of setting to check for
     * @param model : Optional : Model to filter by 
     * @param offset : Optional : Offset of page start 
     * @param limit : Optional : max size of page
     * @return
     * @throws java.lang.Exception
     */
    public List<Jukebox> getJukeboxesBySettingId(String settingId, String model, Integer offset, Integer limit) throws Exception;
    
}
