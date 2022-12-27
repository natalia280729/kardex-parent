package com.todouno.kardex.manager.impl;

import java.util.List;
import java.util.UUID;

import com.todouno.kardex.data.SalesStock;
import com.todouno.kardex.manager.SalesStockManager;
import com.todouno.kardex.persistence.dao.SalesStockRepository;

public class SalesStockManagerImpl  implements SalesStockManager{

	private SalesStockRepository salesStockRepository;
	
	
	
	
	public SalesStockRepository getSalesStockRepository() {
		return salesStockRepository;
	}




	public void setSalesStockRepository(SalesStockRepository salesStockRepository) {
		this.salesStockRepository = salesStockRepository;
	}




	public void saveSalesStock(SalesStock salesStock) {

		salesStockRepository.save(salesStock);
	}




	public void saveSalesStock(List<String> stocksId, String salesId) {
		for(String stock:stocksId) {
			UUID uuid = UUID.randomUUID();
			SalesStock salesStock=new SalesStock();
			salesStock.setStockId(stock);
			salesStock.setSalesId(salesId);
			salesStock.setId(uuid.toString());
			salesStockRepository.save(salesStock);
		}
		
	}

}
