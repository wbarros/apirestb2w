package com.b2w.recomendacoes.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.b2w.recomendacoes.apirest.dao.CustomerRepository;
import com.b2w.recomendacoes.apirest.model.Customer;
import com.b2w.recomendacoes.apirest.util.Util;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer addCustomer(Customer customer) {
		customer.setSlug(Util.toSlug(customer.getName()));
		return customerRepository.save(customer);
	}
	
	public List<Customer> getCustomers() {
		List<Customer> listCustomer = customerRepository.findAll(new Sort(Sort.Direction.ASC, "name"));
		//List<CustomerTO> listCustomerTO = customerToCustomerTO(listCustomer);
		return listCustomer;
	}
	
//	private List<CustomerTO> customerToCustomerTO(List<Customer> listCustomer) {
//		List<CustomerTO> listCustomerTO = new ArrayList<>();
//		
//		for(Customer customer : listCustomer) {
//			CustomerTO customerTO = new CustomerTO(customer.getName(), customer.getName());
//			listCustomerTO.add(customerTO);
//		}
//		return listCustomerTO;
//	}
	
}
