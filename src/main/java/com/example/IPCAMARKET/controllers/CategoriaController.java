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
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/ipcaMarket/c")
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    
    @RequestMapping(value = "/newcategoria", method = RequestMethod.POST, headers = "Accept=application/json",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Categoria guardarCategoria(@Valid @RequestBody Categoria categoria){
        return categoriaRepository.save(categoria);
    }
    
    @RequestMapping(value = "/categorias", method = RequestMethod.GET, headers = "Accept=application/json",consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Categoria> getAllCategorias(){
        return categoriaRepository.findAll();
    }
    
//    @PutMapping("/editar/{idCategoria}")
//    public 

    
}
