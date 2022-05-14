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
     * @return
     */
    List<Setting> getAllSettings();
}
