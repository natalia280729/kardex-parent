package com.todouno.kardex.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todouno.kardex.data.Sales;
@Repository
public interface SalesRepository  extends JpaRepository<Sales, String> {

}
