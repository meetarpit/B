package com.booking.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.booking.model.Offer;
import com.booking.service.OfferService;

/*Receives request form offer crude process*/
@Controller
public class OfferController {

	@Autowired
	OfferService offerService;
	
	@Value("pk_test_wur0vCdLGVDD6LoLtRkSIosw") //public key is generated from stripe developer account
    private String stripePublicKey;
	
	@RequestMapping(value="/offer",method=RequestMethod.GET)
	public String offer(Model model) {
		model.addAttribute("offer",new Offer());
		return "offer.jsp";		
	}
	@RequestMapping(value="/createoffer",method=RequestMethod.POST) //create new offers 
	public String createOffer(Offer offer) {
		Date date=new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    String strDate= formatter.format(date);  
		offer.setDateCreated(strDate);
		offerService.createOffer(offer);
		return "redirect:/offerList";	
	}
	@RequestMapping(value="/offerList",method=RequestMethod.GET) //display offers list
	public String list(Model model) {
		List<Offer>offer=offerService.getAll();
		model.addAttribute("offer",offer);
		return "offerList.jsp";		
	}
	@RequestMapping(value="/get/{id}",method=RequestMethod.GET) //Receives request when post any offer
	public String getOfferList(@PathVariable("id")int id,Model model,Offer of1) {
		Offer offer2=offerService.find(id);
		System.out.println("offerId"+offer2);
		offer2.setIsActive(true);
		offerService.updateOffer(offer2);
		String d1=offer2.getEnddate();
		System.out.println("d1"+d1);
		Date date=new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
	    String d2= formatter.format(date);  
	    System.out.println("d2"+d2);
	    if(d1.compareTo(d2)<0){
	    offer2.setIsExpired(true);
	    offer2.setExpiryDate("Expired");
	    offerService.updateOffer(offer2);
	    } 
		/*List<Offer>offerexp=offerService.findExpired();*/
		return "redirect:/offerList";		
	}
	@RequestMapping(value="/details",method=RequestMethod.GET) //display offers list with certain condition at user side
	public String details(Model model) {
		model.addAttribute("amount", 60 * 100); // in cents
        System.out.println("in checkout");
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", Offer.Currency.INR);
		List<Offer>offerlist=offerService.find();
		model.addAttribute("offerlist",offerlist);
		return "details.html";		
	}
	@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	public String edit(@PathVariable("id")int id,Model model) {
		Offer offer=offerService.find(id);
		model.addAttribute("offer",offer);		
		return "edit.jsp";		
	}
	@RequestMapping(value="/update",method=RequestMethod.POST) //used to update offers
	public String update(Offer offer) {
		
		offerService.updateOffer(offer);
		return "redirect:/offerList";		
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET) //used to delete offers
	public String delete(@PathVariable("id")int id,Offer offer) {
		offerService.deleteOffer(offer);
		return "redirect:/offerList";		
	}
	@RequestMapping(value="/searchData",method=RequestMethod.POST) //used to search data at admin side
	 public String getOfferByFilter(HttpServletRequest request, ModelMap map, @RequestParam(required = false) String filter){
	       request.setAttribute("msg","msg");
	        if(filter == null) {
	            map.addAttribute("offer", new Offer());
	            map.addAttribute("offer", offerService.getAll());
	        }else {
	            map.addAttribute("offer", new Offer());
	            map.addAttribute("offer", offerService.getAllOffer(filter));
	        }
	        return "offerList.jsp";
	    }
	@RequestMapping(value="/searchData1",method=RequestMethod.POST) //used to make search at user side
	 public String getOfferByFilterUser(HttpServletRequest request, ModelMap map, @RequestParam(required = false) String filter1){
	       	System.out.println("filter"+filter1);
	        map.addAttribute("amount", 60 * 100); // in cents
	        System.out.println("in checkout");
	        map.addAttribute("stripePublicKey", stripePublicKey);
	        map.addAttribute("currency", Offer.Currency.INR);
	        if(filter1 == null || filter1=="") {
	        	System.out.println("in if");
	            map.addAttribute("offer", new Offer());
	            map.addAttribute("offerlist", offerService.find());
	        }else {
	        	System.out.println("in else");
	            map.addAttribute("offer", new Offer());
	            map.addAttribute("offerlist", offerService.UserOffer(filter1));
	        }
	        return "details.html";
	    }
}
