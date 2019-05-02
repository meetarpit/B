package com.booking.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.booking.model.Offer;

//used to send all data in payment gateway (checkout.html) page but not it use.
//its implementation has already provided in offers controller
@Controller
public class CheckoutController {

    @Value("pk_test_wur0vCdLGVDD6LoLtRkSIosw")
    private String stripePublicKey;

    @RequestMapping("/checkout")
    public String checkout(Model model) {
    	model.addAttribute("amount", 60 * 100); // in cents
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", Offer.Currency.INR);
        return "checkout.html";
    }
    
    
}