package com.b2w.recomendacoes.apirest.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.b2w.recomendacoes.apirest.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	public Product findFirstBySlug(String slug);
	public List<Product> findBySlugIn(String[] slug, Pageable pageable);
}
