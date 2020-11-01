package com.pim.blockchain.storage.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.pim.blockchain.storage.BlockchainStorageApplicationTests;
import com.pim.blockchain.storage.entity.Categoria;
import com.pim.blockchain.storage.entity.Usuario;

public class CategoriaServiceTest extends BlockchainStorageApplicationTests {
	
	@Autowired
	CategoriaService categoriaService;
	
	Categoria categoria;
	
	@Before
	public void setUp() {
		categoria = new Categoria(" Nome Mock Padrao ", "Descricao Padrao");
	}
	
	@Test
	public void deveIncluirCategoria() throws Exception {
		
		Optional<Categoria> novaCategoria = categoriaService.incluirCategoria(categoria);
		
		if(novaCategoria.isPresent()) {
			System.out.println("retornou " + novaCategoria.get());
			assertEquals("Nome Mock Padrao", novaCategoria.get().getNome());
		}else{
			System.out.print("não retornou");

		};
		
		if(!novaCategoria.isPresent()) {
			fail("Não incluiu a nova categoria");
		};
	}
	
	@Test
	public void deveAtualizarCategoria() {
			
		Optional<Categoria> novaCategoria = categoriaService.incluirCategoria(categoria);
		
		categoria = novaCategoria.get().setDescricao("Nova Descricao");
		
		Optional<Categoria> categoriaAlterada = categoriaService.alterarCategoria(categoria);
		
		if(!categoriaAlterada.isPresent()) {
			fail("Não alterou a nova categoria");
		}
		
	};
	
	@Test
	public void deveExcluirCategoria() {
		Optional<Categoria> novaCategoria = categoriaService.incluirCategoria(categoria);
		
		categoriaService.excluirCategoria(novaCategoria.get().getId());
				
		Optional<Categoria> buscarCategoriaPeloId = categoriaService.buscarCategoriaPeloId(novaCategoria.get().getId());
		
		if( buscarCategoriaPeloId.isPresent() ) {
			fail("Não excluiu a categoria");
		}

	};
	
	@Test
	public void devebuscarCategoriaPorId() {
		Optional<Categoria> novaCategoria = categoriaService.incluirCategoria(categoria);
		
		Optional<Categoria> buscarCategoriaPeloId = categoriaService.buscarCategoriaPeloId(novaCategoria.get().getId());
		
		if( !buscarCategoriaPeloId.isPresent() ) {
			fail("Não trouxe a categoria");
		}
	};
	
	@Test
	public void devebuscarTodasCategorias() {
		categoriaService.incluirCategoria( new Categoria("Categoria 1", "Desc 1") );
		categoriaService.incluirCategoria( new Categoria("Categoria 2", "Desc 2") );
		categoriaService.incluirCategoria( new Categoria("Categoria 3", "Desc 3") );
		
		Page<Categoria> todasCategorias = categoriaService.buscarTodasCategorias(0, 10);
		
		Assert.assertEquals("Quantidades diferentes", todasCategorias.getNumberOfElements(), 3); 
	};
}
