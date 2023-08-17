package com.catcare.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatCare {

	// Port used: 8090. Defined in application.properties 

	public static void main(String[] args) {
		SpringApplication.run(CatCare.class, args);
	}

}
