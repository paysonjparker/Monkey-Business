package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gcu.data.DataAccessInterface;
import com.gcu.model.UserModel;

/**
 * Uses the data access interface to access user data from the MySQL database.
 *
 */
@Service
public class UserBusinessService implements UserDetailsService
{
	// Object that accesses data layer
	@Autowired
	private DataAccessInterface<UserModel> service;
		
	/**
	 * Returns all products from database
	 * @return list of products
	 */
	public List<UserModel> getUsers()
	{
		return service.findAll();
	}
	
	/**
	 * Adds a user to the database.
	 * @param user User model being added to the database.
	 */
	public void addUser(UserModel user)
	{
		service.create(user);
	}

	/**
	 * Loads user by username - required for password decryption
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		// Gets user
		UserModel user = service.findByUsername(username);
		
		if(user!=null)
		{
			// Verifies user by encrypted password
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("USER"));
			
			return new User(user.getUsername(), user.getPassword(), authorities);
		}
		else
		{
			throw new UsernameNotFoundException("Username not found");
		}
	}
	
	
}
