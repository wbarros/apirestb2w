package com.b2w.recomendacoes.apirest.models.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.b2w.recomendacoes.apirest.model.Product;
import com.b2w.recomendacoes.apirest.model.ProductTO;
import com.b2w.recomendacoes.apirest.repository.ProductRepository;
import com.b2w.recomendacoes.apirest.util.Util;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="ProductController")

public class ProductController {
	
//	@Autowired
//	private SincronizacaoService sincronizacaoService;
	
	@Autowired
	ProductRepository productRepository;
	
	@ApiOperation(value = "Products")
	@RequestMapping(value = "/products",  method = { RequestMethod.GET } ,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ProductTO> findAllProducts() {
		List<Product> listProduct = productRepository.findAll(new Sort(Sort.Direction.ASC, "name"));
		List<ProductTO> listProductTO = productToProductTO(listProduct);
		
		return listProductTO;
	}
	
	@RequestMapping(value = "/products",  method = { RequestMethod.POST })
	public @ResponseBody ResponseEntity<String> saveProduct(@RequestBody Product product) {
		product.setSlug(Util.toSlug(product.getName()));
		productRepository.save(product);
		return new ResponseEntity<>("HTTP 200", HttpStatus.OK);
	}
	
	private List<ProductTO> productToProductTO(List<Product> listProduct) {
		List<ProductTO> listProductTO = new ArrayList<>();
		
		for(Product product : listProduct) {
			ProductTO productTO = new ProductTO(product.getName(), product.getName());
			listProductTO.add(productTO);
		}
		
		return listProductTO;
	}
	
}
