/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IPCAMARKET.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name = "movimiento")
public class Movimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMovimiento;

    @Column(name = "fecha_movimiento", nullable = false)
    private LocalDate fecha_movimiento;

    @Column(name = "observacion_movimiento", nullable = true, length = 150)
    private String observacion_movimiento;

    @JsonBackReference(value="ref_movimiento")
    @JoinColumn(name = "idTipoMovimiento")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoMovimiento tipoMovimiento;

    @JsonBackReference(value="ref_movimientos_usuario")
    @JoinColumn(name = "idUsuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @JsonManagedReference(value="ref_detalle_movimientos")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "movimiento")
    private List<DetalleMovimiento> detalleMovimientos;

    public Movimiento() {
    }

    public Long getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public LocalDate getFecha_movimiento() {
        return fecha_movimiento;
    }

    public void setFecha_movimiento(LocalDate fecha_movimiento) {
        this.fecha_movimiento = fecha_movimiento;
    }

    public String getObservacion_movimiento() {
        return observacion_movimiento;
    }

    public void setObservacion_movimiento(String observacion_movimiento) {
        this.observacion_movimiento = observacion_movimiento;
    }

    public TipoMovimiento getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<DetalleMovimiento> getDetalleMovimientos() {
        return detalleMovimientos;
    }

    public void setDetalleMovimientos(List<DetalleMovimiento> detalleMovimientos) {
        this.detalleMovimientos = detalleMovimientos;
    }

}
