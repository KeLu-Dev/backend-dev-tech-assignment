package com.example.RestfulJukebox.dao;
import java.util.List;
import com.example.RestfulJukebox.entity.Setting;
/**
 * Interface for obtaining settings data 
 * @author GrQuil
 */
public interface SettingDao {

    /**
     * Required method to get a list of all Settings
     * @return : returns a list of Setting objects 
     */
    List<Setting> getAllSettings();
}
