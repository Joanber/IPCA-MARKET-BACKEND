/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IPCAMARKET.servicePersonaUsuario;

import com.example.IPCAMARKET.models.Persona;
import com.example.IPCAMARKET.models.Usuario;
import com.example.IPCAMARKET.repositories.PersonaRepository;
import com.example.IPCAMARKET.repositories.RolRepository;
import com.example.IPCAMARKET.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andy
 */
@Service
public class PersonaService {

    @Autowired
    private PasswordEncoder bCryptEncoder;

    @Autowired
    private PersonaRepository repPersona;

    @Autowired
    private UsuarioRepository repUsuario;

    @Autowired
    private RolRepository rolRepository;

    public Persona guardarPersona(Persona p) {
        return repPersona.save(p);
    }

    public Usuario guardarUsuario(Usuario u) {
        Usuario user = new Usuario();
        user.setNombre_usuario(u.getNombre_usuario());
        user.setPassword_usuario(u.getPassword_usuario());
        user.setPersona(repPersona.buscarPersonaById(u.getPersona().getIdPersona()));
        user.setRol(rolRepository.buscarRolById(u.getRol().getIdRol()));
        encriptaPass(user);

        return repUsuario.save(user);
    }

    public void encriptaPass(Usuario u) {
        u.setPassword_usuario(bCryptEncoder.
                encode(u.getPassword_usuario()));
    }

}
