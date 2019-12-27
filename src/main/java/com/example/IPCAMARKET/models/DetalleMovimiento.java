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
import javax.persistence.Table;

/**
 *
 * @author Skull
 */
@Entity
@Table(name="detalleMovimiento")
public class DetalleMovimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDetalleMovimiento;
    
    @Column(name = "cantidad_detalle_movimiento",nullable = false)
    private Integer cantidad_detalle_movimiento;
    
    @JsonBackReference
    @JoinColumn(name = "idMovimiento")
    @ManyToOne(fetch = FetchType.LAZY)
    private Movimiento movimiento;
    
    @JsonBackReference
    @JoinColumn(name = "idProducto")
    @ManyToOne(fetch = FetchType.LAZY)
    private Producto producto;
   
}
