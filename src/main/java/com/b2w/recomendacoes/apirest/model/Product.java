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

@Entity(name = "Product")
@Table(name = "product")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    private String slug;
    
    private Double score;
    
    @OneToMany(
    	mappedBy = "product",
        cascade = {CascadeType.ALL},
    	orphanRemoval = true
    )
    List<ProductView> productviews = new ArrayList<>();

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return this.id;
    }
    
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
    
    public void setScore(Double score) {
        this.score = score;
    }
    
    public Double getScore() {
        return this.score;
    }

    public void setProductviews(List<ProductView> productviews) {
        this.productviews = productviews;
    }
    
    public List<ProductView> getProductviews() {
        return this.productviews;
    }
    
}

