package com.daw.conmed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class ConmedApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConmedApplication.class, args);
	}

}
