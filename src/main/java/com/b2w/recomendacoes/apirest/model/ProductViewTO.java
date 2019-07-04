package com.b2w.recomendacoes.apirest.model;

import java.io.Serializable;

public class ProductViewTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String timestamp;
	private String product;
	private String customer;
	
	public ProductViewTO(String timestamp, String product, String customer) {
		this.timestamp = timestamp;
		this.product = product;
		this.customer = customer;
	}
	
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	
}
