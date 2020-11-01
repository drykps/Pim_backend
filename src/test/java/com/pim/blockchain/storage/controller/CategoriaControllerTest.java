package com.pim.blockchain.storage.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.pim.blockchain.storage.BlockchainStorageApplicationTests;

public class CategoriaControllerTest extends BlockchainStorageApplicationTests {
	
	private MockMvc mockMvc;
	
	@Autowired
	private CategoriaController categoriaController;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(categoriaController).build();
	}
	
	@Test
	public void deveIncluirCategoriaComSucesso() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post("/categoria").param("nome", "Teste Controller")
																	  .param("descricao", "Descricao Teste"))
												   .andExpect(MockMvcResultMatchers.status().isOk());
	}
	
//	public void deveAtualizarCategoria() {
//		
//	};
//	
//	public void deveExcluirCategoria() {
//		
//	};
//	
//	public void devebuscarCategoriaPorId() {
//		
//	};
//	
//	public void devebuscarTodasCategorias() {
//		
//	};
}
