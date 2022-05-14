package com.example.RestfulJukebox.controller;

import com.example.RestfulJukebox.service.JukeboxService;
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


@RestController
@RequestMapping("/jukeboxapi")
public class RestfulJukeboxController {
    
    @Autowired
    private JukeboxService jukeboxService;
	
    @GetMapping("/return_String/{input}")
    public String return_String(@PathVariable String input) {
        return "Hello World:  " + input;
    }

}

