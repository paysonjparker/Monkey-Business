package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controls login functionalities.
 *
 */
@Controller
public class LoginController 
{
	/**
	 * Displays the login page.
	 * @param model model being passed to view.
	 * @return login html file
	 */
	@GetMapping("/login")
	public String display(Model model) 
	{
		return "login";
	}
}
