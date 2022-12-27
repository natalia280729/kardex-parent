package com.todouno.kardex.manager.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.todouno.kardex.data.SalesStock;
import com.todouno.kardex.persistence.dao.SalesStockRepository;
@RunWith(MockitoJUnitRunner.class)
public class SalesStockManagerImplTest {
	@Mock
	private SalesStockRepository salesStockRepository;
	private SalesStockManagerImpl salesStockManagerImpl=new SalesStockManagerImpl();
	
	@Before
    public void setUp() {
	salesStockRepository = Mockito.mock(SalesStockRepository.class);
	salesStockManagerImpl.setSalesStockRepository(salesStockRepository);
    }

	@Test
	public void testGetSalesStockRepository() {
		assertNotNull(salesStockManagerImpl.getSalesStockRepository());
	}

	

	@Test
	public void testSaveSalesStockSalesStock() {
		SalesStock salesStock=new SalesStock();
		
		salesStockManagerImpl.saveSalesStock(salesStock);
		assertNotNull(salesStock);
	}

	@Test
	public void testSaveSalesStockListOfStringString() {
		List<String> stocksId=new ArrayList<String>();
		stocksId.add("123");
		String salesId="123";
		
		salesStockManagerImpl.saveSalesStock(stocksId, salesId);
		
		assertNotNull(stocksId);
	}

}
