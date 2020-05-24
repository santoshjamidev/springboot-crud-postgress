package com.example.flywaydb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.flywaydb")
public class FlywaydbApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlywaydbApplication.class, args);
	}
}
