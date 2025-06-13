package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class NorthwindTradersSpringBootApplication {

	private static CustomerDAO customerDAO;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(NorthwindTradersSpringBootApplication.class, args);

		customerDAO = context.getBean(SimpleCustomerDAO.class);
		customerDAO.getAll().stream().forEach(System.out::println);

	}

}
