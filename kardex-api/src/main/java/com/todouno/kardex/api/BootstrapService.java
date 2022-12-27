package com.todouno.kardex.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//
@EntityScan("com.todouno.kardex.data")  
@ImportResource({"classpath*:spring-context.xml"})

public class BootstrapService {
	
	public static void main(String[] args) {
		SpringApplication.run(BootstrapService.class, args);
		
	}

}
