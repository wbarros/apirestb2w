package com.b2w.recomendacoes.apirest;

import static org.junit.Assert.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.b2w.recomendacoes.apirest.dao.CustomerRepository;
import com.b2w.recomendacoes.apirest.dao.ProductRepository;
import com.b2w.recomendacoes.apirest.model.Customer;
import com.b2w.recomendacoes.apirest.model.Product;
import com.b2w.recomendacoes.apirest.service.CustomerService;
import com.b2w.recomendacoes.apirest.service.ProductService;
import com.b2w.recomendacoes.apirest.util.Util;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApirestApplicationTests {
	
	private static final String SLUG_TESTE_1 = "àáãçÇ WeLinNpP ã";
	private static final String SLUG_TESTE_2 = "ÍÁÀ Wweldkd";
	private static final String SLUG_TESTE_3 = "ãíì eágh";
	private static final String EXPECTED_SLUG_TESTE_1 = "aaacc-welinnpp-a";
	private static final String EXPECTED_SLUG_TESTE_2 = "iaa-wweldkd";
	private static final String EXPECTED_SLUG_TESTE_3 = "aii-eagh";
	
	@Mock
	CustomerRepository customerRepository;
	
	@Mock
	ProductRepository productRepository;

	@InjectMocks
	CustomerService customerService;
	
	@InjectMocks
	ProductService productService;
	
	@Test
	public void getCustomerTest() {
		Mockito.when(customerService.getCustomers()).thenReturn(Stream.of(new Customer(1L, "Customer 1", "customer-1"), 
				new Customer(2L, "Customer 2", "customer-2"), 
				new Customer(3L, "Customer 3", "customer-3"))
				.collect(Collectors.toList()));
		assertEquals(3, customerService.getCustomers().size());
	}
	
	@Test
	public void saveCustomerTest() {
		Customer customer = new Customer("Customer 1");
		Mockito.when(customerRepository.save(customer)).thenReturn(customer);
		assertEquals(customer, customerService.addCustomer(customer));
	}
	
	@Test 
	public void getProductsTest() {
		Mockito.when(productService.getProducts()).thenReturn(Stream.of(new Product("Product 1"),
				new Product("Product 2"))
				.collect(Collectors.toList()));
		assertEquals(2, productService.getProducts().size());
	}
	
	@Test
	public void saveProductTest() {
		Product product = new Product("Product 1");
		Mockito.when(productRepository.save(product)).thenReturn(product);
		assertEquals(product, productService.addProduct(product));
	}
	
	
	@Test
	public void toSlugTest() {
		assertEquals(EXPECTED_SLUG_TESTE_1, Util.toSlug(SLUG_TESTE_1));
		assertEquals(EXPECTED_SLUG_TESTE_2, Util.toSlug(SLUG_TESTE_2));
		assertEquals(EXPECTED_SLUG_TESTE_3, Util.toSlug(SLUG_TESTE_3));
	}
	
}
