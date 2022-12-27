package com.todouno.kardexsystem.service.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.todouno.kardex.data.Products;
import com.todouno.kardex.domain.ProductDto;
import com.todouno.kardex.domain.SaleProduct;
import com.todouno.kardex.manager.ProductManager;
@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {
	@Mock
	private ProductManager productManager;
	@InjectMocks
	private ProductServiceImpl ProductServiceImpl;
	
	@Before
    public void setUp() {
		 MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetProductManager() {
		assertNotNull(ProductServiceImpl.getProductManager());
	}

	

	@Test
	public void testFindProducts() {
		List<Products> lstProducts=new ArrayList<Products>();
		when(productManager.findProducts()).thenReturn(lstProducts);
		assertNotNull(ProductServiceImpl.findProducts());
		
		
	}

	@Test
	public void testFindByNameAndBarCode() {
		List<Products> lstProducts=new ArrayList<Products>();
		String name="test";
		String barCode="111";
		when(productManager.findByNameAndBarCode(name, barCode)).thenReturn(lstProducts);
		assertNotNull(ProductServiceImpl.findByNameAndBarCode(name, barCode));
	}

	@Test
	public void testSaveProduct() {
		ProductDto productsDto =new ProductDto();
		Products product=new Products();
		when(productManager.saveProduct(productsDto)).thenReturn(product);
		assertNotNull(ProductServiceImpl.saveProduct(productsDto));
	}

	@Test
	public void testSaleProduct() {
		SaleProduct saleProduct= new SaleProduct();
		ProductServiceImpl.saleProduct(saleProduct);
		
		assertNotNull(saleProduct);
	}

}
