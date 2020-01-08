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
@Table(name = "detalleMovimiento")
public class DetalleMovimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalleMovimiento;

    @Column(name = "cantidad_detalle_movimiento", nullable = false)
    private Integer cantidad_detalle_movimiento;

    @JsonBackReference(value="ref_detalle_movimientos")
    @JoinColumn(name = "idMovimiento")
    @ManyToOne(fetch = FetchType.LAZY)
    private Movimiento movimiento;

    @JsonBackReference
    @JoinColumn(name = "idProducto")
    @ManyToOne(fetch = FetchType.LAZY)
    private Producto producto;

    public DetalleMovimiento() {
    }

    public Long getIdDetalleMovimiento() {
        return idDetalleMovimiento;
    }

    public void setIdDetalleMovimiento(Long idDetalleMovimiento) {
        this.idDetalleMovimiento = idDetalleMovimiento;
    }

    public Integer getCantidad_detalle_movimiento() {
        return cantidad_detalle_movimiento;
    }

    public void setCantidad_detalle_movimiento(Integer cantidad_detalle_movimiento) {
        this.cantidad_detalle_movimiento = cantidad_detalle_movimiento;
    }

    public Movimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

}
