/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IPCAMARKET.repositories;

import com.example.IPCAMARKET.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andy
 */
@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{
    
    @Query(value="SELECT r FROM Rol r where r.idRol=:idRol")
    Rol buscarRolById(@Param("idRol") Long idRol);
    
}
