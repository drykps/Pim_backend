package com.pim.blockchain.storage.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pim.blockchain.storage.entity.Categoria;
import com.pim.blockchain.storage.entity.Chave;
import com.pim.blockchain.storage.repository.ChaveRepository;
import com.pim.blockchain.storage.service.CategoriaService;
import com.pim.blockchain.storage.service.ChaveService;

@Service
public class ChaveServiceImpl implements ChaveService {

	@Autowired
	private ChaveRepository chaveRepository;
	
	@Autowired
	private CategoriaService categoria;

	@Override
	public Optional<Chave> incluirChave(Chave chave) throws Exception {
		Optional<Categoria> categoriaBanco = categoria.buscarCategoriaPeloId(chave.getIdCategoria());
		if (!categoriaBanco.isPresent()) {
			throw new Exception("Categoria inexistente");
		}
		chave.setIdCategoria(categoriaBanco.get().getId());
		return Optional.ofNullable(chaveRepository.save(chave));
	}

	@Override
	public Optional<Chave> alterarChave(Chave chave) {
		return Optional.ofNullable(chaveRepository.save(chave));
	}

	@Override
	public void excluirChave(int id) {
		chaveRepository.deleteById(id);		
	}

	@Override
	public Optional<Chave> buscarChavePeloId(int id) {
		return chaveRepository.findById(id);
	}

	@Override
	public Page<Chave> buscarTodasChaves(int pagina, int count) {
		return chaveRepository.findAll( PageRequest.of( pagina, count) );
	}

}
