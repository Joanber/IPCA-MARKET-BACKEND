/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IPCAMARKET.controllers;

import com.example.IPCAMARKET.models.TipoMovimiento;
import com.example.IPCAMARKET.repositories.TipoMovimientoRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andy
 */
@RestController
@RequestMapping("/tipoMovimiento")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class TipoMovimientoController {
    
    @Autowired
    private TipoMovimientoRepository tipoMovimientoRepository;
    
    @GetMapping("/tipoMovimientos")
    public List<TipoMovimiento> getAllTipoMovimientos(){
        return this.tipoMovimientoRepository.findAll();
    }
    
    @PostMapping("/newTipoMovimiento")
    public TipoMovimiento guardarTipoM(@RequestBody @Valid TipoMovimiento tm){
        return this.tipoMovimientoRepository.save(tm);
    }
    
    @PutMapping("/editar/{idTipoMovimiento}")
    public TipoMovimiento editarTipoMovimiento(@RequestBody TipoMovimiento tm, @PathVariable("idTipoMovimiento") Long idTipoMovimiento){
        TipoMovimiento tip_movi=this.tipoMovimientoRepository.buscarTipoMovimientoById(idTipoMovimiento);
        if(tip_movi.getIdTipoMovimiento()!=null){
            tip_movi.setNombre_tipo_movimiento(tm.getNombre_tipo_movimiento());
            return this.tipoMovimientoRepository.save(tip_movi);
        }
        return tip_movi;
    }
    
     @DeleteMapping("/delete/{idTipoMovimiento}")
     public void eliminarTipoM(@PathVariable("idTipoMovimiento") Long idTipoMovimiento){
        TipoMovimiento tip_movi=this.tipoMovimientoRepository.buscarTipoMovimientoById(idTipoMovimiento);
         this.tipoMovimientoRepository.delete(tip_movi);
     }
     @GetMapping("/{idTipoMovimiento}")
     public TipoMovimiento getTipoMovimientoById(@PathVariable("idTipoMovimiento") Long idTipoMovimiento){
         return this.tipoMovimientoRepository.buscarTipoMovimientoById(idTipoMovimiento);
     }
    
}
