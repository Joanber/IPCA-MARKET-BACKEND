/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IPCAMARKET.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Skull
 */
@Entity
public class DetalleFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalleFactura;

    @Column(name = "cantidad_detalle_factura", nullable = false)
    private Integer cantidad_detalle_factura;

    @Column(name = "subtotal_detalle_factura", nullable = false)
    private double subtotal_detalle_factura;

    @Column(name = "total_detalle_factura", nullable = false)
    private double total_detalle_factura;

    @JsonBackReference(value="ref_detalle_factura_prod")
    @JoinColumn(name = "idProducto")
    @ManyToOne(fetch = FetchType.LAZY)
    private Producto producto;

    @JsonBackReference(value="ref_detalle_fac")
    @JoinColumn(name = "idEncabezadoFactura")
    @ManyToOne(fetch = FetchType.LAZY)
    private EncabezadoFactura encabezadoFactura;

    public DetalleFactura() {
    }

    public Long getIdDetalleFactura() {
        return idDetalleFactura;
    }

    public void setIdDetalleFactura(Long idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public Integer getCantidad_detalle_factura() {
        return cantidad_detalle_factura;
    }

    public void setCantidad_detalle_factura(Integer cantidad_detalle_factura) {
        this.cantidad_detalle_factura = cantidad_detalle_factura;
    }

    public double getSubtotal_detalle_factura() {
        return subtotal_detalle_factura;
    }

    public void setSubtotal_detalle_factura(double subtotal_detalle_factura) {
        this.subtotal_detalle_factura = subtotal_detalle_factura;
    }

    public double getTotal_detalle_factura() {
        return total_detalle_factura;
    }

    public void setTotal_detalle_factura(double total_detalle_factura) {
        this.total_detalle_factura = total_detalle_factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public EncabezadoFactura getEncabezadoFactura() {
        return encabezadoFactura;
    }

    public void setEncabezadoFactura(EncabezadoFactura encabezadoFactura) {
        this.encabezadoFactura = encabezadoFactura;
    }
    
    

}
