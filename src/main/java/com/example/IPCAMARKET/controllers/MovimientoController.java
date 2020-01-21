/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IPCAMARKET.controllers;

import com.example.IPCAMARKET.models.Movimiento;
import com.example.IPCAMARKET.repositories.MovimientoRepository;
import com.example.IPCAMARKET.repositories.TipoMovimientoRepository;
import com.example.IPCAMARKET.repositories.UsuarioRepository;
import java.time.LocalDate;
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
@RequestMapping("/movimiento")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class MovimientoController {
    @Autowired
    private MovimientoRepository movimientoRepository;
    @Autowired
    private TipoMovimientoRepository tipoMovimientoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @GetMapping("/movimientos")
    public List<Movimiento> getAllMovimientos(){
        return this.movimientoRepository.findAll();
    }
    
    @PostMapping("/newmovimiento")
    public Movimiento guardarMovimiento(@RequestBody @Valid Movimiento m){
        Movimiento mov=new Movimiento();
        mov.setFecha_movimiento(LocalDate.now());
        mov.setObservacion_movimiento(m.getObservacion_movimiento());
        mov.setTipoMovimiento(tipoMovimientoRepository.buscarTipoMovimientoById(m.getTipoMovimiento().getIdTipoMovimiento()));
        mov.setUsuario(usuarioRepository.findbyId(m.getUsuario().getIdUsuario()));
        return this.movimientoRepository.save(mov);
    }
    
    @PutMapping(path = "/editar/{idMovimiento}")
    public Movimiento guardarMovimiento(@RequestBody Movimiento m, @PathVariable("idMovimiento") Long idMovimiento){
        Movimiento mov=this.movimientoRepository.buscarMovimientobyId(idMovimiento);
        if(mov.getIdMovimiento()!=null){
        mov.setFecha_movimiento(LocalDate.now());
        mov.setObservacion_movimiento(m.getObservacion_movimiento());
        mov.setTipoMovimiento(tipoMovimientoRepository.buscarTipoMovimientoById(m.getTipoMovimiento().getIdTipoMovimiento()));
        mov.setUsuario(usuarioRepository.findbyId(m.getUsuario().getIdUsuario()));
        return this.movimientoRepository.save(mov);
        }
        return mov;
    }
    
    @DeleteMapping("/delete/{idMovimiento}")
    public void eliminarMovimiento(@PathVariable("idMovimiento") Long idMovimiento){
        Movimiento mov=this.movimientoRepository.buscarMovimientobyId(idMovimiento);
        this.movimientoRepository.delete(mov);
    }
    
    @GetMapping("/{idMovimiento}")
    public Movimiento getMovimientoById(@PathVariable Long idMovimiento){
        return this.movimientoRepository.buscarMovimientobyId(idMovimiento);
    }
    
    
}
