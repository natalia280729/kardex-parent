package com.todouno.kardex.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.todouno.kardex.data.SalesStock;

public interface SalesStockRepository extends JpaRepository<SalesStock, String>{

}
