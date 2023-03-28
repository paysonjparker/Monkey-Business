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
import org.springframework.web.bind.annotation.RequestParam;

import com.gcu.business.ProductBusinessService;
import com.gcu.model.ProductModel;

/**
 * Controls the product functionalites.
 *
 */
@Controller
@RequestMapping("/product")
public class ProductController 
{

	Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductBusinessService service;
	
	/**
	 * Displays the products page.
	 * @param model model being passed to view.
	 * @return login html file
	 */
	@GetMapping("/")
	public String display(Model model) 
	{
		logger.info("==========> ENTER ProductController.display() at " + "/product");

		//display the product create page.
		model.addAttribute("productModel", new ProductModel());

		logger.info("==========> EXIT ProductController.display() at " + "/product");

		return "product";
	}
	
	/**
	 * Creates a new product.
	 * @param productModel Product being created.
	 * @param bindingResult bindingReuslt
	 * @param model model being passed to the view.
	 * @return The page reflecting either a succesful or unsuccessful login.
	 */
	@PostMapping("/doCreate")
	public String doCreate(@Valid ProductModel productModel, BindingResult bindingResult, Model model)
	{
		logger.info("==========> ENTER ProductController.doCreate() at " + "/product/doCreate");

		// If login credentials are invalid, stay at register view
		if (bindingResult.hasErrors())
		{
			return "product";
		}
		// If login credentials are valid, return to menu view
		else
		{
			service.addProduct(productModel);
			
			// Returns product list
			model.addAttribute("products", service.getProducts());

			logger.info("==========> EXIT ProductController.doCreate() at " + "/product/doCreate");

			return "redirect:/";
		}
	}
	
	/**
	 * Redirects user to update page for designated id
	 * @param model model being passed to the view.
	 * @param productId ID of the product being updated.
	 * @return the update page.
	 */
	@GetMapping("/update")
	public String update(Model model, @RequestParam(name="id", required = true) Integer productId) 
	{
		logger.info("==========> ENTER ProductController.update() at " + "/product/update");

		//display the product create page.
		model.addAttribute("productModel", service.getProductById(productId));

		logger.info("==========> EXIT ProductController.update() at " + "/product/update");

		return "updateProduct";
	}
	
	/**
	 * Updates product
	 * @param productModel Updated product model.
	 * @param bindingResult bindingResult.
	 * @param model model being passed to the view.
	 * @return the update page or index if update was succesful.
	 */
	@PostMapping("/doUpdate")
	public String doUpdate(@Valid ProductModel productModel, BindingResult bindingResult, Model model)
	{
		logger.info("==========> ENTER ProductController.doUpdate() at " + "/product/doUpdate");

		// If product credentials are invalid, stay at update view
		if (bindingResult.hasErrors())
		{
			return "updateProduct";
		}
		// If product credentials are valid, return to menu view
		else
		{			
			// Updates product
			service.update(productModel);
			
			// Returns updated product list
			model.addAttribute("products", service.getProducts());

			logger.info("==========> ENTER ProductController.doUpdate() at " + "/product/doUpdate");

			return "redirect:/";
		}
	}
	
	/**
	 * Deletes product
	 * @param model model being passed to the view.
	 * @param productId ID of the product being deleted.
	 * @return return to index page after product has been deleted.
	 */
	@GetMapping("/delete")
	public String delete(Model model, @RequestParam(name="id", required = true) Integer productId) 
	{
		logger.info("==========> ENTER ProductController.delete() at " + "/product/delete");

		// Delets product
		service.delete(service.getProductById(productId));
		
		// Gets updated product list
		model.addAttribute("products", service.getProducts());

		logger.info("==========> EXIT ProductController.delete() at " + "/product/delete");

		return "redirect:/";
	}
}
