package com.example.IPCAMARKET.security.pojos;

import java.io.Serializable;

import com.example.IPCAMARKET.models.Usuario;

public class UserDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6157524037792232887L;
	private Usuario user;
	private String token;
	public UserDTO(Usuario user, String token) {
		super();
		this.user = user;
		this.token = token;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	

}
