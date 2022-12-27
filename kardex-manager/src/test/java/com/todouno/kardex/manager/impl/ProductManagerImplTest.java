package com.todouno.kardex.manager.impl;

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
import com.todouno.kardex.data.Sales;
import com.todouno.kardex.data.Stock;
import com.todouno.kardex.domain.ProductDto;
import com.todouno.kardex.domain.SaleProduct;
import com.todouno.kardex.manager.SalesManager;
import com.todouno.kardex.manager.SalesStockManager;
import com.todouno.kardex.manager.StockManager;
import com.todouno.kardex.persistence.dao.ProductRepository;
@RunWith(MockitoJUnitRunner.class)
public class ProductManagerImplTest {
	@Mock
	private ProductRepository productRepository;
	@Mock
	private StockManager stockManager;
	@Mock
	private SalesManager salesManager;
	@Mock
	private SalesStockManager salesStockManager;
	@InjectMocks
	private ProductManagerImpl productManager;
	
	@Before
    public void setUp() {
		 MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetSalesStockManager() {
		assertNotNull(productManager.getSalesStockManager());
	}


	@Test
	public void testGetSalesManager() {
		assertNotNull(productManager.getSalesManager());
	}

	@Test
	public void testGetStockManager() {
		assertNotNull(productManager.getStockManager());
	}

	@Test
	public void testSaveProduct() {
		ProductDto products =new ProductDto();
		Products productsSave =new Products();
		products.setProducts(productsSave);
		List<Stock> lstStocks=new ArrayList<Stock>();
		Stock stock =new Stock();
		lstStocks.add(stock);
		
		products.setLstStocks(lstStocks);
		Products productsN =new Products();
		when(productRepository.save(products.getProducts())).thenReturn(productsN);
		when(stockManager.saveStock(products.getLstStocks().get(0))).thenReturn(stock);
		Products presult=productManager.saveProduct(products);
		assertNotNull(presult);
	}

	@Test
	public void testFindProducts() {
		List<Products> lstProduct=new ArrayList<Products>();
		
		when(productRepository.findAll()).thenReturn(lstProduct);
		List<Products>  lstResult=productManager.findProducts();
		
		assertNotNull(lstResult);
	}

	@Test
	public void testGetProductRepository() {
	assertNotNull(productManager.getProductRepository());
	
	}

	
	@Test
	public void testFindByNameAndBarCode() {
		List<Products> lstProduct=new ArrayList<Products>();
		String name="test";
		String barCode="111";
		
		when(productRepository.findByNameOrBarCode(name, barCode)).thenReturn(lstProduct);
		List<Products>  lstResult=productManager.findByNameAndBarCode(name, barCode);
		
		assertNotNull(lstResult);
	}

	@Test
	public void testSaleProduct() {
		String productId="123";
		SaleProduct saleProduct=new SaleProduct();
		saleProduct.setQuantity(6);
		saleProduct.setProductId(productId);
		
		Sales sale =new Sales();
		
		List<Stock> lstStock=new ArrayList<Stock>();
		Stock stock =new Stock();
		stock.setQuantity(2);
		
		Stock stock2 =new Stock();
		stock2.setQuantity(10);
		lstStock.add(stock);
		lstStock.add(stock2);
		when(stockManager.findProductIdOrder(saleProduct.getProductId())).thenReturn(lstStock);
		when(stockManager.saveStock(stock2)).thenReturn(stock2);
		
		productManager.saleProduct(saleProduct);
		
		assertNotNull(stock2);
	}

}
