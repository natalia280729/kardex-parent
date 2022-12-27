package com.todouno.kardex.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.todouno.kardex.data.Stock;
@Repository
public interface StockRepository extends JpaRepository<Stock,String> {
	
	public List<Stock> findByProductId(String productId);
	
	
	@Query(value = "SELECT sum(quantity) FROM Stock where product_id=?1",nativeQuery = true)
	public int sumProductId(String productId);
	@Query(value = "SELECT * FROM Stock where product_id=?1 and quantity > 0 order by creation_date desc",nativeQuery = true)
	public List<Stock> findProductIdOrder(String productId);
}
