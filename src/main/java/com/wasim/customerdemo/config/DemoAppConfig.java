package com.wasim.customerdemo.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan("com.wasim.customerdemo.config")
@EnableTransactionManagement
@PropertySource({ "classpath:persistence-mysql.properties" })
public class DemoAppConfig {
	
	@Autowired
	private Environment env;
	private Logger logger = Logger.getLogger(getClass().getName());
	
    @Bean
	public DataSource myDataSource() {
    	ComboPooledDataSource myDataSource=new ComboPooledDataSource();
    	
    	System.out.println("myDataSource is created");
    	//class loading
    	try {
			myDataSource.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
    	
    	logger.info("jdbc.url=" + env.getProperty("jdbc.url"));
		logger.info("jdbc.user=" + env.getProperty("jdbc.user"));
		
		System.out.println(env.getProperty("jdbc.url"));
		
    	//connetion information
    	myDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
    	myDataSource.setUser(env.getProperty("jdbc.user"));
    	myDataSource.setPassword(env.getProperty("jdbc.password"));
    	
    	
    	//set connection properties
    	
    	myDataSource.setInitialPoolSize(Integer.parseInt(env.getProperty("connection.pool.initialPoolSize")));
    	myDataSource.setMinPoolSize(Integer.parseInt(env.getProperty("connection.pool.minPoolSize")));
    	myDataSource.setMaxPoolSize(Integer.parseInt(env.getProperty("connection.pool.maxPoolSize")));
    	myDataSource.setMaxIdleTime(Integer.parseInt(env.getProperty("connection.pool.maxIdleTime")));
    	
    	System.out.println(myDataSource);
    	return myDataSource;
    	
    	
    }
    
    //create method to set hibernate properties
    
    public Properties hibernatePropertys() {
    	
    	Properties prop=new Properties();
    	prop.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
    	prop.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
    	return prop;
    }
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
    	LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    	
    	sessionFactory.setDataSource(myDataSource());
    	sessionFactory.setHibernateProperties(hibernatePropertys());
    	sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
    	return sessionFactory;
    }
    
    //creat method for transaction management
    
    @Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		
		// setup transaction manager based on session factory
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}	
    
    
}
