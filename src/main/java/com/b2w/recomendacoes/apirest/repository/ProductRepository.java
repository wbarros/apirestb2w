package com.b2w.recomendacoes.apirest.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.b2w.recomendacoes.apirest.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	public final static String FIND_BY_SLUG = "SELECT c FROM Product c WHERE c.slug = :slug";

	@Query(FIND_BY_SLUG)
	public Product findBySlug(@Param("slug") String slug);
	
	public List<Product> findBySlugIn(String[] slug, Pageable pageable);
}
