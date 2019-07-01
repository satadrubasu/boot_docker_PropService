package com.ansa.propertyservice.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationsBean {
	
	@Bean
	public Map<String,String> propertyMap(){
		Map<String,String> propertyMap = new HashMap<String,String>();
		propertyMap.put("keyOne", "valueOne");
		propertyMap.put("keyTwo", "valueTwo");
		propertyMap.put("keyThree", "valueThree");
		return propertyMap;
	}
	
	

}
