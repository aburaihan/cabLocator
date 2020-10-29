package com.example.cabLocator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.example.cabLocator"})
@EntityScan(basePackages = {"com.example.cabLocator.model.domain"})
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = {"com.example.cabLocator.repository"})

@SpringBootApplication
public class CabLocatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabLocatorApplication.class, args);
	}

}
