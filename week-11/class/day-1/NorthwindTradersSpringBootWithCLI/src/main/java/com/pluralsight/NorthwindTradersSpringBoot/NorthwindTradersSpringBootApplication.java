package com.pluralsight.NorthwindTradersSpringBoot;

import com.pluralsight.NorthwindTradersSpringBoot.dao.CustomerDAO;
import com.pluralsight.NorthwindTradersSpringBoot.dao.SimpleCustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication //annotation
public class NorthwindTradersSpringBootApplication {

	private static CustomerDAO customerDAO;

//	DI - Dependency Injection
//	IoC - Inversion of Control

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(NorthwindTradersSpringBootApplication.class, args);

		customerDAO = context.getBean(SimpleCustomerDAO.class);
		customerDAO.getAll().stream().forEach(System.out::println);

	}

}
