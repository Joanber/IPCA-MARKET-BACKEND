/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IPCAMARKET.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Skull
 */
@Entity
@Table(name = "persona")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;

    @Column(name = "cedula_persona",nullable = true,  length = 15)
    private String cedula_persona;

    @Column(name = "primer_nombre_persona", nullable = true, length = 50)
    private String primer_nombre_persona;

    @Column(name = "segundo_nombre_persona", nullable = false, length = 50)
    private String segundo_nombre_persona;

    @Column(name = "primer_apellido_persona", nullable = true, length = 50)
    private String primer_apellido_persona;

    @Column(name = "segundo_apellido_persona", nullable = false, length = 50)
    private String segundo_apellido_persona;

    @Column(name = "telefono_persona", nullable = false, length = 15)
    private String telefono_persona;

    @Column(name = "direccion_persona", nullable = false, length = 150)
    private String direccion_persona;

    @Column(name = "email_persona", nullable = false, length = 75)
    private String email_persona;

    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_nacimiento;

    @Column(name = "genero_persona", nullable = false, length = 30)
    private String genero_persona;

    @Column(name = "foto_persona", nullable = false)
    private String foto_persona;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "persona")
    private List<Usuario> usuarios;

    public Persona() {
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getCedula_persona() {
        return cedula_persona;
    }

    public void setCedula_persona(String cedula_persona) {
        this.cedula_persona = cedula_persona;
    }

    public String getPrimer_nombre_persona() {
        return primer_nombre_persona;
    }

    public void setPrimer_nombre_persona(String primer_nombre_persona) {
        this.primer_nombre_persona = primer_nombre_persona;
    }

    public String getSegundo_nombre_persona() {
        return segundo_nombre_persona;
    }

    public void setSegundo_nombre_persona(String segundo_nombre_persona) {
        this.segundo_nombre_persona = segundo_nombre_persona;
    }

    public String getPrimer_apellido_persona() {
        return primer_apellido_persona;
    }

    public void setPrimer_apellido_persona(String primer_apellido_persona) {
        this.primer_apellido_persona = primer_apellido_persona;
    }

    public String getSegundo_apellido_persona() {
        return segundo_apellido_persona;
    }

    public void setSegundo_apellido_persona(String segundo_apellido_persona) {
        this.segundo_apellido_persona = segundo_apellido_persona;
    }

    public String getTelefono_persona() {
        return telefono_persona;
    }

    public void setTelefono_persona(String telefono_persona) {
        this.telefono_persona = telefono_persona;
    }

    public String getDireccion_persona() {
        return direccion_persona;
    }

    public void setDireccion_persona(String direccion_persona) {
        this.direccion_persona = direccion_persona;
    }

    public String getEmail_persona() {
        return email_persona;
    }

    public void setEmail_persona(String email_persona) {
        this.email_persona = email_persona;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

   

    public String getGenero_persona() {
        return genero_persona;
    }

    public void setGenero_persona(String genero_persona) {
        this.genero_persona = genero_persona;
    }

    public String getFoto_persona() {
        return foto_persona;
    }

    public void setFoto_persona(String foto_persona) {
        this.foto_persona = foto_persona;
    }

   

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
