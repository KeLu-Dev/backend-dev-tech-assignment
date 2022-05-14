package com.example.RestfulJukebox.dao;

import com.example.RestfulJukebox.entity.Jukebox;
import java.util.List;

/**
 * Interface for obtaining Jukebox Data 
 * @author GrQuil
 */
public interface JukeboxDao { 

    /**
     * Required method to get a list of all Jukeboxes 
     * @return
     */
    List<Jukebox> getAllJukeboxes();
}
