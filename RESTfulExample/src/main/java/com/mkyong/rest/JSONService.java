package com.mkyong.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/json/product")
public class JSONService {

	@GET
	@Path("/get")
	@Produces("application/json")
	public List<Product> getProductInJSON() {

		List<Product> productList = new ArrayList<>();
		
		Product product1 = new Product();
		product1.setName("Name1");
		int[] numbers1 = {1,2,3};
		product1.setNumbers(numbers1);
		productList.add(product1);
		
		Product product2 = new Product();
		product2.setName("Name2");
		int[] numbers2 = {11,12,13};
		product2.setNumbers(numbers2);
		productList.add(product2);
		
		return productList;


	}

	
}