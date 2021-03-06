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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andy
 */
@RestController 
@CrossOrigin(origins = "*")
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
    
    @DeleteMapping("/delete/{idCategoria}")
     public void eliminarCategoria(@PathVariable("idCategoria") Long idCategoria){
         Categoria ca=this.categoriaRepository.buscarCategoriaById(idCategoria);
         this.categoriaRepository.delete(ca);
         
     }
    
    @GetMapping("/{idCategoria}")
    public Categoria getCategoriaById(@PathVariable Long idCategoria){
        return this.categoriaRepository.buscarCategoriaById(idCategoria);
    }
    
    @GetMapping("/productosCategoria/{nombre_categoria}")
    public Categoria getProductosByCategoria(@PathVariable String nombre_categoria){
        return this.categoriaRepository.buscarProductosByName(nombre_categoria);
    }

    
}
