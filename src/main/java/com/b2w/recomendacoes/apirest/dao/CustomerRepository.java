package com.b2w.recomendacoes.apirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.b2w.recomendacoes.apirest.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	public Customer findFirstBySlug(String slug);
}
