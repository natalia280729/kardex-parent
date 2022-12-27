package com.todouno.kardex.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todouno.kardex.data.Products;
@Repository
public interface ProductRepository extends JpaRepository<Products, String> {
public List<Products> findByNameOrBarCode(String name,String barCode);
}
