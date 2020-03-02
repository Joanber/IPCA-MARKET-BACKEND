package com.example.IPCAMARKET.security.pojos;

import java.io.Serializable;


public class UserDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6157524037792232887L;

	
	private final long id_user;
	private final String username;
	private final long id_rol;
	private final long id_persona;
	private final String token;
	
	
	public UserDTO(UserQuery u, String token) {
		super();
		this.id_user = u.getId();
		this.username = u.getUsername();
		this.id_rol = u.getRol();
		this.id_persona = u.getPersona();
		this.token = token;
	}

	public long getId_user() {
		return id_user;
	}


	public String getUsername() {
		return username;
	}


	public long getId_rol() {
		return id_rol;
	}


	public long getId_persona() {
		return id_persona;
	}
	public String getToken() {
		return token;
	}

	
	

}
