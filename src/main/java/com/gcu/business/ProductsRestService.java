package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.ProductList;
import com.gcu.model.ProductModel;

/**
 * Product REST API. It returns all products from the database in JSON or XML format. Can also return products based on their ID number.
 *
 */
@RestController
@RequestMapping("/service")
public class ProductsRestService
{
	/**
	 * Products business service to retrieve data from
	 */
	@Autowired
	ProductBusinessService service;
	
	/**
	 * Gets the list of products in JSON format.
	 * @return JSON list of products.
	 */
	@GetMapping(path="/getjson", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getProductsAsJson()
	{
		try 
		{
			// Get products
			List<ProductModel> products = service.getProducts();
			
			// If product doesn't exist
			if(products == null) 
			{
				// Return not found
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
			else 
			{
				// Return product and OK
				return new ResponseEntity<>(products, HttpStatus.OK);
			}
		} 
		catch(Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Gets of product of specified id in JSON format.
	 * @return JSON list of products.
	 */
	@GetMapping(path="/getjson/{id}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> getOneProductAsJson(@PathVariable("id") int id)
	{
		try 
		{
			// Get product at id
			ProductModel product = service.getProductById(id);
			
			// If product doesn't exist
			if(product == null) 
			{
				// Return not found
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
			else 
			{
				// Return product and OK
				return new ResponseEntity<>(product, HttpStatus.OK);
			}
		} 
		catch(Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Gets the list of products in XML format.
	 * @return XML list of products.
	 */
	@GetMapping(path="/getxml", produces= {MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> getProductsAsXml()
	{
		try 
		{
			// Get products
			ProductList list = new ProductList();
			list.setProducts(service.getProducts());
			
			// If product doesn't exist
			if(list.getProducts() == null) 
			{
				// Return not found
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
			else 
			{
				// Return product and OK
				return new ResponseEntity<>(list, HttpStatus.OK);
			}
		} 
		catch(Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Gets the list of products in XML format.
	 * @return XML list of products.
	 */
	@GetMapping(path="/getxml/{id}", produces= {MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<?> getOneProductAsXml(@PathVariable("id") int id)
	{
		try 
		{
			// Get product at id
			ProductList list = new ProductList();
			list.setProducts(service.getProductById(id));
			
			// If product doesn't exist
			if(list.getProducts().get(0) == null) 
			{
				// Return not found
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
			else 
			{
				// Return product and OK
				return new ResponseEntity<>(list, HttpStatus.OK);
			}
		} 
		catch(Exception e) 
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
