/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IPCAMARKET.controllers;

import com.example.IPCAMARKET.models.Persona;
import com.example.IPCAMARKET.repositories.PersonaRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Skull
 */
@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/ipcaMarket/p")
public class PersonaController {
    @Autowired
    private PersonaRepository personaRepository;
    
    @GetMapping("/personas")
    public List<Persona> getAllPersonas(){
        return personaRepository.findAll();
    }
    
    @PostMapping("/personas")
    public Persona guardarPersona(@Valid @RequestBody Persona persona){
        return personaRepository.save(persona);
    }
    
    
    
}
