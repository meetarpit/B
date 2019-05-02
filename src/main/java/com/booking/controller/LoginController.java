package com.booking.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.booking.model.Admin;
import com.booking.model.Customer;
import com.booking.model.Offer;
import com.booking.service.CustomerService;

/*Receives request for user and admin login*/

@Controller
public class LoginController {
	
	
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("customer", new Customer());
		return "login.jsp";		
	}
	@RequestMapping(value="/dologin",method=RequestMethod.POST)
	public String dologin(Customer customer,Model model,HttpServletRequest request,Offer offer) {
		 
		boolean result=customerService.validate(customer);
		if(result==true) {
			HttpSession session= request.getSession();
			session.setAttribute("email",customer.getName());

			return "redirect:/details";
		}
		model.addAttribute("customer", new Customer());
		return "login.jsp";	
	}
	@RequestMapping(value="/admin",method=RequestMethod.GET)
	public String adminLogin(Model  model) {
		model.addAttribute("admin", new Admin());
		return "adminlogin.jsp";		
	}
	@RequestMapping(value="/adminlogin",method=RequestMethod.POST)
	public String doAdminLogin(Admin admin,Model model,HttpServletRequest request) {
		boolean result=customerService.adminValidate(admin);
		System.out.println("result"+result);
		if(result==true) {
			
			HttpSession session= request.getSession();
			session.setAttribute("email1",admin.getAname());
			return "redirect:/offerList";
		}
		model.addAttribute("admin", new Admin());
		return "adminlogin.jsp";		
	}
	@RequestMapping(value="/exit",method=RequestMethod.GET)
	public String logoutDo(HttpServletRequest request,HttpServletResponse response,Model model){
		HttpSession session= request.getSession(false);
		         session= request.getSession(false);
		        if(session != null) {
		            session.invalidate();
		        }
		        for(Cookie cookie : request.getCookies()) {
		            cookie.setMaxAge(0);
		        }
            model.addAttribute("customer", new Customer());
		    return "login.jsp";
		}
	@RequestMapping(value="/exitadmin",method=RequestMethod.GET)
	public String logoutAdmin(HttpServletRequest request,HttpServletResponse response,Model model){
		HttpSession session= request.getSession(false);
		         session= request.getSession(false);
		        if(session != null) {
		            session.invalidate();
		        }
		        for(Cookie cookie : request.getCookies()) {
		            cookie.setMaxAge(0);
		        }
		    	model.addAttribute("admin", new Admin());
		    return "adminlogin.jsp";
		}
}
