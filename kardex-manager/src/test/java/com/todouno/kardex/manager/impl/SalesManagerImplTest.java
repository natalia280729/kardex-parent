package com.todouno.kardex.manager.impl;



import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.todouno.kardex.data.Sales;
import com.todouno.kardex.persistence.dao.SalesRepository;
@RunWith(MockitoJUnitRunner.class)
public class SalesManagerImplTest {
	@Mock
	private SalesRepository salesRepository;
	
	private SalesManagerImpl salesManagerImpl=new SalesManagerImpl() ;
	 @Before
	    public void setUp() {
		 salesRepository = Mockito.mock(SalesRepository.class);
		 salesManagerImpl.setSalesRepository(salesRepository);
	    }
	@Test
	public void testGetSalesRepository() {
		assertNotNull(salesManagerImpl.getSalesRepository());
	}

	

	@Test
	public void testSaveSales() {
		Sales sale =new Sales();
		
		salesManagerImpl.saveSales(sale);
		assertNotNull(sale);
	}

}
