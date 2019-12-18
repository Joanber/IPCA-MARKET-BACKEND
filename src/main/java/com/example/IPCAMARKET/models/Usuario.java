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
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUsuario;
    
    @Column(name = "nombre_usuario",nullable = true)
    private String nombre_usuario;
    
    @Column(name = "password_usuario", nullable = true)
    private String password_usuario;
    
    @JsonBackReference
    @JoinColumn(name = "idPersona")
    @ManyToOne(fetch = FetchType.LAZY)
    private Persona persona;
   

    
    
}
