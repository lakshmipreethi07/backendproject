package com.project.shopping.dao;

import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.project.shopping.model.supplier;
@EnableTransactionManagement
@Repository(value="SupplierDAO")
public class SuppilerDAOImpl implements SupplierDAO {
@Autowired
private SessionFactory sessionFactory;
public SuppilerDAOImpl(SessionFactory sessionFactory)
{
	this.sessionFactory=sessionFactory;
}
@Transactional
public Boolean save(supplier supplier){
	try {
		sessionFactory.getCurrentSession().save(supplier);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
}
public Boolean update(supplier supplier){
	try {
		sessionFactory.getCurrentSession().update(supplier);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
}
public Boolean delete(supplier supplier){
	try {
		sessionFactory.getCurrentSession().delete(supplier);
		return true;
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
}
public supplier get(String id){
	String hql="form supplier where id="+"'"+id+"'";
@SuppressWarnings("rawtypes")
Query query=sessionFactory.getCurrentSession().createQuery(hql);
	@SuppressWarnings({ "deprecation", "unchecked" })
	List<supplier>list=query.list();
	if(list==null)
	{
		return null;
	}
	else
	{
		 return list.get(0);
	}
	
	}
@SuppressWarnings({ "deprecation", "unchecked" })
public List<supplier> list(){
	String hql="form supplier";
		@SuppressWarnings("rawtypes")
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

}
}