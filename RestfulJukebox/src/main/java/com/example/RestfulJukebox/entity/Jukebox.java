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

    /**
     * Auto Generated getter method
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Auto Generated setter method
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * Auto Generated getter method
     * @return
     */
    public String getModel() {
        return model;
    }

    /**
     * Auto Generated setter method
     * @param model
     */
    public void setModel(String model) {
        this.model = model;
    }
    
    /**
     * Auto Generated getter method
     * @return
     */
    public List<Component> getComponents() {
        return components;
    }

    /**
     * Auto Generated setter method
     * @param components
     */
    public void setComponents(List<Component> components) {
        this.components = components;
    }


  
    


}
