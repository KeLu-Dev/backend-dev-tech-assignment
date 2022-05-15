package com.example.RestfulJukebox.controller;
import com.example.RestfulJukebox.entity.Jukebox;
import com.example.RestfulJukebox.entity.Setting;
import com.example.RestfulJukebox.service.JukeboxService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author GrQuil
 */
@RestController
@RequestMapping("/jukeboxapi")
public class RestfulJukeboxController {
    
    @Autowired
    private JukeboxService jukeboxService;
	
    /**
     *
     * @param settingId
     * @param model
     * @param offset
     * @param limit
     * @return
     * @throws java.lang.Exception
     */
    @GetMapping("/jukeboxes")
    public List<Jukebox> returnSettingJukeboxes(@RequestParam(required=true) String settingId, @RequestParam(required=false) String model, 
                                                @RequestParam(required=false) Integer offset,@RequestParam(required=false) Integer limit ) throws Exception {

        List<Jukebox> jukeboxesById= jukeboxService.getJukeboxesBySettingId(settingId, model, offset,limit);
        return jukeboxesById;
    }

}

