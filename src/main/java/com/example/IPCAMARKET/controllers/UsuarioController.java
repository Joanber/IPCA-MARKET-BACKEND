/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IPCAMARKET.controllers;

import com.example.IPCAMARKET.models.Usuario;
import com.example.IPCAMARKET.repositories.PersonaRepository;
import com.example.IPCAMARKET.repositories.RolRepository;
import com.example.IPCAMARKET.repositories.UsuarioRepository;
import com.example.IPCAMARKET.servicePersonaUsuario.PersonaService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PersonaService personaService;
    
    @Autowired
    private PersonaRepository repPersona;
    
    @Autowired
    private RolRepository rolRepository;

    @GetMapping("/usuarios")
    public List<Usuario> getAllUsuarios() {
        return this.usuarioRepository.findAll();
    }

    @PostMapping("/newusuario")
    public Usuario guardarUsuario(@RequestBody @Valid Usuario u) {
        return personaService.guardarUsuario(u);
    }

    @PutMapping(path = "/editar/{id}")
    public Usuario editarUsuario(@RequestBody Usuario u, @PathVariable("id") Long id) {
        Usuario user = this.usuarioRepository.findbyId(id);
        if (user.getIdUsuario() != null) {
        	user.setActivo(u.isActivo());
            user.setUsername(u.getUsername());
            user.setPersona(repPersona.buscarPersonaById(u.getPersona().getIdPersona()));
            user.setRol(rolRepository.buscarRolById(u.getRol().getIdRol()));
            personaService.encriptaPass(user);
            return usuarioRepository.save(user);
        }
        return user;
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarUsuario(@PathVariable("id") Long id) {
        Usuario user = this.usuarioRepository.findbyId(id);
        this.usuarioRepository.delete(user);
    }

    @GetMapping("/{idUsuario}")
    public Usuario getUsuariobyId(@PathVariable Long idUsuario){
        return this.usuarioRepository.findbyId(idUsuario);
    }

    

}
