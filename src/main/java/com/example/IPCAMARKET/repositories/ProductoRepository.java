/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IPCAMARKET.repositories;

import com.example.IPCAMARKET.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Andy
 */
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    @Query(value = "SELECT pr FROM Producto pr where pr.idProducto=:idProducto")
    public Producto buscarPorId(@Param("idProducto") Long idProducto);
    
}
