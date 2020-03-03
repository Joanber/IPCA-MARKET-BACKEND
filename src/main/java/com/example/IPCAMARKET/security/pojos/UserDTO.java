package com.example.IPCAMARKET.security.pojos;

import java.io.Serializable;


public class UserDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6157524037792232887L;

	
	private final long id_user;
	private final String username;
	private final String rol;
	private final long id_persona;
	private final String token;
	
	
	public UserDTO(UserQuery u, String token) {
		super();
		this.id_user = u.getId();
		this.username = u.getUsername();
		this.rol = u.getRol();
		this.id_persona = u.getPersona();
		this.token = token;
	}

	public long getId_user() {
		return id_user;
	}


	public String getRol() {
		return rol;
	}

	public long getId_persona() {
		return id_persona;
	}

	public String getUsername() {
		return username;
	}

	public String getToken() {
		return token;
	}

	
	

}
