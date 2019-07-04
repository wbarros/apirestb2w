package com.b2w.recomendacoes.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.b2w.recomendacoes.apirest.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	public final static String FIND_BY_SLUG = "SELECT c FROM Customer c WHERE c.slug = :slug";

	@Query(FIND_BY_SLUG)
	public Customer findBySlug(@Param("slug") String slug);
}
