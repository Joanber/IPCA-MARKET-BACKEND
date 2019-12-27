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
@Table(name = "categoria")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCategoria;

    @Column(name = "nombre_categoria", nullable = false, length = 100)
    private String nombre_categoria;

    @Column(name = "descripcion_categoria", nullable = true, length = 150)
    private String descripcion_categoria;

    @JsonBackReference
    @JoinColumn(name = "idProducto")
    @ManyToOne(fetch = FetchType.LAZY)
    private Producto producto;

}
