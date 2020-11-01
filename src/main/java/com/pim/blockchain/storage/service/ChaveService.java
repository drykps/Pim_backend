package com.pim.blockchain.storage.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.pim.blockchain.storage.entity.Chave;

public interface ChaveService {
	
	Optional<Chave> incluirChave(Chave chave);
	
	Optional<Chave> alterarChave(Chave chave);
	
	void excluirChave(int id);
	
	Optional<Chave> buscarChavePeloId(int id);
	
	Page<Chave> buscarTodasChaves(int pagina, int count);
	
}
