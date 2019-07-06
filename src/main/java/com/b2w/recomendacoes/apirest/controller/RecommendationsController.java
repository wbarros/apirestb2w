package com.b2w.recomendacoes.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.b2w.recomendacoes.apirest.model.RecommendationTO;
import com.b2w.recomendacoes.apirest.service.RecommendationsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="RecommendationsController")
@RequestMapping(value = "/recommendations")
public class RecommendationsController {
	
	@Autowired
	RecommendationsService recommendationsService;
	
	@ApiOperation(value = "Products Views")
	@RequestMapping(value = "/product-1",  method = { RequestMethod.GET } ,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<RecommendationTO> recommendationsProduct1(Integer limit) {
		return recommendationsService.recommendationsProduct1(limit);
	}
	
	@RequestMapping(value = "/product-2",  method = { RequestMethod.GET } ,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<RecommendationTO> recommendationsProduct2(Integer limit) {
		return recommendationsService.recommendationsProduct2(limit);
	}
	
	@RequestMapping(value = "/product-3",  method = { RequestMethod.GET } ,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<RecommendationTO> recommendationsProduct3(Integer limit) {
		return recommendationsService.recommendationsProduct3(limit);
	}
	
}
