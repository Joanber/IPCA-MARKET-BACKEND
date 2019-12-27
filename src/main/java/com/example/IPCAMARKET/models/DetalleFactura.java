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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDetalleFactura;

    @Column(name = "cantidad_detalle_factura", nullable = false)
    private Integer cantidad_detalle_factura;

    @Column(name = "subtotal_detalle_factura", nullable = false)
    private double subtotal_detalle_factura;

    @Column(name = "total_detalle_factura", nullable = false)
    private double total_detalle_factura;

    @JsonBackReference
    @JoinColumn(name = "idProducto")
    @ManyToOne(fetch = FetchType.LAZY)
    private Producto producto;

    @JsonBackReference
    @JoinColumn(name = "idEncabezadoFactura")
    @ManyToOne(fetch = FetchType.LAZY)
    private EncabezadoFactura encabezadoFactura;

}
