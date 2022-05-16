package com.example.RestfulJukebox.entity;

import java.util.List;

/**S
 * Represents a Jukebox setting 
 * @field String id: Unique ID of the setting 
 * @field List String requires:List of required components to support setting 
 * @author GrQuil
 */
public class Setting {
    
    private String id;
    private List<String> requires;
    

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public List<String> getRequires() {
        return requires;
    }


    public void setRequires(List<String> requires) {
        this.requires = requires;
    }
    
}
