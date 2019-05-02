package com.booking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.booking.dao.CustomerDao;
import com.booking.model.Admin;
import com.booking.model.Customer;
import com.booking.service.CustomerService;

/*service implementation class for customer used to call methods defined in Dao*/

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao customerDao;
	
	public void create(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.create(customer);
	}

	public void update(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.update(customer);
	}

	public void delete(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.delete(customer);
	}

	public Customer Edit(int id) {
		// TODO Auto-generated method stub
		return customerDao.Edit(id);
	}

	public Customer find(int id) {
		// TODO Auto-generated method stub
		return customerDao.find(id);
	}

	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return customerDao.getAll();
	}

	public boolean validate(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.validate(customer);
	}

	public boolean adminValidate(Admin admin) {
		// TODO Auto-generated method stub
		return customerDao.adminValidate(admin);
	}

}
