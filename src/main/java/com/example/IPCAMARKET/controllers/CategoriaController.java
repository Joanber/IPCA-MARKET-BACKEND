/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IPCAMARKET.controllers;

import com.example.IPCAMARKET.models.Categoria;
import com.example.IPCAMARKET.repositories.CategoriaRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    
}
