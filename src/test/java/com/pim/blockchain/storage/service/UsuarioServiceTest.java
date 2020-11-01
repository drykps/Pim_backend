package com.pim.blockchain.storage.service;

import static org.junit.Assert.fail;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.pim.blockchain.storage.BlockchainStorageApplicationTests;
import com.pim.blockchain.storage.entity.Usuario;

public class UsuarioServiceTest extends BlockchainStorageApplicationTests {
	
	@Autowired
	UsuarioService usuarioService;
	
	Usuario usuario;
	
	@Before
	public void setUp() {
		usuario = new Usuario("email@blockchainstorage.com.br", "password123");
	}
	
	@Test
	public void deveIncluirUsuario() throws Exception {
		
		Optional<Usuario> novoUsuario = usuarioService.incluirUsuario(usuario);
		
		if(!novoUsuario.isPresent()) {
			fail("Não incluiu a novo usuario");
		};
	}
	
	@Test
	public void deveAtualizarUsuario() {
			
		Optional<Usuario> novoUsuario = usuarioService.incluirUsuario(usuario);
		
		novoUsuario.get().setSenha("NovaSenha123");
		
		Optional<Usuario> usuarioAlterado = usuarioService.alterarUsuario(novoUsuario.get());
		
		if(!usuarioAlterado.isPresent()) {
			fail("Não alterou a novo usuario");
		}
		
	};
	
	@Test
	public void deveExcluirUsuario() {
		Optional<Usuario> novoUsuario = usuarioService.incluirUsuario(usuario);
		
		usuarioService.excluirUsuario(novoUsuario.get().getId());
				
		Optional<Usuario> buscarUsuarioPeloId = usuarioService.buscarUsuarioPorId(novoUsuario.get().getId());
		
		if( buscarUsuarioPeloId.isPresent() ) {
			fail("Não excluiu a usuario");
		}

	};
	
	@Test
	public void devebuscarUsuarioPorId() {
		Optional<Usuario> novoUsuario = usuarioService.incluirUsuario(usuario);
		
		Optional<Usuario> buscarUsuarioPeloId = usuarioService.buscarUsuarioPorId(novoUsuario.get().getId());
		
		if( !buscarUsuarioPeloId.isPresent() ) {
			fail("Não trouxe a usuario");
		}
	};
	
	@Test
	public void devebuscarTodasUsuarios() {
		usuarioService.incluirUsuario(new Usuario("usuario1@blockchainstorage.com", "123456"));
		usuarioService.incluirUsuario(new Usuario("usuario2@blockchainstorage.com", "123456"));
		usuarioService.incluirUsuario(new Usuario("usuario3@blockchainstorage.com", "123456"));
		
		Page<Usuario> todasUsuarios = usuarioService.buscarTodosUsuarios(0, 10);
		
		Assert.assertEquals("Quantidades diferentes", todasUsuarios.getNumberOfElements(), 3); 
	};
}
