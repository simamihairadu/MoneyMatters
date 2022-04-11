package com.moneymatters;

import com.moneymatters.data.domain.Transaction;
import com.moneymatters.mediators.TransactionMediator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class MoneymattersApplication {

	public static void main(String[] args) {

		ApplicationContext app = SpringApplication.run(MoneymattersApplication.class, args);
	}

}
