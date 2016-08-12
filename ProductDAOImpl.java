package com.project.shopping.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.project.shopping.model.Product;
@EnableTransactionManagement
@Repository(value="ProductDAO")
public class ProductDAOImpl implements ProductDAO {
@Autowired
private SessionFactory sessionFactory;
public ProductDAOImpl(SessionFactory sessionFactory){
	this.sessionFactory=sessionFactory;

}
@Transactional
public Boolean save(Product product)
{
	try {
		sessionFactory.getCurrentSession().save(product);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
}
@Transactional
public Boolean update(Product product)
{
	try {
		sessionFactory.getCurrentSession().update(product);
		return true;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	
}
@Transactional
public Boolean delete(Product product)
{
	try {
		sessionFactory.getCurrentSession().delete(product);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
}
public Product get(String id)
{
	String hql="from Product where id ="+"'"+id+"'";
	@SuppressWarnings("rawtypes")
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Product>list=query.list();
	if(list==null)
	{
		return null;
	}
	else
	{
		return list.get(0);
		
		
	}
	}
@SuppressWarnings({ "deprecation","unchecked" })
public List<Product> list()
{
	String hql="from Product";
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	return  query.list();
}
}
