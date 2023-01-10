package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Model class for products.
 *
 */
public class ProductModel {

	@NotNull(message="Product name is a required field")
	@Size(min=1, max=32, message="Product name must be between 1 and 32 characters")
	private String name;
	@NotNull(message="Description is a required field")
	@Size(min=1, max=300, message="Description must be between 1 and 300 characters")
	private String description;
	@NotNull(message="Product size is a required field")
	@Size(min=1, max=32, message="Product size must be between 1 and 32 characters")
	private String size;
	@NotNull(message="Product price is a required field")
	private double price;
	
	private int productId;
	
	/**
	 * @param name Product name.
	 * @param description Product description.
	 * @param size Product size.
	 * @param price Product price.
	 */
	public ProductModel(String name, String description, String size, double price, int productId) {
		this.name = name;
		this.description = description;
		this.size = size;
		this.price = price;
		this.productId = productId;
	}
	
	/**
	 * Default constructor for product.
	 */
	public ProductModel() 
	{

	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the decription to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return product ID
	 */
	public int getProductId() 
	{
		return productId;
	}
	
	/**
	 * @param productId the Product ID to set.
	 */
	public void setProductId(int productId) 
	{
		this.productId = productId;
	}
}
