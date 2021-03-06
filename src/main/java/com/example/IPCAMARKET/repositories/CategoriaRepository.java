/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IPCAMARKET.repositories;

import com.example.IPCAMARKET.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Andy
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
    
    @Query(value="SELECT c FROM Categoria c where c.idCategoria=:idCategoria")
    Categoria buscarCategoriaById(@Param("idCategoria") Long idCategoria);
    
    @Query(value="SELECT c FROM Categoria c where c.nombre_categoria=:nombre_categoria")
    Categoria buscarProductosByName(@Param("nombre_categoria") String nombre_categoria);
    

    
    
    
    
}
