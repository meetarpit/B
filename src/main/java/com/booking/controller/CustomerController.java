package com.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.booking.model.Customer;
import com.booking.service.CustomerService;

//Receives request for user registration process
@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("customer",new Customer());
		return "index.jsp";		
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String create(Customer customer) {
		customerService.create(customer);
		return "redirect:/";		
	}
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {
		List<Customer> customer=customerService.getAll();
		model.addAttribute("customer", customer);
		return "list.jsp";		
	}
}
