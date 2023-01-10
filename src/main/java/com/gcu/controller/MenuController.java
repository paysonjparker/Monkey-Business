package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.gcu.business.ProductBusinessService;


/**
 * Controls the display of products on the main menu.
 */
@Controller
public class MenuController 
{
	// Retrieves products
	@Autowired
	ProductBusinessService productBusinessService;
	
	/**
	 * Displays main menu.
	 * @param model Model being passed to view.
	 * @return login html file
	 */
	@GetMapping("/")
	public String display(Model model) 
	{
		// If user is logged in, display products
		model.addAttribute("products", productBusinessService.getProducts());
		
		return "index";
	}
}
