package com.b2w.recomendacoes.apirest.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Customer")
@Table(name = "customer")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    
    private String slug;
    
    @OneToMany(
    	mappedBy = "customer",
        cascade = {CascadeType.ALL},
    	orphanRemoval = true
    )
    List<ProductViews> productviews = new ArrayList<>();

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
    
    public void setProductviews(List<ProductViews> productviews) {
        this.productviews = productviews;
    }
    
    public List<ProductViews> getProductviews() {
        return this.productviews;
    }
    
}

