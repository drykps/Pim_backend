package com.pim.blockchain.storage.service;

import static org.junit.Assert.fail;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.pim.blockchain.storage.BlockchainStorageApplicationTests;
import com.pim.blockchain.storage.entity.Chave;

public class ChaveServiceTest extends BlockchainStorageApplicationTests {
	
	@Autowired
	ChaveService chaveService;
	
	Chave chave;
	
	@Before
	public void setUp() {
		chave = new Chave("Nome Mock Padrao", "VALOR CHAVE");
	}
	
	@Test
	public void deveIncluirChave() throws Exception {
		
		Optional<Chave> novaChave = chaveService.incluirChave(chave);
		
		if(!novaChave.isPresent()) {
			fail("Não incluiu a nova chave");
		};
	}
	
	@Test
	public void deveAtualizarChave() {
			
		Optional<Chave> novaChave = chaveService.incluirChave(chave);
		
		chave = novaChave.get().setValorChave("NOVO VALOR CHAVE");
		
		Optional<Chave> chaveAlterada = chaveService.alterarChave(chave);
		
		if(!chaveAlterada.isPresent()) {
			fail("Não alterou a nova chave");
		}
		
	};
	
	@Test
	public void deveExcluirChave() {
		Optional<Chave> novaChave = chaveService.incluirChave(chave);
		
		chaveService.excluirChave(novaChave.get().getId());
				
		Optional<Chave> buscarChavePeloId = chaveService.buscarChavePeloId(novaChave.get().getId());
		
		if( buscarChavePeloId.isPresent() ) {
			fail("Não excluiu a chave");
		}

	};
	
	@Test
	public void devebuscarChavePorId() {
		Optional<Chave> novaChave = chaveService.incluirChave(chave);
		
		Optional<Chave> buscarChavePeloId = chaveService.buscarChavePeloId(novaChave.get().getId());
		
		if( !buscarChavePeloId.isPresent() ) {
			fail("Não trouxe a chave");
		}
	};
	
	@Test
	public void devebuscarTodasChaves() {
		chaveService.incluirChave( new Chave("Chave 1", "VALOR 1") );
		chaveService.incluirChave( new Chave("Chave 2", "VALOR 2") );
		chaveService.incluirChave( new Chave("Chave 3", "VALOR 3") );
		
		Page<Chave> todasChaves = chaveService.buscarTodasChaves(0, 10);
		
		Assert.assertEquals("Quantidades diferentes", todasChaves.getNumberOfElements(), 3); 
	};
}
