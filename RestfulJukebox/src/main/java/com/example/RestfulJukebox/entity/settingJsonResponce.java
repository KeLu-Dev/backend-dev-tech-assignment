package com.example.RestfulJukebox.entity;

import java.util.List;

/**
 * Represents a Json response of a list of settings 
 * @field settings: A list of Setting objects 
 * @author GrQuil
 */
public class settingJsonResponce {

    private List<Setting> settings;

    /**
     * Auto Generated getter method
     * @return
     */
    public List<Setting> getSettings() {
        return settings;
    }

    /**
     * Auto Generated setter method
     * @param settings
     */
    public void setSettings(List<Setting> settings) {
        this.settings = settings;
    }

}
