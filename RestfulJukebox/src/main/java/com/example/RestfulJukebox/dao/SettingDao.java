/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.RestfulJukebox.dao;
import java.util.List;
import com.example.RestfulJukebox.entity.Setting;
/**
 *
 * @author GrQuil
 */
public interface SettingDao {
    List<Setting> getAllSettings();
}
