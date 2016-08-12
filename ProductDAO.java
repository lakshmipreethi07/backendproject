package com.project.shopping.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.shopping.model.Product;

@Repository
public interface ProductDAO {
	
	public Boolean save(Product Product);
	public Boolean update(Product Product); 
	public Boolean delete(Product Product);
	public Product get(String id);
	public List<Product> list();

}
