/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IPCAMARKET.controllers;

import com.example.IPCAMARKET.models.Usuario;
import com.example.IPCAMARKET.repositories.UsuarioRepository;
import com.example.IPCAMARKET.servicePersonaUsuario.PersonaService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andy
 */
@RestController
@RequestMapping("/ipcaMarket")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class UsuarioController {
      @Autowired
      private UsuarioRepository usuarioRepository;
      
      @Autowired
      private PersonaService personaService;
    
      @GetMapping("/usuarios")
    public List<Usuario> seleccionar() {
        return this.usuarioRepository.findAll();
    }
    @PostMapping("/newusuario")
    public Usuario guardarUsuario(@RequestBody @Valid Usuario u){
        return personaService.guardarUsuario(u);
    }
    
}
