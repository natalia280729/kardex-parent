package com.todouno.kardex.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.todouno.kardex.data.Products;
import com.todouno.kardex.data.Sales;
import com.todouno.kardex.data.Stock;
import com.todouno.kardex.domain.ProductDto;
import com.todouno.kardex.domain.SaleProduct;
import com.todouno.kardex.manager.ProductManager;
import com.todouno.kardex.manager.SalesManager;
import com.todouno.kardex.manager.SalesStockManager;
import com.todouno.kardex.manager.StockManager;
import com.todouno.kardex.persistence.dao.ProductRepository;

public class ProductManagerImpl implements ProductManager{
	//@Autowired
	private ProductRepository productRepository;
	
	private StockManager stockManager;
	
	private SalesManager salesManager;
	
	private SalesStockManager salesStockManager;
	
	
	
	
	
	
	
	public SalesStockManager getSalesStockManager() {
		return salesStockManager;
	}

	public void setSalesStockManager(SalesStockManager salesStockManager) {
		this.salesStockManager = salesStockManager;
	}

	public SalesManager getSalesManager() {
		return salesManager;
	}

	public void setSalesManager(SalesManager salesManager) {
		this.salesManager = salesManager;
	}

	public StockManager getStockManager() {
		return stockManager;
	}

	public void setStockManager(StockManager stockManager) {
		this.stockManager = stockManager;
	}

	public Products saveProduct(ProductDto product) {
		UUID uuid = UUID.randomUUID();
		product.getProducts().setId(uuid.toString());
		product.getProducts().setCreationDate(new Date());
		product.getProducts().setCreationUser("test");
		Products productSave=productRepository.save(product.getProducts());
		
		if(product.getLstStocks() != null) {
			Stock stock=product.getLstStocks().get(0);
			
			stock.setProductId(uuid.toString());
			
			stockManager.saveStock(stock);
		}
		
		return productSave;
		
	}

	public List<Products> findProducts() {
		
		return productRepository.findAll();
	}

	public ProductRepository getProductRepository() {
		return productRepository;
	}

	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Products> findByNameAndBarCode(String name, String barCode) {
		
		return productRepository.findByNameOrBarCode(name, barCode);
	}

	public void saleProduct(SaleProduct saleProduct) {
		
		List<Stock> lstStock=stockManager.findProductIdOrder(saleProduct.getProductId());
		
		int saleMax=saleProduct.getQuantity();
		List<String> stocksId=new ArrayList<String>();
		
		for(Stock stock: lstStock) {
			if(saleMax > stock.getQuantity()) {
				int aleMax=saleMax-stock.getQuantity();
				saleMax=aleMax;
				int quantity=0;
				stock.setQuantity(quantity);
				stocksId.add(stock.getId());
				stockManager.updateStock(stock);
			}else {
				
				int quantity=stock.getQuantity()-saleMax;
				stock.setQuantity(quantity);
				stocksId.add(stock.getId());
				stockManager.updateStock(stock);
				break;
				
			}
			
			
		}
		
		UUID uuid = UUID.randomUUID();
		
		Sales sale =new Sales();
		sale.setId(uuid.toString());
		sale.setQuantity(saleProduct.getQuantity());
		
		sale.setTotal(saleProduct.getTotal());
		
		salesManager.saveSales(sale);
		salesStockManager.saveSalesStock(stocksId, sale.getId());
		
	
	}

}
