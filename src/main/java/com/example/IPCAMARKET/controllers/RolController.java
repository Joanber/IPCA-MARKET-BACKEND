/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IPCAMARKET.controllers;

import com.example.IPCAMARKET.models.Rol;
import com.example.IPCAMARKET.repositories.RolRepository;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andy
 */
@RestController
@RequestMapping("/rol")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class RolController {
    @Autowired
    private RolRepository rolRepository;
    
     @GetMapping("/roles")
     public List<Rol> getAllRoles(){
         return this.rolRepository.findAll();
     }
     
    @PostMapping("/newrol")
    public Rol guardarRol(@RequestBody @Valid Rol r){
        return this.rolRepository.save(r);
    }
    
    @PutMapping(path = "/editar/{idRol}")
    public Rol editarRol(@RequestBody Rol r,@PathVariable("idRol") Long idRol){
        Rol rl=this.rolRepository.buscarRolById(idRol);
        if(rl.getIdRol()!=null){
            rl.setNombre_rol(r.getNombre_rol());
            rl.setDescripcion_rol(r.getDescripcion_rol());
            return  this.rolRepository.save(rl);
        }
        return rl;
    }
    
     @DeleteMapping("/delete/{idRol}")
     public void eliminarRol(@PathVariable("idRol") Long idRol){
         Rol r=this.rolRepository.buscarRolById(idRol);
         this.rolRepository.delete(r);
     }
     
    @GetMapping("/{idRol}")
    public Rol getRolById(@PathVariable Long idRol){
        return this.rolRepository.buscarRolById(idRol);
    }
            
    
}
