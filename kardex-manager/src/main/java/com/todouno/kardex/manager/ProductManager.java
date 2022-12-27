package com.todouno.kardex.manager;

import java.util.List;

import com.todouno.kardex.data.Products;
import com.todouno.kardex.domain.ProductDto;
import com.todouno.kardex.domain.SaleProduct;

public interface ProductManager {
	
	public Products saveProduct(ProductDto product);
	
	public List<Products> findProducts();
	
	public List<Products> findByNameAndBarCode(String name,String barCode);
	
	public void saleProduct(SaleProduct saleProduct);
	

}
