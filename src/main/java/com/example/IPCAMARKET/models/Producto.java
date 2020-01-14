/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IPCAMARKET.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String foto_producto;

    @JsonBackReference(value = "ref_categoria")
    @JoinColumn(name = "idCategoria", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Categoria categoria;

    @JsonManagedReference(value = "ref_detalle_factura_prod")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "producto")
    private List<DetalleFactura> detalleFacturas;

    public Producto() {
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodigoBarras_producto() {
        return codigoBarras_producto;
    }

    public void setCodigoBarras_producto(String codigoBarras_producto) {
        this.codigoBarras_producto = codigoBarras_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public double getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(double precio_producto) {
        this.precio_producto = precio_producto;
    }

    public double getCantidadActual_producto() {
        return cantidadActual_producto;
    }

    public void setCantidadActual_producto(double cantidadActual_producto) {
        this.cantidadActual_producto = cantidadActual_producto;
    }

    public double getCantidadMin_producto() {
        return cantidadMin_producto;
    }

    public void setCantidadMin_producto(double cantidadMin_producto) {
        this.cantidadMin_producto = cantidadMin_producto;
    }

    public String getFoto_producto() {
        return foto_producto;
    }

    public void setFoto_producto(String foto_producto) {
        this.foto_producto = foto_producto;
    }


    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<DetalleFactura> getDetalleFacturas() {
        return detalleFacturas;
    }

    public void setDetalleFacturas(List<DetalleFactura> detalleFacturas) {
        this.detalleFacturas = detalleFacturas;
    }

}
