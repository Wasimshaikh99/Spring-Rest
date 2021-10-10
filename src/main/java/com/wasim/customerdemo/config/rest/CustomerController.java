package com.wasim.customerdemo.config.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wasim.customerdemo.config.dao.CustomerDAO;
import com.wasim.customerdemo.config.dao.CustomerDAOImpl;
import com.wasim.customerdemo.config.entity.Customer;
import com.wasim.customerdemo.config.services.ServiceDAO;

@RestController
//@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerDAOImpl service;
	
	
	
	@GetMapping("/")
	public List<Customer> getCustomers(){
		System.err.println("in controller"+ service);
		return service.getCustomers();
	}
	@PutMapping("/customer/{theCustomer}")
	public void updateCustomer(@RequestBody Customer theCustomer) {
		
		service.saveCustomer(theCustomer);
	}
	@PostMapping("/customers/{theCustomer}")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		
		theCustomer.setId(0);
		service.saveCustomer(theCustomer);
		return theCustomer;
	}
	@DeleteMapping("/customer/{Id}")
	public void deletCustomer(@PathVariable int Id) {
		service.deleteCustomer(Id);
	}
	
	@GetMapping("/customer/{Id}")
	public Customer getCustomer(@PathVariable int id) {
		return service.getCustomer(id);
	}
}
