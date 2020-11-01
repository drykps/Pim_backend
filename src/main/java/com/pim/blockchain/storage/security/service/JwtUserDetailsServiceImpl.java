package com.pim.blockchain.storage.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pim.blockchain.storage.entity.Usuario;
import com.pim.blockchain.storage.security.jwt.JwtUserFactory;
import com.pim.blockchain.storage.service.UsuarioService;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Optional<Usuario> usuario = usuarioService.buscarUsuarioPorEmail( email );
		if( !usuario.isPresent() ) {
			throw new UsernameNotFoundException( String.format( "Nenhum usuário encontrado com o email '%s'", email ) );
		}
		
		return JwtUserFactory.create( usuario.get() );
	}
	
	
}
