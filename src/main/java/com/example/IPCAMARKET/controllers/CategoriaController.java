/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IPCAMARKET.controllers;

import com.example.IPCAMARKET.models.Categoria;
import com.example.IPCAMARKET.repositories.CategoriaRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    
     @GetMapping("/categorias")
    public List<Categoria> getAllCategorias(){
        return categoriaRepository.findAll();
    }
    @PostMapping("/newcategoria")
    public Categoria guardarCategoria(@Valid @RequestBody Categoria categoria){
        return categoriaRepository.save(categoria);
    }
    
    
    @PutMapping("/editar/{idCategoria}")
    public Categoria editarCategoria(@RequestBody Categoria c ,@PathVariable("idCategoria") Long idCategoria){
        Categoria ca=this.categoriaRepository.buscarCategoriaById(idCategoria);
        if(ca.getIdCategoria()!=null){
            ca.setNombre_categoria(c.getNombre_categoria());
            ca.setDescripcion_categoria(c.getDescripcion_categoria());
            return this.categoriaRepository.save(ca);
        }
        return ca;
    }

    
}
