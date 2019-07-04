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

import com.b2w.recomendacoes.apirest.model.Customer;
import com.b2w.recomendacoes.apirest.model.CustomerTO;
import com.b2w.recomendacoes.apirest.repository.CustomerRepository;
import com.b2w.recomendacoes.apirest.util.Util;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="CustomerController")

public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@ApiOperation(value = "Customers")
	@RequestMapping(value = "/customers",  method = { RequestMethod.GET } ,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<CustomerTO> findAllCustomer() {
		List<Customer> listCustomer = customerRepository.findAll(new Sort(Sort.Direction.ASC, "name"));
		List<CustomerTO> listCustomerTO = customerToCustomerTO(listCustomer);
		
		return listCustomerTO;
	}
	
	@RequestMapping(value = "/customers",  method = { RequestMethod.POST })
	public @ResponseBody ResponseEntity<String> saveCustomer(@RequestBody Customer customer) {
		customer.setSlug(Util.toSlug(customer.getName()));
		customerRepository.save(customer);
		return new ResponseEntity<>("HTTP 200", HttpStatus.OK);
	}
	
	private List<CustomerTO> customerToCustomerTO(List<Customer> listCustomer) {
		List<CustomerTO> listCustomerTO = new ArrayList<>();
		
		for(Customer customer : listCustomer) {
			CustomerTO customerTO = new CustomerTO(customer.getName(), customer.getName());
			listCustomerTO.add(customerTO);
		}
		
		return listCustomerTO;
	}
	
}
