package com.todouno.kardex.manager.impl;

import com.todouno.kardex.data.Sales;
import com.todouno.kardex.manager.SalesManager;
import com.todouno.kardex.persistence.dao.SalesRepository;

public class SalesManagerImpl implements SalesManager {
	
	private SalesRepository salesRepository;
	
	
	

	public SalesRepository getSalesRepository() {
		return salesRepository;
	}




	public void setSalesRepository(SalesRepository salesRepository) {
		this.salesRepository = salesRepository;
	}




	public void saveSales(Sales sale) {
		
		salesRepository.save(sale);
	}

}
