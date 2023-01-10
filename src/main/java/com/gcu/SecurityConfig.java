package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gcu.business.UserBusinessService;

/**
 * This class allows for the application to use Spring Security.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	// User service that handles authroization
	@Autowired
	UserBusinessService service;
	
	// Encodes passwords
	@Lazy
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	/**
	 * Replaces NOOP password encoder with bcrypt
	 * @return new BCryptPasswordEncoder object
	 */
	@Bean(name = "passwordEncoder")
	BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	/**
	 * Confugures spring security.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{	
		http.csrf().disable()
		.authorizeRequests()
		// Anyone may access these pages:
	        .antMatchers("/*", "/login/*", "/register/*", "/js/*", "/css/*", "/images/*").permitAll()
	        .anyRequest().authenticated()
	        .and()
		.formLogin()
			.loginPage("/login")
			// Login submitted with input id & name of "username" and "password" is treated
			// as official authentication
			.usernameParameter("username")
			.passwordParameter("password")
			.permitAll()
			.defaultSuccessUrl("/", true)
			.and()
			// Undos authentication
		.logout()
			.logoutUrl("/logout")
			.invalidateHttpSession(true)
			.clearAuthentication(true)
			.permitAll()
			.logoutSuccessUrl("/");
	}
	
	/**
	 * Autwired configure which takes care of the bean creation automatically.
	 */
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		// Handles user authorization
		auth.userDetailsService(service).passwordEncoder(passwordEncoder);
	}
}
