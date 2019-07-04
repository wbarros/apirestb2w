package com.b2w.recomendacoes.apirest.model;

import java.io.Serializable;

public class CustomerTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private String slug;
	
	public CustomerTO(String name, String slug) {
		this.name = name;
		this.slug = slug;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
    
}
