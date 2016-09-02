package com.niit.backend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

public class TestCaseProduct {

	// to write test case for product we neeed productdao and product object
	@Autowired // automatically inject
	ProductDAO productDAO;	
	
	@Autowired
	Product product;
	
	AnnotationConfigApplicationContext context; //in junit test case one more method to create annotationconfigapplicationcontext metho
	
	@Before
	public void init() //to intitalize // u can give any name here i am giving init
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit"); //the package name where the ur program is there 
		context.refresh();
		
		productDAO = (ProductDAO) context.getBean("productDAO");    // it will come autimatially ProductDAO when u did type cast
		product = (Product) context.getBean("product");             //type case
	}
	
	
	@Test
	public void deleteProductTestCase()
	{                              
		product.setId("mobo5");
		boolean flag = productDAO.delete(product);
		
		assertEquals("deleteproducttestcase " , flag,false);
		
											// tp delet is workking fine or no
	    productDAO.delete(product);
	}
	@Test
	public void addProductTestCase(){
		
		product.setId("pro01");
		
		product.setName("laptop");
		product.setDescription("thti is laptoo");
		
		//productDAO.save(product); // for ding this we need calll save method from productdao u can use both ways 
		
		assertEquals("addtestcase",productDAO.save(product),true);	
	}
	


	@Test     // to fetch all records
	public void listProductTestCase()    // to check everything is work fine it will return list of records
	{
		
		assertEquals("Product list testcase",productDAO.list().size(),2);     //compare to values we need to givr actual table rows value
	}
	
	@Test
	public void updateProductTestCase()
	{
		product.setId("pro01");
		product.setName("iphone");
		product.setPrice("40000");
		
		
		assertEquals("update   ",productDAO.update(product),true);
	}
	
	@Test
	public void getProductTestCase()
	{
		assertEquals("get product",productDAO.get("mob08"),null);
	}

	}



