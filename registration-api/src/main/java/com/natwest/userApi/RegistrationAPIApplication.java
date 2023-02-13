package com.natwest.userApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RegistrationAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationAPIApplication.class, args);
	}

}
