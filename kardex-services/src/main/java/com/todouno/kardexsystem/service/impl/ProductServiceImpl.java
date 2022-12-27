package com.todouno.kardexsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.todouno.kardex.data.Products;
import com.todouno.kardex.domain.ProductDto;
import com.todouno.kardex.domain.SaleProduct;
import com.todouno.kardex.manager.ProductManager;
import com.todouno.kardexsystem.services.ProductService;

public class ProductServiceImpl implements ProductService {
	//@Autowired
	private ProductManager productManager;
	
	
	

	public ProductManager getProductManager() {
		return productManager;
	}




	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}




	public List<Products> findProducts() {

		return productManager.findProducts();
	}




	public List<Products> findByNameAndBarCode(String name, String barCode) {
		
		return  productManager.findByNameAndBarCode(name, barCode);
	}




	public Products saveProduct(ProductDto product) {
		
		return productManager.saveProduct(product);
	}




	public void saleProduct(SaleProduct saleProduct) {
		
		productManager.saleProduct(saleProduct);
	}

}
