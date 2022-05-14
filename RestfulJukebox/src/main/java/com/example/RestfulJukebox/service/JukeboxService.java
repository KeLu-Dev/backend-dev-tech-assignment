/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.RestfulJukebox.service;

import com.example.RestfulJukebox.dao.JukeboxDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.RestfulJukebox.dao.SettingDao;

/**
 *
 * @author GrQuil
 */
@Service
public class JukeboxService {
    @Autowired 
    private JukeboxDao jukeboxdao;
    
    @Autowired 
    private SettingDao settingsDao;
    
    
    
}
