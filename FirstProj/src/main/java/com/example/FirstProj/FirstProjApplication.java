package com.example.FirstProj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstProjApplication {

	public static void main(String[] args) {
		//Spring Container is created
		ConfigurableApplicationContext context = SpringApplication.run(FirstProjApplication.class, args);

		Alien a1 = context.getBean(Alien.class);
		a1.show();


		System.out.println("Welcome to Spring Boot");
	}

}
