package com.wasim.customerdemo.config.services;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wasim.customerdemo.config.entity.Customer;




public interface ServiceDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	

}
