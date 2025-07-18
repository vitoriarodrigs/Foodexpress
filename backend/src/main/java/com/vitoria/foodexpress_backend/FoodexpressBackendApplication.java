package com.vitoria.foodexpress_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoodexpressBackendApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.location",
				"optional:classpath:/,optional:file:./config/,file:${user.dir}/backend/src/main/resources/");
		SpringApplication.run(FoodexpressBackendApplication.class, args);

	}

}
