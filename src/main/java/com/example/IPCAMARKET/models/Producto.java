/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IPCAMARKET.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Skull
 */
@Entity
@Table(name = "producto")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProducto;

    @Column(name = "codigoBarras_producto", nullable = false, length = 25)
    private String codigoBarras_producto;

    @Column(name = "nombre_producto", nullable = false, length = 300)
    private String nombre_producto;

    @Column(name = "precio_producto", nullable = false)
    private double precio_producto;

    @Column(name = "cantidadActual_producto", nullable = false)
    private double cantidadActual_producto;

    @Column(name = "cantidadMin_producto", nullable = false)
    private double cantidadMin_producto;

    @Column(name = "foto_producto", nullable = true)
    private byte foto_producto;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "producto")
    private List<Categoria> categorias;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "producto")
    private List<DetalleFactura> detalleFacturas;

}
