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
@Table(name = "tipoMovimiento")
public class TipoMovimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTipoMovimiento;

    @Column(name = "nombre_tipo_movimiento", nullable = false, length = 20)
    private String nombre_tipo_movimiento;

    @Column(name = "es_ingreso_tipo_movimiento", nullable = true)
    private boolean es_ingreso_tipo_movimiento;

    

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tipoMovimiento")
    private List<Movimiento> movimientos;

}
