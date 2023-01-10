package com.gcu.model;

import org.junit.Assert;
import org.junit.Test;

public class ProductModelTest
{

	public ProductModel prod = new ProductModel("testprod", "testytest", "tester", 10.0, 1);
	public ProductModel blankProd = new ProductModel();
	
	@Test
	public void testProductModelStringStringStringDoubleInt()
	{
		Assert.assertNotNull(prod);
		Assert.assertEquals("testprod", prod.getName());
		Assert.assertEquals("testytest", prod.getDescription());
		Assert.assertEquals("tester", prod.getSize());
		Assert.assertEquals(10.0, prod.getPrice(), 10.0);;
		Assert.assertEquals(1, prod.getProductId());
	}

	@Test
	public void testProductModel()
	{
		Assert.assertNotNull(blankProd);
		Assert.assertEquals(null, blankProd.getName());
		Assert.assertEquals(null, blankProd.getDescription());
		Assert.assertEquals(null, blankProd.getSize());
		Assert.assertEquals(null, blankProd.getPrice(), null);;
		Assert.assertEquals(0, blankProd.getProductId());
	}

}
