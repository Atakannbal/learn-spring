package com.springdemo.mvc.dao;

import java.util.List;

import javax.transaction.Transactional;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springdemo.mvc.SortUtils;
import com.springdemo.mvc.entity.Customer;

@Repository
@RequiredArgsConstructor
public class CustomerDAOImpl implements CustomerDAO {

    // need to inject the session factory
    final SessionFactory sessionFactory;
    
    @Override
    public List<Customer> getCustomers(int theSortField) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // determine sort field
        String theFieldName = null;

        switch (theSortField) {
			case SortUtils.FIRST_NAME: 
				theFieldName = "firstName";
				break;
			case SortUtils.LAST_NAME:
				theFieldName = "lastName";
				break;
			case SortUtils.EMAIL:
				theFieldName = "email";
				break;
			default:
				// if nothing matches the default to sort by lastName
				theFieldName = "lastName";
		}
        
        // create a query
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by " + theFieldName,
                                                              Customer.class);

        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();

        // return the results
        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // save the customer (if no id INSERT, else UPDATE)
        currentSession.saveOrUpdate(theCustomer);
        
    }

    @Override
    public Customer getCustomer(int theId) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // retreieve/read from database using primary key
        Customer theCustomer = currentSession.get(Customer.class, theId);

        return theCustomer;
    }

    @Override
    public Object deleteCustomer(int theId) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete the object with primary key
        Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
        theQuery.setParameter("customerId", theId);

        theQuery.executeUpdate();

        return null;
    }

    @Override
    public List<Customer> searchCustomer(String theSearchName) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery = null;

        // search by name if the search name is not empty

        if(theSearchName !=null && theSearchName.trim().length() > 0) {
            theQuery = currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
        } else { // theSearchName is empty ... so just get all customers
            theQuery = currentSession.createQuery("from Customer", Customer.class);
        }

        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();

        // return the results
        return customers;
    }
    
    
}
