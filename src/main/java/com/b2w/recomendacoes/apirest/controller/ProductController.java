package com.b2w.recomendacoes.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.b2w.recomendacoes.apirest.model.Product;
import com.b2w.recomendacoes.apirest.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="API REST Product")

public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@ApiOperation(value = "Retorna todos os produtos")
	@RequestMapping(value = "/products",  method = { RequestMethod.GET } ,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Product> findAllProducts() {
		return productService.getProducts();
	}
	
	@ApiOperation(value = "Adiciona um novo produto")
	@RequestMapping(value = "/products",  method = { RequestMethod.POST })
	public @ResponseBody void saveProduct(@RequestBody Product product) {
		productService.addProduct(product);
	}
	
	
	
}
