package com.moneymatters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class MoneymattersApplication {

	public static void main(String[] args) {

		ApplicationContext app = SpringApplication.run(MoneymattersApplication.class, args);
	}

}
