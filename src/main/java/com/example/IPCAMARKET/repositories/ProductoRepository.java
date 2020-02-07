/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IPCAMARKET.repositories;

import com.example.IPCAMARKET.InterfaceStrucProducto.CategoriaProductos;
import com.example.IPCAMARKET.models.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Andy
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query(value = "SELECT pr FROM Producto pr where pr.idProducto=:idProducto")
    public Producto buscarPorId(@Param("idProducto") Long idProducto);

  
//    @Query(value = "SELECT array_to_json(\n" +
//"array_agg(p.*)) AS productos FROM \n" +
//"(SELECT p.id_producto,\n" +
//"p.nombre_producto,\n" +
//"p.foto_producto,\n" +
//"p.precio_producto\n" +
//"FROM producto p \n" +
//"JOIN categoria c \n" +
//"on p.id_categoria=c.id_categoria\n" +
//"WHERE c.nombre_categoria=:Snack\n" +
//")AS p", nativeQuery = true)
//    public List<CategoriaProductos> getCategoriaProductos(@Param("nombre_categoria")String nombre_categoria);
    

}
