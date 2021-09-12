package com.onato.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.onato.assignment")
public class OnatoAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnatoAssignmentApplication.class, args);
	}
}
