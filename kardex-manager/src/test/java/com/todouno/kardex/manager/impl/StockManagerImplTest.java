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
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.todouno.kardex.data.Stock;
import com.todouno.kardex.persistence.dao.StockRepository;
@RunWith(MockitoJUnitRunner.class)
public class StockManagerImplTest {
	@Mock
	private StockRepository stockRepository;
	@InjectMocks
	private StockManagerImpl stockManagerImpl=new StockManagerImpl();
	
	@Before
    public void setUp() {
		MockitoAnnotations.initMocks(this);
		
    }

	@Test
	public void testSaveStock() {
		Stock stock =new Stock();
		Stock stockn =new Stock();
		when(stockRepository.save(stock)).thenReturn(stockn);
		
		Stock str=stockManagerImpl.saveStock(stock);
		assertNotNull(str);
	}

	@Test
	public void testFindByProductId() {
		String productId="123";
		List<Stock> lstStock=new ArrayList<Stock>();
		when(stockRepository.findByProductId(productId)).
		thenReturn(lstStock);
		
		assertNotNull(stockManagerImpl.findByProductId(productId));
	}

	@Test
	public void testSumByProductId() {
		String productId="123";
		int value=23;
		when(stockRepository.sumProductId(productId)).
		thenReturn(value);
		assertNotNull(stockManagerImpl.sumByProductId(productId));
		
	}

	@Test
	public void testFindProductIdOrder() {
		String productId="123";
		List<Stock> lstStock=new ArrayList<Stock>();
		when(stockRepository.findProductIdOrder(productId)).thenReturn(lstStock);
		
		assertNotNull(stockManagerImpl.findProductIdOrder(productId));
	}

}
