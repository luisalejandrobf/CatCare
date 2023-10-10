package com.catcare.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class CatCare { 

    // SpringBoot Initial BACKUP

    // Luis Bravo, Felipe Garcia, Ana Ortegon.
    // Used: Devtools, Spring Web, Thymeleaf.
    // VSCode Extensions: Java Ext Pack, Spring Boot Ext Pack, Codeium (Optional)

	// Port used: 8090. Defined in application.properties

    // Este springboot es la version inicial sin Rest. Para Rest, consultar /project

    // base url: http://localhost:8090/catcare/landing

	public static void main(String[] args) {
		SpringApplication.run(CatCare.class, args);
	}

}
