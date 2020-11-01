package com.pim.blockchain.storage.security.jwt;

import java.io.Serializable;

public class JwtAuthenticationRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private String email;
	private String password;
	
	public JwtAuthenticationRequest() {
		super();
	}

	public JwtAuthenticationRequest(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public JwtAuthenticationRequest setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPassword() {
		return password;
	}
	
	public JwtAuthenticationRequest setPassword(String password) {
		this.password = password;
		return this;
	}

}
