package com.todouno.kardexsystem.service.impl;

import java.util.List;

import com.todouno.kardex.data.Stock;
import com.todouno.kardex.manager.StockManager;
import com.todouno.kardexsystem.services.StockService;

public class StockServiceImpl implements StockService{
	
	private StockManager stockManager;
	
	
	

	public StockManager getStockManager() {
		return stockManager;
	}

	public void setStockManager(StockManager stockManager) {
		this.stockManager = stockManager;
	}

	public Stock saveStock(Stock stock) {

		return stockManager.saveStock(stock);
	}

	public List<Stock> findByProductId(String productId) {
		
		return stockManager.findByProductId(productId);
	}

	public Stock updateStock(Stock stock) {
		
		return stockManager.saveStock(stock);
	}

	public int sumByProductId(String productId) {
		
		return stockManager.sumByProductId(productId);
	}

}
