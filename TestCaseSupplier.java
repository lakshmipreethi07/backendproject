package com.niit.backend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

public class TestCaseSupplier {

	// to write test case for supplier we neeed supplierdao and supplier object
	
	@Autowired // automatically inject
	SupplierDAO supplierDAO;	
	
	@Autowired
	Supplier supplier;
	
	AnnotationConfigApplicationContext context; //in junit test case one more method to create annotationconfigapplicationcontext metho
	
	@Before
	public void init() //to intitalize // u can give any name here i am giving init
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit"); //the package name where the ur program is there 
		context.refresh();
		
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");    // it will come autimatially SupplierDAO when u did type cast
		supplier = (Supplier) context.getBean("supplier");             //type case
	}
	
	
	@Test
	public void deleteSupplierTestCase()
	{                              
		supplier.setId("sup02");
		boolean flag = supplierDAO.delete(supplier);
		
		assertEquals("deletesuppliertestcase " , flag,false);
		
											// tp delet is workking fine or no
	    supplierDAO.delete(supplier);
	}
	@Test
	public void addSupplierTestCase(){
		
		supplier.setId("sup10");
		
		supplier.setName("laptop");
		supplier.setAddress("thti is laptoo");
		
		//supplierDAO.save(supplier); // for ding this we need calll save method from supplierdao u can use both ways 
		
		assertEquals("addtestcase",supplierDAO.save(supplier),true);	
	}
	


	@Test     // to fetch all records
	public void listSupplierTestCase()    // to check everything is work fine it will return list of records
	{
		
		assertEquals("Supplier list testcase",supplierDAO.list().size(),2);     //compare to values we need to givr actual table rows value
	}
	
	@Test
	public void updateSupplierTestCase()
	{
		supplier.setId("mob04");
		supplier.setName("mob");
		
		assertEquals("update   ",supplierDAO.update(supplier),true);
	}
	
	@Test
	public void getSupplierTestCase()
	{
		assertEquals("get supplier",supplierDAO.get("mob08"),null);
	}

	}



