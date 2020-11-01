package com.pim.blockchain.storage.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pim.blockchain.storage.entity.Endereco;

@Repository
public interface EnderecoRepository extends PagingAndSortingRepository<Endereco, Integer> {
	
}
