package com.gcu.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class UserModelTest
{

	public UserModel user = new UserModel("testname", "pass", "test@test.com", "1234567890", 1);
	public UserModel blankUser = new UserModel();
	
	@Test
	void testConstructor()
	{
		Assert.assertNotNull(user);
		Assert.assertEquals("testname", user.getUsername());
		Assert.assertEquals("pass", user.getPassword());
		Assert.assertEquals("test@test.com", user.getEmail());
		Assert.assertEquals("1234567890", user.getPhoneNum());
		Assert.assertEquals(1, user.getUserId());
	}
	
	@Test
	void testDefaultConstructor()
	{
		Assert.assertNotNull(blankUser);
		Assert.assertEquals(null, blankUser.getUsername());
		Assert.assertEquals(null, blankUser.getPassword());
		Assert.assertEquals(null, blankUser.getEmail());
		Assert.assertEquals(null, blankUser.getPhoneNum());
		Assert.assertEquals(0, blankUser.getUserId());
	}

}
