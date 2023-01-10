package com.gcu.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * List of products as  or JSON
 */
@XmlRootElement(name="products")
public class ProductList
{

	private List<ProductModel> products = new ArrayList<ProductModel>();

	/**
	 * Gets individual products in XML form.
	 * @return The product in XML format.
	 */
	@XmlElement(name="product")
	public List<ProductModel> getProducts(){
		return this.products;
	}
	
	/**
	 * Sets the list of products.
	 * @param products The list of products.
	 */
	public void setProducts(List<ProductModel> products) 
	{
		this.products = products;
	}
	
	/**
	 * Sets the list of products to one product
	 * @param product
	 */
	public void setProducts(ProductModel product) 
	{
		List<ProductModel> products = new ArrayList<ProductModel>();
		products.add(product);
		
		this.products = products;
	}
}
