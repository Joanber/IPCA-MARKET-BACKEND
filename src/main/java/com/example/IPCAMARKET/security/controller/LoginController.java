/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IPCAMARKET.security.controller;

import com.example.IPCAMARKET.models.Usuario;
import com.example.IPCAMARKET.security.config.JwtTokenUtil;
import com.example.IPCAMARKET.security.config.JwtUserDetailsServiceImpl;
import com.example.IPCAMARKET.security.pojos.UserDTO;
import com.example.IPCAMARKET.security.repository.UserRepository;
import com.example.IPCAMARKET.servicePersonaUsuario.PersonaService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andy
 */
@RestController 
@CrossOrigin
public class LoginController {
	
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PersonaService personaService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUserDetailsServiceImpl userDetailService;
    
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @CrossOrigin
    public ResponseEntity<UserDTO> login(@RequestBody Usuario user ,HttpServletRequest request,HttpServletResponse response)throws Exception{
    	
			authenticate(user.getUsername(), user.getPassword());
			
			final UserDetails userDetails=userDetailService.loadUserByUsername(user.getUsername());
			final String token=jwtTokenUtil.generateToken(userDetails);
			return new ResponseEntity<UserDTO>(new UserDTO(userRepository.buscarPorUsername(user.getUsername()), token),HttpStatus.OK);
		
    }
    private void authenticate(String username, String password) throws Exception {
        try {
        	authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("User diseabled", e);
        } catch (BadCredentialsException e) {
            throw new Exception("Bad Credentianls", e);
        }
    }
    
    @PostMapping("/registrarse")
    public Usuario guardarUsuario(@RequestBody @Valid Usuario u) {
        return personaService.guardarUsuario(u);
    }
    
  
    

}
