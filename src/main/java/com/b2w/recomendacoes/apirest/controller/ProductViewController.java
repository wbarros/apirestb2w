package com.b2w.recomendacoes.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.b2w.recomendacoes.apirest.exception.RecomendacoesException;
import com.b2w.recomendacoes.apirest.model.ProductViewTO;
import com.b2w.recomendacoes.apirest.service.ProductViewService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="API REST ProductView")

public class ProductViewController {
	
	@Autowired
	ProductViewService productViewService;
	
	@ApiOperation(value = "Retorna todos os ProductViews")
	@RequestMapping(value = "/product-views",  method = { RequestMethod.GET } ,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ProductViewTO> findAllProductView() {
		return productViewService.getProductsView();
	}
	
	@ApiOperation(value = "Adiciona um ProductViews")
	@RequestMapping(value = "/product-views",  method = { RequestMethod.POST })
	public @ResponseBody ResponseEntity<String> saveProductView(@RequestBody ProductViewTO productViewTO) {
		try {
			productViewService.addProductView(productViewTO);
		} catch (RecomendacoesException e) {
			return new ResponseEntity<>(e.getMensagem(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
}
