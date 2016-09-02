package com.niit.backend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.UserDetails;

public class TestCaseUserDetails {

	// to write test case for userdetails we neeed userdetailsdao and userdetails object
	@Autowired // automatically inject
	UserDetailsDAO userdetailsDAO;	
	
	@Autowired
	UserDetails userdetails;
	
	AnnotationConfigApplicationContext context; //in junit test case one more method to create annotationconfigapplicationcontext metho
	
	@Before
	public void init() //to intitalize // u can give any name here i am giving init
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart"); //the package name where the ur program is there 
		context.refresh();
		
		userdetailsDAO = (UserDetailsDAO) context.getBean("userdetailsDAO");    // it will come autimatially UserDetailsDAO when u did type cast
		userdetails = (UserDetails) context.getBean("userdetails");             //type case
	}
	
	
	@Test
	public void deleteUserDetailsTestCase()
	{                              
		userdetails.setId("Prd 001");
		boolean flag = userdetailsDAO.delete(userdetails);
		
		assertEquals("deleteuserdetailstestcase " , flag,false);
		
											// tp delet is workking fine or no
	    userdetailsDAO.delete(userdetails);
	}
	@Test
	public void addUserDetailsTestCase(){
		
		userdetails.setId("mobo5");
		
		userdetails.setName("laptop");
		userdetails.setEmail("mob");
		userdetails.setMobile("mob");
		userdetails.setAddress("mob");
		
		//userdetailsDAO.save(userdetails); // for ding this we need calll save method from userdetailsdao u can use both ways 
		
		assertEquals("addtestcase",userdetailsDAO.save(userdetails),true);	
	}
	


	@Test     // to fetch all records
	public void listUserDetailsTestCase()    // to check everything is work fine it will return list of records
	{
		
		assertEquals("UserDetails list testcase",userdetailsDAO.list().size(),2);     //compare to values we need to givr actual table rows value
	}
	
	@Test
	public void updateUserDetailsTestCase()
	{
		userdetails.setId("user01");
		userdetails.setName("bhuvana");
		
		userdetails.setEmail("mob");
		userdetails.setMobile("mob");
		userdetails.setAddress("mob");
		
		
		
		assertEquals("update   ",userdetailsDAO.update(userdetails),true);
	}
	@Test
	public void deleteUserDetailsTestCase1()
	{                              
		userdetails.setId("Prd 001");
		boolean flag = userdetailsDAO.delete(userdetails);
		
		assertEquals("deleteuserdetailstestcase " , flag,false);
		
											// tp delet is workking fine or no
	    userdetailsDAO.delete(userdetails);
	}
	
	
	
	@Test
	public void getUserDetailsTestCase()
	{
		assertEquals("get userdetails",userdetailsDAO.get("mob08"),null);
	}

	}



