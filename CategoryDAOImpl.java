package com.project.shopping.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.project.shopping.model.Category;
@EnableTransactionManagement
@Repository(value="categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
@Autowired
private SessionFactory sessionFactory;
public CategoryDAOImpl(SessionFactory sessionFactory){
	this.sessionFactory=sessionFactory;

}
@Transactional
public Boolean save(Category category)
{
	try {
		sessionFactory.getCurrentSession().save(category);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
}
@Transactional
public Boolean update(Category Category)
{
	try {
		sessionFactory.getCurrentSession().update(Category);
		return true;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	
}
@Transactional
public Boolean delete(Category Category)
{
	try {
		sessionFactory.getCurrentSession().delete(Category);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
}
public Category get(String id)
{
	String hql="from category where id ="+"'"+id+"'";
	@SuppressWarnings("rawtypes")
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Category>list=query.list();
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
public List<Category> list()
{
	String hql="from category";
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	return  query.list();
}
}
