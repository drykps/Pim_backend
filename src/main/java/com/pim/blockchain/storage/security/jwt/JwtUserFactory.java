package com.pim.blockchain.storage.security.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.pim.blockchain.storage.entity.Usuario;
import com.pim.blockchain.storage.enums.TipoUsuarioEnum;

public class JwtUserFactory {
	
	private JwtUserFactory() {
		
	}
	
	public static JwtUser create(Usuario usuario) {
		return new JwtUser(
				usuario.getId(),
				usuario.getEmail(),
				usuario.getSenha(),
				mapToGrantedAuthorities( usuario.getTipoUsuario() )
				);
	}
	
	private static List<GrantedAuthority> mapToGrantedAuthorities(TipoUsuarioEnum tipoUsuario) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add( new SimpleGrantedAuthority( tipoUsuario.toString() )  );
		return authorities;
	}
	
	
}
