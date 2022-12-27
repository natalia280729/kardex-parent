package com.todouno.kardex.manager;

import java.util.List;

import com.todouno.kardex.data.SalesStock;

public interface SalesStockManager {

	public void saveSalesStock(SalesStock salesStock );
	public void saveSalesStock(List<String> stocksId,String salesId);
}
