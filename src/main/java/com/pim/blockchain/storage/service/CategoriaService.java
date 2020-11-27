package com.pim.blockchain.storage.service;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.pim.blockchain.storage.entity.Categoria;

public interface CategoriaService {
	
	Optional<Categoria> incluirCategoria(Categoria categoria);
	
	Optional<Categoria> alterarCategoria(Categoria categoria);
	
	void excluirCategoria(int id);
	
	Optional<Categoria> buscarCategoriaPeloId(int id);
	
	Page<Categoria> buscarTodasCategorias(int pagina, int count);

//	Page<Categoria> buscarTodasCategoriasAtivas(Categoria categoria, int page, int count);


}
