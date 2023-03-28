package com.gcu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	Logger logger = LoggerFactory.getLogger(LoginController.class);

	/**
	 * Displays the login page.
	 * @param model model being passed to view.
	 * @return login html file
	 */
	@GetMapping("/login")
	public String display(Model model) 
	{
		logger.info("==========> ENTER LoginController.display() at " + "/login");

		logger.info("==========> EXIT LoginController.display() at " + "/login");

		return "login";
	}
}
