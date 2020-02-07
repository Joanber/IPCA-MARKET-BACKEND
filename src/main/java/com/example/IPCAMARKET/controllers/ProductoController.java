/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IPCAMARKET.controllers;

import com.example.IPCAMARKET.InterfaceStrucProducto.CategoriaProductos;
import com.example.IPCAMARKET.models.Producto;
import com.example.IPCAMARKET.repositories.CategoriaRepository;
import com.example.IPCAMARKET.repositories.ProductoRepository;
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
@RequestMapping("/producto")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @GetMapping("/productos")
    public List<Producto> getAllProductos(){
        return this.productoRepository.findAll();
    }
    @PostMapping("/newproducto")
    public Producto guardarProducto(@RequestBody @Valid Producto p){
        Producto pro=new Producto();
        pro.setCodigoBarras_producto(p.getCodigoBarras_producto());
        pro.setNombre_producto(p.getNombre_producto());
        pro.setPrecio_producto(p.getPrecio_producto());
        pro.setCantidadActual_producto(p.getCantidadActual_producto());
        pro.setCantidadMin_producto(p.getCantidadMin_producto());
        pro.setFoto_producto(p.getFoto_producto());
        pro.setDescripcion_producto(p.getDescripcion_producto());
        pro.setCategoria(categoriaRepository.buscarCategoriaById(p.getCategoria().getIdCategoria()));
        return this.productoRepository.save(pro);
    }
    @PutMapping(path = "/editar/{idProducto}")
    public Producto editarProducto(@RequestBody Producto p, @PathVariable("idProducto") Long idProducto){
        Producto pro=this.productoRepository.buscarPorId(idProducto);
        if(pro.getIdProducto()!=null){
        pro.setCodigoBarras_producto(p.getCodigoBarras_producto());
        pro.setNombre_producto(p.getNombre_producto());
        pro.setPrecio_producto(p.getPrecio_producto());
        pro.setCantidadActual_producto(p.getCantidadActual_producto());
        pro.setCantidadMin_producto(p.getCantidadMin_producto());
        pro.setFoto_producto(p.getFoto_producto());
        pro.setDescripcion_producto(p.getDescripcion_producto());
        pro.setCategoria(categoriaRepository.buscarCategoriaById(p.getCategoria().getIdCategoria()));
        return this.productoRepository.save(pro);
        }
        return pro;
    }
    @DeleteMapping("/delete/{idProducto}")
    public void eliminarProducto(@PathVariable("idProducto") Long idProducto){
        Producto pro=this.productoRepository.buscarPorId(idProducto);
        this.productoRepository.delete(pro);
    }
    @GetMapping("/{idProducto}")
    public Producto getProductoById(@PathVariable Long idProducto){
        return this.productoRepository.buscarPorId(idProducto);
    }
//    @GetMapping("/categoriaProductos/{nombre_categoria}")
//    public List<CategoriaProductos> getProductosCategoria(@PathVariable String nombre_categoria){
//        return this.productoRepository.getCategoriaProductos(nombre_categoria);
//    }
    
}
