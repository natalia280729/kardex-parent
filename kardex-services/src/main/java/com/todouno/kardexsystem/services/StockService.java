package com.todouno.kardexsystem.services;

import java.util.List;

import com.todouno.kardex.data.Stock;

public interface StockService {
	
	public Stock saveStock(Stock stock);
	public List<Stock> findByProductId(String productId);
	public Stock updateStock(Stock stock);
	public int sumByProductId(String productId);
	

}
