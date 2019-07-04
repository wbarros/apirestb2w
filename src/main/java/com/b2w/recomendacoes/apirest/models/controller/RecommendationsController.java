package com.b2w.recomendacoes.apirest.models.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.b2w.recomendacoes.apirest.model.Product;
import com.b2w.recomendacoes.apirest.model.RecommendationTO;
import com.b2w.recomendacoes.apirest.repository.ProductRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="RecommendationsController")
@RequestMapping(value = "/recommendations")
public class RecommendationsController {
	
	public final static String PRODUCT_1 = "product-1";
	public final static String PRODUCT_2 = "product-2";
	public final static String PRODUCT_3 = "product-3";
	
	@Autowired
	ProductRepository productRepository;
	
	@ApiOperation(value = "Products Views")
	@RequestMapping(value = "/product-1",  method = { RequestMethod.GET } ,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<RecommendationTO> recommendationsProduct1(Integer limit) {
		String products[] = {PRODUCT_3};
		List<Product> listProduct = productRepository.findBySlugIn(products, PageRequest.of(0, 2, Sort.Direction.DESC, "score"));
		
		return productToRecommendationTO(listProduct);
	}
	
	@RequestMapping(value = "/product-2",  method = { RequestMethod.GET } ,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<RecommendationTO> recommendationsProduct2(String limit) {
		List<RecommendationTO> listRecommendationTO = new ArrayList<>();
		
		return listRecommendationTO;
	}
	
	@RequestMapping(value = "/product-3",  method = { RequestMethod.GET } ,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<RecommendationTO> recommendationsProduct3(String limit) {
		List<RecommendationTO> listRecommendationTO = new ArrayList<>();
		
		return listRecommendationTO;
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
