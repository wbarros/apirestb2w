package com.b2w.recomendacoes.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.b2w.recomendacoes.apirest.dao.ProductRepository;
import com.b2w.recomendacoes.apirest.model.Product;
import com.b2w.recomendacoes.apirest.util.Util;

@Service
public class ProductService {
	
	public final static String PRODUCT_1 = "product-1";
	public final static String PRODUCT_2 = "product-2";
	public final static String PRODUCT_3 = "product-3";
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getProducts() {
		List<Product> listProduct = productRepository.findAll(new Sort(Sort.Direction.ASC, "name"));
		
		return listProduct;
	}
	
	public Product addProduct(Product product) {
		product.setSlug(Util.toSlug(product.getName()));
		if(product.getSlug().equals(PRODUCT_1))
			product.setScore(1.0);
		else if (product.getSlug().equals(PRODUCT_2))
			product.setScore(0.8);
		else if (product.getSlug().equals(PRODUCT_3))
			product.setScore(1.0);
		else
			product.setScore(0.0);
		
		return productRepository.save(product);
	}
	
}
