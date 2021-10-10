package com.wasim.customerdemo.config.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.wasim.customerdemo.config.entity.Customer;

@Service
@Repository
public class CustomerDAOImpl implements CustomerDAO{

	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public List<Customer> getCustomers() {
		List<Customer> customers = null;
		try {
		Session session=sessionFactory.getCurrentSession();
		Query<Customer> customer=session.createQuery("from customer",Customer.class);
		System.out.println(customer);
		customers=customer.getResultList();
		for(Customer c : customers) {
		System.out.println(c);
		}
		}catch(Exception e) {
			System.out.println(e);
		}
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		Session session=sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		
		Session session=sessionFactory.getCurrentSession();
		Customer customer=session.get(Customer.class, theId);
		return customer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		Session session=sessionFactory.getCurrentSession();
		
		session.delete(theId);
		
	}

}
