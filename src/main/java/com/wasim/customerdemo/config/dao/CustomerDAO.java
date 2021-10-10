package com.wasim.customerdemo.config.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.wasim.customerdemo.config.entity.Customer;


public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
