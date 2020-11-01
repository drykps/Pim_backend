package com.pim.blockchain.storage.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pim.blockchain.storage.entity.Endereco;
import com.pim.blockchain.storage.repository.EnderecoRepository;
import com.pim.blockchain.storage.service.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Override
	public Optional<Endereco> incluirEndereco(Endereco endereco) {
		return Optional.ofNullable(enderecoRepository.save(endereco));
	}

	@Override
	public Optional<Endereco> alterarEndereco(Endereco endereco) {
		return Optional.ofNullable(enderecoRepository.save(endereco));
	}

	@Override
	public void excluirEndereco(int id) {
		enderecoRepository.deleteById(id);		
	}

	@Override
	public Optional<Endereco> buscarEnderecoPeloId(int id) {
		return enderecoRepository.findById(id);
	}

	@Override
	public Page<Endereco> buscarTodasEnderecos(int pagina, int count) {
		return enderecoRepository.findAll( PageRequest.of( pagina, count) );
	}

}
