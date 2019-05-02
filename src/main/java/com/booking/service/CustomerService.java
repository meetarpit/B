package com.booking.service;

import java.util.List;

import com.booking.model.Admin;
import com.booking.model.Customer;

/*service interface for customer*/

public interface CustomerService {
	
	public void create(Customer customer);
	public void update(Customer customer);
	public void delete(Customer customer);
	public Customer Edit(int id);
	public Customer find(int id);
	public List<Customer> getAll();
	public boolean validate(Customer customer);
	public boolean adminValidate(Admin admin);
}
