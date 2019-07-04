package com.b2w.recomendacoes.apirest.model;

import java.io.Serializable;

public class RecommendationTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String product;
	private Double score;
	
	public RecommendationTO(String product, Double score) {
		this.product = product;
		this.score = score;
	}
	
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	
}
