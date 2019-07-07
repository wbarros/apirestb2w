package com.b2w.recomendacoes.apirest.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.b2w.recomendacoes.apirest.dao.CustomerRepository;
import com.b2w.recomendacoes.apirest.dao.ProductRepository;
import com.b2w.recomendacoes.apirest.dao.ProductViewRepository;
import com.b2w.recomendacoes.apirest.exception.RecomendacoesException;
import com.b2w.recomendacoes.apirest.model.Customer;
import com.b2w.recomendacoes.apirest.model.Product;
import com.b2w.recomendacoes.apirest.model.ProductView;
import com.b2w.recomendacoes.apirest.model.ProductViewTO;
import com.b2w.recomendacoes.apirest.util.Util;

@Service
public class ProductViewService {
	
	@Autowired
	ProductViewRepository productViewRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public List<ProductViewTO> getProductsView() {
		List<ProductView> listProductView = productViewRepository.findAll(new Sort(Sort.Direction.DESC, "timeStamp"));
		List<ProductViewTO> listProductViewTO = productViewToProductViewTO(listProductView);
		
		return listProductViewTO;
	}
	
	public ResponseEntity<ProductView> addProductView(ProductViewTO productViewTO) throws RecomendacoesException {
		Customer customerPersist = customerRepository.findFirstBySlug(productViewTO.getCustomer());
		Product productPersist = productRepository.findFirstBySlug(productViewTO.getProduct());
		
		if(customerPersist == null || productPersist == null) 
			throw new RecomendacoesException("Produto e/ou Cliente não encontrado");
		ProductView productView = new ProductView();
		
		productView.setTimeStamp(new Date());
		productView.setCustomer(customerPersist);
		productView.setProduct(productPersist);
		
		ProductView productViewSaved = productViewRepository.save(productView);
		
		return new ResponseEntity<>(productViewSaved, HttpStatus.OK);
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
