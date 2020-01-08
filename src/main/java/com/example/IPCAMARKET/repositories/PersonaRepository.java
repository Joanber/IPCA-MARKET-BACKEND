/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IPCAMARKET.repositories;

import com.example.IPCAMARKET.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Skull
 */
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{
    
    
    @Query(value="SELECT p FROM Persona p where p.idPersona=:idPersona")
    Persona buscarPersonaById(@Param("idPersona") Long idPersona);
}
