package com.catcare.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class CatCare { 

    // Luis Bravo, Felipe Garcia, Ana Ortegon.
    // Used: Devtools, Spring Web, Thymeleaf, Rest.
    // VSCode Extensions: Java Ext Pack, Spring Boot Ext Pack, Codeium (Optional)

	// Port used: 8090. Defined in application.properties 

    // base url: http://localhost:8090/catcare/landing
    // ---> Swagger UI: http://localhost:8090/swagger-ui/index.html

	public static void main(String[] args) {
		SpringApplication.run(CatCare.class, args);
	}
}
