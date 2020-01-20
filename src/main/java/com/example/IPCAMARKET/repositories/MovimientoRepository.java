/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IPCAMARKET.repositories;

import com.example.IPCAMARKET.models.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andy
 */
@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Long>{
    
    @Query(value="SELECT m FROM Movimiento m where m.idMovimiento=:idMovimiento")
    Movimiento buscarMovimientobyId(@Param("idMovimiento") Long idMovimiento);
    
}
