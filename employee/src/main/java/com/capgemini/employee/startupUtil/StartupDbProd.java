package com.capgemini.employee.startupUtil;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "spring.profiles.active", havingValue = "prod")
public class StartupDbProd implements StartupDB{

	@Override
	public void setupDB() {
		
	   System.out.println("Prod DB is calling");	
	}
	

}
