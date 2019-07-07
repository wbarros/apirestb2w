package com.b2w.recomendacoes.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.b2w.recomendacoes.apirest.model.Customer;
import com.b2w.recomendacoes.apirest.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="API REST Customer")

public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@ApiOperation(value = "Retorna todos os clientes")
	@RequestMapping(value = "/customers",  method = { RequestMethod.GET } ,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Customer> findAllCustomer() {
		return customerService.getCustomers();
	}
	
	@ApiOperation(value = "Adiciona um novo cliente")
	@RequestMapping(value = "/customers",  method = { RequestMethod.POST })
	public @ResponseBody void saveCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
	}
	
}
