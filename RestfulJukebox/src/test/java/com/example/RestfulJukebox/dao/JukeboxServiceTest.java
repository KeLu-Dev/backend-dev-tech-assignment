/*
 * Author: Keeghan Lucas
 */
package com.example.RestfulJukebox.dao;

import com.example.RestfulJukebox.entity.Jukebox;
import com.example.RestfulJukebox.service.JukeboxService;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;


/**
 *
 * @author GrQuil
 */
@SpringBootTest
public class JukeboxServiceTest {
    
    @Autowired
    JukeboxService instance;
    
 
    public JukeboxServiceTest() {
        
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
   public void testJukeboxServiceLayer() throws Exception{
       
       String settingId = "207797de-5857-4c60-a69b-80eea28bcce8";
       String model = "angelina";
       
       //Test normal operation 
       List<Jukebox> jukeboxes =  instance.getJukeboxesBySettingId(settingId, null, null, null);
       Assert.isTrue(jukeboxes.size() == 7, "Expecting 7 Jukeboxes");
       
       //Testing offset
       jukeboxes =  instance.getJukeboxesBySettingId(settingId, null, 1, null);
       Assert.isTrue(jukeboxes.size() == 6, "Expecting 6 Jukeboxes");
       
       //Testing Limit
       jukeboxes =  instance.getJukeboxesBySettingId(settingId, null, null, 1);
       Assert.isTrue(jukeboxes.size() == 1, "Expecting 1 Jukeboxes");
       
       //Testing Model
       jukeboxes =  instance.getJukeboxesBySettingId(settingId, model, null, null);
       Assert.isTrue(jukeboxes.size() == 3, "Expecting 3 Jukeboxes");
       
       //Testing all params at once 
       jukeboxes =  instance.getJukeboxesBySettingId(settingId, model, 1, 2);
       Assert.isTrue(jukeboxes.size() == 2, "Expecting 2 Jukeboxes");
       
       //Testing Universal Setting
       settingId = "aae445bf-72f0-4680-a23e-18fcf7241f8b";
       jukeboxes =  instance.getJukeboxesBySettingId(settingId, model, 1, 2);
       Assert.isTrue(jukeboxes.size() == 30, "Expecting 30 Jukeboxes");
       
       
   }
    
}
