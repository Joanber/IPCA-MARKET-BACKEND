package com.example.IPCAMARKET.security.config;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.example.IPCAMARKET.models.Usuario;



public class JwtuserFactory {

	public static JwtUser create(Usuario user) {
		
		return new JwtUser(user.getIdUsuario(),
				user.getUsername(), user.getPassword(), user,
				maptoGrantedAuthorities(new ArrayList<String>(Arrays.asList("Roles: " +user.getRol()))), user.isActivo());
	}

	private static List<GrantedAuthority> maptoGrantedAuthorities(List<String> authorities) {
		return authorities.stream().map(Authority -> new SimpleGrantedAuthority(Authority)).collect(Collectors.toList());
	}

}
