package com.b2w.recomendacoes.apirest.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Customer")
@Table(name = "customer")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    
    private String slug;

    private String name;
    
    public Customer() {}
    
	public Customer(String name) {
		this.name = name;
	}
	
	public Customer(Long id, String name, String slug) {
		this.id = id;
		this.name = name;
		this.slug = slug;
	}

	@OneToMany(
    	mappedBy = "customer",
        cascade = {CascadeType.ALL},
    	orphanRemoval = true
    )
	@JsonIgnore
    List<ProductView> productviews = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    public void setSlug(String slug) {
        this.slug = slug;
    }
    
    public String getSlug() {
        return this.slug;
    }
    
    public void setProductviews(List<ProductView> productviews) {
        this.productviews = productviews;
    }
    
    public List<ProductView> getProductviews() {
        return this.productviews;
    }
    
}

