package com.zoho.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zoho.entities.Billing;
import com.zoho.entities.Contacts;
import com.zoho.services.BillingService;
import com.zoho.services.ContactService;

@Controller
public class BillingController {
	@Autowired
	private ContactService contactService;
	@Autowired
	private BillingService billingService;
	//bug no-130
	int i=20
	String name="raghunath hembram";
     @RequestMapping("/billingForm")
	public String viewBillingForm(@RequestParam("contactId")long id,Model model) {
    	 Contacts contact = contactService.findContactById(id);
    	 model.addAttribute("contact",contact);
		return "create_bill"; 
	}
     @RequestMapping("/generateBill")
     public String generateBill(@ModelAttribute("billing")Billing billing) {
    	 billingService.generateInvoice(billing);
    	 return "create_bill";
     }
	
}
