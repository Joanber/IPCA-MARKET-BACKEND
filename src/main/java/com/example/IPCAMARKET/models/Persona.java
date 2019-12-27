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
@Table(name = "persona")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPersona;

    @Column(name = "cedula_persona", unique = true, length = 15)
    private String cedula_persona;

    @Column(name = "primer_nombre_persona", nullable = false, length = 50)
    private String primer_nombre_persona;

    @Column(name = "segundo_nombre_persona", nullable = true, length = 50)
    private String segundo_nombre_persona;

    @Column(name = "primer_apellido_persona", nullable = false, length = 50)
    private String primer_apellido_persona;

    @Column(name = "segundo_apellido_persona", nullable = true, length = 50)
    private String segundo_apellido_persona;

    @Column(name = "telefono_persona", nullable = true, length = 15)
    private String telefono_persona;

    @Column(name = "direccion_persona", nullable = true, length = 150)
    private String direccion_persona;

    @Column(name = "email_persona", nullable = true, length = 75)
    private String email_persona;

    @Column(name = "fecha_nacimiento", nullable = true)
    private LocalDate fecha_nacimiento;

    @Column(name = "genero_persona", nullable = true, length = 30)
    private String genero_persona;

    @Column(name = "foto_persona", nullable = true)
    private byte foto_persona;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "persona")
    private List<Usuario> usuarios;

}
