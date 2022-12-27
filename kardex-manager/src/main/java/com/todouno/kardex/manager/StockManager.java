package com.todouno.kardex.manager;

import java.util.List;

import com.todouno.kardex.data.Stock;

public interface StockManager {
	
	public Stock saveStock(Stock stock);
	public Stock updateStock(Stock stock);
	public List<Stock> findByProductId(String productId);
	
	public int sumByProductId(String productId);
	public List<Stock> findProductIdOrder(String productId);
}
