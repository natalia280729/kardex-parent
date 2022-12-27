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

import com.todouno.kardex.data.Stock;
import com.todouno.kardex.manager.StockManager;

@RunWith(MockitoJUnitRunner.class)
public class StockServiceImplTest {
	@Mock
	private StockManager stockManager;
	@InjectMocks
	private StockServiceImpl stockServiceImpl;
	
	@Before
    public void setUp() {
		 MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetStockManager() {
		assertNotNull(stockServiceImpl.getStockManager());
	}

	

	@Test
	public void testSaveStock() {
		Stock stock=new Stock();
		when(stockManager.saveStock(stock)).thenReturn(stock);
		
		assertNotNull(stockServiceImpl.saveStock(stock));
	}

	@Test
	public void testFindByProductId() {
		String productId="11";
		List<Stock> lstStock=new ArrayList<Stock>();
		when(stockManager.findByProductId(productId)).thenReturn(lstStock);
		
		assertNotNull(stockServiceImpl.findByProductId(productId));
	}

	@Test
	public void testUpdateStock() {
		Stock stock=new Stock();
		when(stockManager.saveStock(stock)).thenReturn(stock);
		
		assertNotNull(stockServiceImpl.updateStock(stock));
		
	}

	@Test
	public void testSumByProductId() {
		String productId="11";
		int sum=2;
		when(stockManager.sumByProductId(productId)).thenReturn(sum);
		assertNotNull(stockServiceImpl.sumByProductId(productId));
		
		
	}

}
