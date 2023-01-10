package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Runs the application
 *
 */
@SpringBootApplication
@ComponentScan({"com.gcu"})
public class MilestoneProjectCst339Application {

	/**
	 * Runs the application
	 * @param args args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MilestoneProjectCst339Application.class, args);
	}

}
