package com.todouno.kardex.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.todouno.kardex.data.Stock;
import com.todouno.kardex.domain.StockDto;
import com.todouno.kardexsystem.services.StockService;

@RestController
@RequestMapping("/api/stock")
@CrossOrigin(origins = "http://localhost:4200")
public class StockController {
	@Autowired
	private StockService stockService;
	
	
	
	public StockService getStockService() {
		return stockService;
	}



	public void setStockService(StockService stockService) {
		this.stockService = stockService;
	}



	@PostMapping("/add")
	 public Stock saveStock(@RequestBody StockDto stockDto){
			return stockService.saveStock(stockDto.getStock());
		}
	@GetMapping("/sum")
	 public int saveStock(@RequestParam String  productId){
			return stockService.sumByProductId(productId);
		}
}
