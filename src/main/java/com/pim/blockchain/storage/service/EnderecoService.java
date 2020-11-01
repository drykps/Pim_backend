package com.pim.blockchain.storage.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.pim.blockchain.storage.entity.Endereco;

public interface EnderecoService {
	
	Optional<Endereco> incluirEndereco(Endereco endereco);
	
	Optional<Endereco> alterarEndereco(Endereco endereco);
	
	void excluirEndereco(int id);
	
	Optional<Endereco> buscarEnderecoPeloId(int id);
	
	Page<Endereco> buscarTodasEnderecos(int pagina, int count);

}
