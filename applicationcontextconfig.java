package com.project.shopping.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.project.shopping.model.Category;
import com.project.shopping.model.supplier;

public class applicationcontextconfig {
	@Configuration
	@ComponentScan("com.project.test")
	@EnableTransactionManagement
	public class ApplicationContextConfig {
		@Bean(name = "dataSource")
		public DataSource getDataSource() {
		    BasicDataSource dataSource = new BasicDataSource();
		    dataSource.setDriverClassName("org.h2.driver");
		    dataSource.setUrl("jdbc:h2:tcp://localhost/~/projectdb");
		    dataSource.setUsername("sa");
		    dataSource.setPassword("sa");
		 return dataSource;
		}
		private Properties getHibernateProperties() {
		    Properties properties = new Properties();
		    properties.put("hibernate.show_sql", "true");
		    properties.put("hibernate.dialect", "org.hibernate.dialect.h2Dialect");
		    return properties;
		}
		@Autowired
		@Bean(name = "sessionFactory")
		public SessionFactory getSessionFactory(DataSource dataSource) {
		 
		    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		 sessionBuilder.addProperties(getHibernateProperties());
		    sessionBuilder.addAnnotatedClasses(Category.class);
		 sessionBuilder.addAnnotatedClass(supplier.class);
		    return sessionBuilder.buildSessionFactory();
		}
		@Autowired
		@Bean(name = "transactionManager")
		public HibernateTransactionManager getTransactionManager(
		        SessionFactory sessionFactory) {
		    HibernateTransactionManager transactionManager = new HibernateTransactionManager(
		            sessionFactory);
		 
		    return transactionManager;
		}
		
	   
	 
	}

}
