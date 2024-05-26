package com.capgemini.wsb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.capgemini.wsb.persistence.dao")
@ComponentScan("com.capgemini.wsb.service")
public class WsbJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsbJpaApplication.class, args);
	}
}
