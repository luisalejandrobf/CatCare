package com.catcare.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatCare { 

    // Luis Bravo, Felipe Garcia, Ana Ortegon.
    // Used: Devtools, Spring Web, Thymeleaf.
    // VSCode Extensions: Java Ext Pack, Spring Boot Ext Pack, Codeium (Optional)

	// Port used: 8090. Defined in application.properties 

    // base url: http://localhost:8090/catcare/landing

	public static void main(String[] args) {
		SpringApplication.run(CatCare.class, args);
	}

}
