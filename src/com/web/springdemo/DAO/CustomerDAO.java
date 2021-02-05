package com.web.springdemo.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.web.springdemo.entity.Customer;


public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

}
