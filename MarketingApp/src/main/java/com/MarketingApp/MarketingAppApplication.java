package com.MarketingApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.MarketingApp")
public class MarketingAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(MarketingAppApplication.class, args);
	}

}
