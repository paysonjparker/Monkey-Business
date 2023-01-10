package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.DataAccessInterface;
import com.gcu.model.ProductModel;

/**
 * Uses the data access interface to access data from the MySQL database.
 *
 */
@Service
public class ProductBusinessService 
{	
	@Autowired
	DataAccessInterface<ProductModel> service;
		
	/**
	 * Returns all products from database
	 * @return list of products
	 */
	public List<ProductModel> getProducts()
	{
		return service.findAll();
	}
	
	/**
	 * Gets product by its ID.
	 * @param id ID being searched for.
	 * @return The product Model of that ID.
	 */
	public ProductModel getProductById(int id)
	{
		return service.findById(id);
	}
	
	/**
	 * Adds a product to the database.
	 * @param product Product model being created.
	 */
	public void addProduct(ProductModel product)
	{
		service.create(product);
	}

	/**
	 * Updates a product's variables.
	 * @param product Product being edited.
	 */
	public void update(ProductModel product) 
	{
		service.update(product);
	}

	/**
	 * Deletes a product from the database.
	 * @param product Product model being deleted.
	 */
	public void delete(ProductModel product) 
	{
		service.delete(product);
	}

}
