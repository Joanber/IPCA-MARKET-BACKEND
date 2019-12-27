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
@Table(name="encabezadoFactura")
public class EncabezadoFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEncabezadoFactura;
    
    @Column(name = "fecha_encabezadoFactura" ,nullable = false)
    private LocalDate fecha_encabezadoFactura;
    
    @Column(name = "nombreInstituto" ,nullable = true)
    private String nombreInstituto;
    
     @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "encabezadoFactura")
    private List<DetalleFactura> detalleFacturas;   

    
}
