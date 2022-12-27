package com.todouno.kardex.manager.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.todouno.kardex.data.Stock;
import com.todouno.kardex.manager.StockManager;
import com.todouno.kardex.persistence.dao.StockRepository;

public class StockManagerImpl implements StockManager{
	
	private StockRepository stockRepository;
	
	
	
	

	public StockRepository getStockRepository() {
		return stockRepository;
	}

	public void setStockRepository(StockRepository stockRepository) {
		this.stockRepository = stockRepository;
	}

	public Stock saveStock(Stock stock) {
		UUID uuidst = UUID.randomUUID();
		stock.setId(uuidst.toString());
		stock.setCreationDate(new Date());
		return stockRepository.save(stock);
	}

	public List<Stock> findByProductId(String productId) {
		
		return stockRepository.findByProductId(productId);
	}

	

	public int sumByProductId(String productId) {

		return stockRepository.sumProductId(productId);
	}

	public List<Stock> findProductIdOrder(String productId) {
		
		return stockRepository.findProductIdOrder(productId);
	}

	public Stock updateStock(Stock stock) {
		return stockRepository.save(stock);
	}

}
