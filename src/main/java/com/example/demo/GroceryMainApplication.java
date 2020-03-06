package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.controller","com.model","com.service"})
public class GroceryMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroceryMainApplication.class, args);
		System.out.println("code is running sucessfully");
	}

}
