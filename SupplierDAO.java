package com.project.shopping.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.project.shopping.model.supplier;


@Repository
public interface SupplierDAO {
	public Boolean save(supplier supplier);
	public Boolean update(supplier supplier);
	public Boolean delete(supplier supplier);
	public supplier get(String id);
	public List<supplier> list();


}
