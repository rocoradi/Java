package com.schoolofnet.Dialect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DialectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DialectApplication.class, args);
	}
	
	@Bean
	public FormDialect formDialect() {
		return new FormDialect();
	}
	
}
