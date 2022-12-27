package com.todouno.kardex.domain;

import java.util.List;

import com.todouno.kardex.data.Products;
import com.todouno.kardex.data.Stock;

public class ProductDto {
	
	private Products products;
	
	private List<Stock> lstStocks;

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public List<Stock> getLstStocks() {
		return lstStocks;
	}

	public void setLstStocks(List<Stock> lstStocks) {
		this.lstStocks = lstStocks;
	}
	
	

}
