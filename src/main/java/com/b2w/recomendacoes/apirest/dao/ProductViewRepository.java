package com.b2w.recomendacoes.apirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.b2w.recomendacoes.apirest.model.ProductView;

public interface ProductViewRepository extends JpaRepository<ProductView, Long>{

}
