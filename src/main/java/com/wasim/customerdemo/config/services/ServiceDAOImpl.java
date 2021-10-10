package com.wasim.customerdemo.config.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wasim.customerdemo.config.dao.CustomerDAO;
import com.wasim.customerdemo.config.entity.Customer;

@Component
public class ServiceDAOImpl implements ServiceDAO {
    
	public ServiceDAOImpl() {
		super();
		System.out.println("123");
		
	}
	@Autowired
	private CustomerDAO customer;
	
	/*
	 * @Autowired public ServiceDAOImpl(CustomerDAO customer) { super();
	 * this.customer = customer; }
	 */

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		System.out.println("in getcutomers");
		return customer.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		
		customer.saveCustomer(theCustomer);

	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		return customer.getCustomer(theId);
	
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		
		customer.deleteCustomer(theId);

	}

}
