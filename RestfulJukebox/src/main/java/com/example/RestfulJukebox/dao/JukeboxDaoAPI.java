/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.RestfulJukebox.dao;

import com.example.RestfulJukebox.entity.Jukebox;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author GrQuil
 */
@Repository
public class JukeboxDaoAPI implements JukeboxDao{

    @Override
    public List<Jukebox> getAllJukeboxes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
