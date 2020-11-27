package com.pim.blockchain.storage.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.pim.blockchain.storage.entity.Categoria;
import com.pim.blockchain.storage.repository.CategoriaRepository;
import com.pim.blockchain.storage.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public Optional<Categoria> incluirCategoria(Categoria categoria) {
		
		return Optional.ofNullable(categoriaRepository.save(categoria));
	}

	@Override
	public Optional<Categoria> alterarCategoria(Categoria categoria) {
		return Optional.ofNullable(categoriaRepository.save(categoria));
	}

	@Override
	public void excluirCategoria(int id) {
		categoriaRepository.deleteById(id);		
	}

	@Override
	public Optional<Categoria> buscarCategoriaPeloId(int id) {
		return categoriaRepository.findById(id);
	}

	@Override
	public Page<Categoria> buscarTodasCategorias(int pagina, int count) {
		return categoriaRepository.findAll(PageRequest.of( pagina, count) );
	}

	
	
}
