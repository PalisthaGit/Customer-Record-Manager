package com.web.springdemo.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	//get sessionFactory
	@Autowired
	SessionFactory sessionFactory;

	
	@Override
	public List<Customer> getCustomers() {
	
		//get Current session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//create query
		Query<Customer> theQuery=currentSession.createQuery("from Customer order by firstName", Customer.class);
		
		//query to result list
		List<Customer> customers=theQuery.getResultList();
		
		//return list of customers
		return customers;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {
		//get session factory
		Session currentSession=sessionFactory.getCurrentSession();
		
		//save customer
		currentSession.saveOrUpdate(theCustomer);
		
	}


	@Override
	public Customer getCustomer(int theId) {
		//get the hiberante session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//read customer using primary key
		Customer theCustomer=currentSession.get(Customer.class, theId);
		return theCustomer;
	}


	@Override
	public void deleteCustomer(int theId) {
		//get curretnt session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//delete customer using pk
		Query theQuery=currentSession.createQuery("DELETE FROM Customer WHERE id=:customerId");
		
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
		
	}

}
