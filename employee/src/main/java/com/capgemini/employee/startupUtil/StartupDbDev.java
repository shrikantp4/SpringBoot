package com.capgemini.employee.startupUtil;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component

@ConditionalOnProperty(   name = "spring.profiles.active", havingValue = "dev")
//@Import(DataSource.class)

public class StartupDbDev implements StartupDB{

	@Override
	public void setupDB() {
	   System.out.println("Dev DB is calling");	
	}
	

}
