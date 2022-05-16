package com.example.RestfulJukebox.entity;

import java.util.List;

/**
 * Represents a Json response of a list of settings 
 * @field settings: A list of Setting objects 
 * @author GrQuil
 */
public class settingJsonResponce {

    private List<Setting> settings;


    public List<Setting> getSettings() {
        return settings;
    }


    public void setSettings(List<Setting> settings) {
        this.settings = settings;
    }

}
