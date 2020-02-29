/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IPCAMARKET.security.controller;

import com.example.IPCAMARKET.models.Usuario;
import com.example.IPCAMARKET.security.config.JwtTokenUtil;
import com.example.IPCAMARKET.security.config.JwtUser;
import com.example.IPCAMARKET.security.pojos.UserDTO;
import com.example.IPCAMARKET.servicePersonaUsuario.PersonaService;
import com.example.IPCAMARKET.utils.UnauthorizedException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
	
	@Value("${jwt.header}")
	private String tokenHeader;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PersonaService personaService;
    
    
    
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @CrossOrigin
    public ResponseEntity<UserDTO> login(@RequestBody Usuario user ,HttpServletRequest request,HttpServletResponse response){
    	try {
    		
			Authentication authentication=authenticationManager.
			authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
			final JwtUser userDetails=(JwtUser)authentication.getPrincipal();
			SecurityContextHolder.getContext().setAuthentication(authentication);
			final String token=jwtTokenUtil.generateToken(userDetails);
			response.setHeader("Token", token);
			return new ResponseEntity<UserDTO>(new UserDTO(userDetails.getUser(), token),HttpStatus.OK);
		} catch (Exception e) {
			throw new UnauthorizedException(e.getMessage());
		}
    }
    
    @PostMapping("/registrarse")
    public Usuario guardarUsuario(@RequestBody @Valid Usuario u) {
        return personaService.guardarUsuario(u);
    }
    
    @RequestMapping(value = "/login2",method = RequestMethod.POST)
    @CrossOrigin
    public Usuario login2(@RequestBody Usuario user){
    	try {
    		return user;
		} catch (Exception e) {
			throw new UnauthorizedException(e.getMessage()+"------------->>>>>>>>>>>>>>>>>>");
		}
    }
    

}
