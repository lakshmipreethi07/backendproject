package com.project.shopping.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.shopping.model.Category;

@Repository
public interface CategoryDAO {
	
	public Boolean save(Category Category);
	public Boolean update(Category Category); 
	public Boolean delete(Category Category);
	public Category get(String id);
	public List<Category> list();

}
