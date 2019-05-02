package com.booking.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.booking.dao.CustomerDao;
import com.booking.model.Admin;
import com.booking.model.Customer;

/*Repository implementation class for customer*/
@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	SessionFactory sessionFactory;
	
	protected Session currentSession() {
		return sessionFactory.getCurrentSession();		
	}
	
	public void create(Customer customer) {
		// TODO Auto-generated method stub
		currentSession().save(customer);
	}

	public void update(Customer customer) {
		// TODO Auto-generated method stub
		currentSession().update(customer);
	}

	public void delete(Customer customer) {
		// TODO Auto-generated method stub
		currentSession().delete(customer);
	}

	public Customer Edit(int id) {
		// TODO Auto-generated method stub
		return find(id);
	}

	public Customer find(int id) {
		// TODO Auto-generated method stub
		return (Customer) currentSession().get(Customer.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return currentSession().createCriteria(Customer.class).list();
	}

	public boolean validate(Customer customer) {
		// TODO Auto-generated method stub
		Criteria ct=currentSession().createCriteria(Customer.class);
		ct.add(Restrictions.eq("name", customer.getName()));
		ct.add(Restrictions.eq("password",customer.getPassword()));
		@SuppressWarnings("unchecked")
		List<Customer>result=ct.list();
		if(result.size()>0) {
			
			return true;
		}
		return false;
	}

	public boolean adminValidate(Admin admin) {
		Criteria ct=currentSession().createCriteria(Admin.class);
		ct.add(Restrictions.eq("aname", admin.getAname()));
		ct.add(Restrictions.eq("apassword",admin.getApassword()));
		@SuppressWarnings("unchecked")
		List<Admin>result=ct.list();
		if(result.size()>0) {
			return true;
		}
		return false;
	}

}
