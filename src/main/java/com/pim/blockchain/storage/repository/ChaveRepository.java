package com.pim.blockchain.storage.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pim.blockchain.storage.entity.Chave;

@Repository
public interface ChaveRepository extends PagingAndSortingRepository<Chave, Integer> {
	
}
