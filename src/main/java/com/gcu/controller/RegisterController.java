package com.gcu.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.ProductBusinessService;

import com.gcu.business.UserBusinessService;
import com.gcu.model.UserModel;

/**
 * Controls the registering a new user functionalities.
 *
 */
@Controller
@RequestMapping("/register")
public class RegisterController 
{

	Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	UserBusinessService service;
	
	// Retrieves products - temporary?
	@Autowired
	ProductBusinessService productBusinessService;
	
	/**
	 * Displays the register page.
	 * @param model model being passed to the view.
	 * @return register html file
	 */
	@GetMapping("/")
	public String display(Model model) 
	{
		logger.info("==========> ENTER RegisterController.display() at " + "/register");

		//display the register page.
		model.addAttribute("userModel", new UserModel());

		logger.info("==========> EXIT RegisterController.display() at " + "/register");

		return "register";
	}
	
	/**
	 * Registers a new user.
	 * @param userModel User that is attempting to login.
	 * @param bindingResult bindingResult
	 * @param model model being passed to the view.
	 * @return register html view.
	 */
	@PostMapping("/doRegister")
	public String doRegister(@Valid UserModel userModel, BindingResult bindingResult, Model model)
	{
		logger.info("==========> ENTER ProductController.doRegister() at " + "/register/doRegister");

		// If register credentials are invalid, stay at register view
		if (bindingResult.hasErrors())
		{
			logger.warn("==========> Invalid input at ProductController.doRegister() at /register/doRegister");
			return "register";
		}
		
		// If register credentials are valid, add user to db and return to main menu
		service.addUser(userModel);
		logger.info("==========> Registered user: {},{},{},{}", userModel.getUserId(), userModel.getUsername(), userModel.getEmail(), userModel.getPhoneNum());
		// Returns empty product list
		model.addAttribute("products", productBusinessService.getProducts());

		logger.info("==========> EXIT ProductController.doRegister() at " + "/register/doRegister");
		// Returns main menu view
		return "redirect:/";
	}
}
