/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IPCAMARKET.controllers;

import com.example.IPCAMARKET.exception.ResourceNotFoundException;
import com.example.IPCAMARKET.models.Persona;
import com.example.IPCAMARKET.models.Producto;
import com.example.IPCAMARKET.repositories.PersonaRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Skull
 */
@RestController 
@CrossOrigin(origins = "http://localhost:4200",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
@RequestMapping("/ipcaMarket")
public class PersonaController {
    @Autowired
    private PersonaRepository personaRepository;
    
    @GetMapping("/personas")
    public List<Persona> getAllPersonas(){
        return personaRepository.findAll();
    }
    
    @RequestMapping(value = "/newpersona", method = RequestMethod.POST, headers = "Accept=application/json",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Persona guardarPersona(@Valid @RequestBody Persona persona){
        return personaRepository.save(persona);
    }
    
   @GetMapping("/persona/{idPersona}")
   public Persona getProductoById(@PathVariable Long idPersona){
       return this.personaRepository.buscarPersonaById(idPersona);
   }
    
    
}
