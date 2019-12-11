package com.smartshopping.authenticationservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthenticationServiceApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationServiceApplication.class);

	public static void main(String[] args) {
		LOGGER.info("start");
		SpringApplication.run(AuthenticationServiceApplication.class, args);
		LOGGER.info("end");
	}

}
