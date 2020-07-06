package com.capgemini.employee;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.capgemini.employee.startupUtil.StartupDB;

//@EnableAutoConfiguration(exclude=DataSource.class)

//@EnableAutoConfiguration(exclude=SecurityAutoConfiguration.class)
@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =
		SpringApplication.run(EmployeeApplication.class, args);
		
		Arrays.asList(ctx.getBeanDefinitionNames()).stream().sorted().forEach(System.out::println);
		
		ctx.getBean(StartupDB.class).setupDB();
	}

}




