package com.pim.blockchain.storage.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pim.blockchain.storage.entity.Usuario;
import com.pim.blockchain.storage.repository.UsuarioRepository;
import com.pim.blockchain.storage.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Optional<Usuario> buscarUsuarioPorEmail(String email) {
		return Optional.ofNullable( this.usuarioRepository.findByEmail( email ) );
	}

	@Override
	public Optional<Usuario> incluirUsuario(Usuario usuario) {
		return Optional.ofNullable( this.usuarioRepository.save( usuario ) );
	}
	
	@Override
	public Optional<Usuario> alterarUsuario(Usuario usuario) {
		return Optional.ofNullable( this.usuarioRepository.save( usuario ) );
	}

	@Override
	public Optional<Usuario> buscarUsuarioPorId(int id) {
		return this.usuarioRepository.findById( id );
	}

	@Override
	public void excluirUsuario(int id) {
		this.usuarioRepository.deleteById( id  );	
	}

	@Override
	public Page<Usuario> buscarTodosUsuarios(int pagina, int count) {
		return this.usuarioRepository.findAll( PageRequest.of( pagina, count) );
	}

}
