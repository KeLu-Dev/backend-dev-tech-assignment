package com.example.RestfulJukebox.entity;

import java.util.List;

/**
 * Represents an existing Jukebox 
 * @field String id: Unique Id of the jukebox 
 * @field String model: Model name of the jukebox
 * @field list components: components of the jukebox 
 * @author GrQuil
 */
public class Jukebox {

    private String id;
    private String model;
    private List<Component> components; 


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }
    

    public String getModel() {
        return model;
    }


    public void setModel(String model) {
        this.model = model;
    }
    

    public List<Component> getComponents() {
        return components;
    }


    public void setComponents(List<Component> components) {
        this.components = components;
    }


  
    


}
