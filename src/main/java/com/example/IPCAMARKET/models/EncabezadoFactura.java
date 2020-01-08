/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IPCAMARKET.models;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Skull
 */
@Entity
@Table(name = "encabezadoFactura")
public class EncabezadoFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEncabezadoFactura;

    @Column(name = "fecha_encabezadoFactura", nullable = false)
    private LocalDate fecha_encabezadoFactura;

    @Column(name = "nombreInstituto", nullable = true)
    private String nombreInstituto;

    @JsonManagedReference(value="ref_detalle_fac")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "encabezadoFactura")
    private List<DetalleFactura> detalleFacturas;

    public EncabezadoFactura() {
    }

    public Long getIdEncabezadoFactura() {
        return idEncabezadoFactura;
    }

    public void setIdEncabezadoFactura(Long idEncabezadoFactura) {
        this.idEncabezadoFactura = idEncabezadoFactura;
    }

    public LocalDate getFecha_encabezadoFactura() {
        return fecha_encabezadoFactura;
    }

    public void setFecha_encabezadoFactura(LocalDate fecha_encabezadoFactura) {
        this.fecha_encabezadoFactura = fecha_encabezadoFactura;
    }

    public String getNombreInstituto() {
        return nombreInstituto;
    }

    public void setNombreInstituto(String nombreInstituto) {
        this.nombreInstituto = nombreInstituto;
    }

    public List<DetalleFactura> getDetalleFacturas() {
        return detalleFacturas;
    }

    public void setDetalleFacturas(List<DetalleFactura> detalleFacturas) {
        this.detalleFacturas = detalleFacturas;
    }

}
