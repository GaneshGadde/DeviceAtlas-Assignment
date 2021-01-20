package com.deviceatlas.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.deviceatlas.assignment")
public class DeviceAtlasAssignment extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DeviceAtlasAssignment.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(DeviceAtlasAssignment.class, args);
	}

}