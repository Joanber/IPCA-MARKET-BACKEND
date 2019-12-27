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
@Table(name = "rol")
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRol;

    @Column(name = "nombre_rol", nullable = false, length = 50)
    private String nombre_rol;

    @Column(name = "descripcion_rol", nullable = true, length = 100)
    private String descripcion_rol;

    @JsonBackReference
    @JoinColumn(name = "idUsuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

}
