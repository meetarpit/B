package com.booking.dao;

import java.util.List;

import com.booking.model.Admin;
import com.booking.model.Customer;

//repository for customer and admin
public interface CustomerDao {
	
	public void create(Customer customer); //used to save data into database
	public void update(Customer customer); //used to update data into database
	public void delete(Customer customer); //used delete data at admin side
	public Customer Edit(int id);//used to edit data with id
	public Customer find(int id);//used to find data by id
	public List<Customer> getAll(); //used to return list of all customer but not in use
	public boolean validate(Customer customer); //used for login process for customer
	public boolean adminValidate(Admin admin); //used for admin login process 
	

}
