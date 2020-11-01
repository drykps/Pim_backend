package com.pim.blockchain.storage.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.pim.blockchain.storage.entity.Usuario;

public interface UsuarioService {
	
	Optional<Usuario> buscarUsuarioPorEmail(String email);
	
	Optional<Usuario> incluirUsuario(Usuario usuario);
	
	Optional<Usuario> alterarUsuario(Usuario usuario);
	
	Optional<Usuario> buscarUsuarioPorId(int id);
	
	void excluirUsuario(int id);
	
	Page<Usuario> buscarTodosUsuarios(int pagina, int count);

}
