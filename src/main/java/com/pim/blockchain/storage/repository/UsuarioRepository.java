package com.pim.blockchain.storage.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pim.blockchain.storage.entity.Usuario;

@Repository
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Integer> {
	
	Usuario findByEmail(String email);

	
}
