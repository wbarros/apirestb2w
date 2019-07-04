package com.b2w.recomendacoes.apirest.models.controller;

import java.util.ArrayList;
import java.util.Date;
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

import com.b2w.recomendacoes.apirest.model.Customer;
import com.b2w.recomendacoes.apirest.model.Product;
import com.b2w.recomendacoes.apirest.model.ProductView;
import com.b2w.recomendacoes.apirest.model.ProductViewTO;
import com.b2w.recomendacoes.apirest.repository.CustomerRepository;
import com.b2w.recomendacoes.apirest.repository.ProductRepository;
import com.b2w.recomendacoes.apirest.repository.ProductViewRepository;
import com.b2w.recomendacoes.apirest.util.Util;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="ProductViewController")

public class ProductViewController {
	
	@Autowired
	ProductViewRepository productViewRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@ApiOperation(value = "Products Views")
	@RequestMapping(value = "/product-views",  method = { RequestMethod.GET } ,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ProductViewTO> allProducts() {
		List<ProductView> listProductView = productViewRepository.findAll(new Sort(Sort.Direction.DESC, "timeStamp"));
		List<ProductViewTO> listProductTO = productViewToProductViewTO(listProductView);
		return listProductTO;
	}
	
	@RequestMapping(value = "/product-views",  method = { RequestMethod.POST })
	public @ResponseBody ResponseEntity<String> saveProductView(@RequestBody ProductViewTO productViewTO) {
		
		Customer customerPersist = customerRepository.findBySlug(productViewTO.getCustomer());
		Product productPersist = productRepository.findBySlug(productViewTO.getProduct());
		
		if(customerPersist == null || productPersist == null) 
			return new ResponseEntity<>("Produto e/ou cliente não encontrado", HttpStatus.INTERNAL_SERVER_ERROR);
		ProductView productView = new ProductView();
		
		productView.setTimeStamp(new Date());
		productView.setCustomer(customerPersist);
		productView.setProduct(productPersist);
		
		productViewRepository.save(productView);
		return new ResponseEntity<>("HTTP 200", HttpStatus.OK);
	}
	
	private List<ProductViewTO> productViewToProductViewTO(List<ProductView> listProductView) {
		List<ProductViewTO> listProductViewTO = new ArrayList<>();
		
		for(ProductView productView : listProductView) {
			ProductViewTO productViewTO = new ProductViewTO(Util.dateFormat(productView.getTimeStamp()), productView.getProduct().getSlug(), productView.getCustomer().getSlug());
			listProductViewTO.add(productViewTO);
		}
		
		return listProductViewTO;
	}
	
}
