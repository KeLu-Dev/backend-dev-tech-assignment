/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.RestfulJukebox.dao;

import com.example.RestfulJukebox.entity.Jukebox;
import java.util.List;

/**
 *
 * @author GrQuil
 */
public interface JukeboxDao { 
    List<Jukebox> getAllJukeboxes();
}
