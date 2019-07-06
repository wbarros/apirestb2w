package com.b2w.recomendacoes.apirest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.b2w.recomendacoes.apirest.dao.ProductRepository;
import com.b2w.recomendacoes.apirest.model.Product;
import com.b2w.recomendacoes.apirest.model.RecommendationTO;

@Service
public class RecommendationsService {
	
	public final static String PRODUCT_1 = "product-1";
	public final static String PRODUCT_2 = "product-2";
	public final static String PRODUCT_3 = "product-3";
	
	@Autowired
	ProductRepository productRepository;
	
	public List<RecommendationTO> recommendationsProduct1(Integer limit) {
		String products[] = {PRODUCT_3};
		List<Product> listProduct = productRepository.findBySlugIn(products, PageRequest.of(0, limit, Sort.Direction.DESC, "score"));
		
		return productToRecommendationTO(listProduct);
	}
	
	public List<RecommendationTO> recommendationsProduct2(Integer limit) {
		String products[] = {PRODUCT_3};
		List<Product> listProduct = productRepository.findBySlugIn(products, PageRequest.of(0, limit, Sort.Direction.DESC, "score"));
		
		return productToRecommendationTO(listProduct);
	}
	
	public List<RecommendationTO> recommendationsProduct3(Integer limit) {
		String products[] = {PRODUCT_1,PRODUCT_2};
		List<Product> listProduct = productRepository.findBySlugIn(products, PageRequest.of(0, limit, Sort.Direction.DESC, "score"));
		
		return productToRecommendationTO(listProduct);
	}
	
	private List<RecommendationTO> productToRecommendationTO(List<Product> listProduct) {
		List<RecommendationTO> listRecommendationTO = new ArrayList<>();
		
		for(Product product : listProduct) {
			RecommendationTO recommendationTO = new RecommendationTO(product.getSlug(), product.getScore());
			listRecommendationTO.add(recommendationTO);
		}
		
		return listRecommendationTO;
	}
}
