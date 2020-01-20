/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IPCAMARKET.repositories;

import com.example.IPCAMARKET.models.TipoMovimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Andy
 */
public interface TipoMovimientoRepository extends JpaRepository<TipoMovimiento, Long>{
    
    @Query(value="SELECT tm FROM TipoMovimiento tm where tm.idTipoMovimiento=:idTipoMovimiento")
    TipoMovimiento buscarTipoMovimientoById(@Param("idTipoMovimiento") Long idTipoMovimiento);
    
}
