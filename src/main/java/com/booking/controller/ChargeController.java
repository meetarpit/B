package com.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.booking.model.Offer;
import com.booking.model.Offer.Currency;
import com.booking.service.impl.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

import lombok.extern.java.Log;

/*used to send success or failure info in result page*/
@Log
@Controller
public class ChargeController {

    @Autowired
    StripeService paymentsService;

    @RequestMapping(value="/charge",method = RequestMethod.POST)
    public String charge(Offer offer, Model model) throws StripeException {
        offer.setDescription("Example charge");
        offer.setCurrency(Currency.INR);
        Charge charge = paymentsService.charge(offer);
        model.addAttribute("id", charge.getId());
        System.out.println("id"+charge.getId());
        model.addAttribute("status", charge.getStatus());
        model.addAttribute("chargeId", charge.getId());
        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
            return "result.html";
        }
    @ExceptionHandler(StripeException.class)
    public String handleError(Model model, StripeException ex) {
        model.addAttribute("error", ex.getMessage());
        return "result.html";
    }
}