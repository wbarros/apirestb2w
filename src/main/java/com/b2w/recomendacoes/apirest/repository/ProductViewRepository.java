package com.b2w.recomendacoes.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.b2w.recomendacoes.apirest.model.ProductView;

public interface ProductViewRepository extends JpaRepository<ProductView, Long>{
	
	//public final static String FIND_WITH_LIMIT = "SELECT p FROM Product p WHERE p.slug in :slug ORDER BY DESC p.score";

	//@Query(FIND_WITH_LIMIT)
	
}
