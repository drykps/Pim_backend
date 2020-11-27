package com.pim.blockchain.storage.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.pim.blockchain.storage.BlockchainStorageApplicationTests;
import com.pim.blockchain.storage.entity.Endereco;

public class EnderecoServiceTest extends BlockchainStorageApplicationTests {
	
	@Autowired
	EnderecoService enderecoService;
	
	Endereco endereco;
	
//	@Before
//	public void setUp() {
//		endereco = new Endereco("Nome Mock Padrao", "Descricao Padrao");
//	}
	
//	@Test
//	public void deveIncluirEndereco() throws Exception {
//		
//		Optional<Endereco> novaEndereco = enderecoService.incluirEndereco(endereco);
//		
//		if(!novaEndereco.isPresent()) {
//			fail("Não incluiu a nova endereco");
//		};
//	}
//	
//	@Test
//	public void deveAtualizarEndereco() {
//			
//		Optional<Endereco> novaEndereco = enderecoService.incluirEndereco(endereco);
//		
//		endereco = novaEndereco.get().setDescricao("Nova Descricao");
//		
//		Optional<Endereco> enderecoAlterada = enderecoService.alterarEndereco(endereco);
//		
//		if(!enderecoAlterada.isPresent()) {
//			fail("Não alterou a nova endereco");
//		}
//		
//	};
//	
//	@Test
//	public void deveExcluirEndereco() {
//		Optional<Endereco> novaEndereco = enderecoService.incluirEndereco(endereco);
//		
//		enderecoService.excluirEndereco(novaEndereco.get().getId());
//				
//		Optional<Endereco> buscarEnderecoPeloId = enderecoService.buscarEnderecoPeloId(novaEndereco.get().getId());
//		
//		if( buscarEnderecoPeloId.isPresent() ) {
//			fail("Não excluiu a endereco");
//		}
//
//	};
//	
//	@Test
//	public void devebuscarEnderecoPorId() {
//		Optional<Endereco> novaEndereco = enderecoService.incluirEndereco(endereco);
//		
//		Optional<Endereco> buscarEnderecoPeloId = enderecoService.buscarEnderecoPeloId(novaEndereco.get().getId());
//		
//		if( !buscarEnderecoPeloId.isPresent() ) {
//			fail("Não trouxe a endereco");
//		}
//	};
//	
//	@Test
//	public void devebuscarTodasEnderecos() {
//		enderecoService.incluirEndereco(endereco.s("Endereco 1"));
//		enderecoService.incluirEndereco(endereco.setNome("Endereco 2"));
//		enderecoService.incluirEndereco(endereco.setNome("Endereco 3"));
//		
//		Page<Endereco> todasEnderecos = enderecoService.buscarTodasEnderecos(0, 10);
//		
//		Assert.assertEquals("Quantidades diferentes", todasEnderecos.getNumberOfElements(), 3); 
//	};
}
