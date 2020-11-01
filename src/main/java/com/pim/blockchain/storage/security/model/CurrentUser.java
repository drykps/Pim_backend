package com.pim.blockchain.storage.security.model;

import com.pim.blockchain.storage.entity.Usuario;

public class CurrentUser {
	private String token;
	private Usuario usuario;
	
	public CurrentUser(String token, Usuario usuario) {
		this.token = token;
		this.usuario = usuario;
	}
	
	public String getToken() {
		return token;
	}
	public CurrentUser setToken(String token) {
		this.token = token;
		return this;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public CurrentUser setUsuario(Usuario usuario) {
		this.usuario = usuario;
		return this;
	}
}
