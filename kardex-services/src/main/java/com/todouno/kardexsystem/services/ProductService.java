package com.todouno.kardexsystem.services;

import java.util.List;

import com.todouno.kardex.data.Products;
import com.todouno.kardex.domain.ProductDto;
import com.todouno.kardex.domain.SaleProduct;

public interface ProductService {
	
	public List<Products> findProducts();
	public List<Products> findByNameAndBarCode(String name, String barCode);
	public Products saveProduct(ProductDto product);
	public void saleProduct(SaleProduct saleProduct);
}
