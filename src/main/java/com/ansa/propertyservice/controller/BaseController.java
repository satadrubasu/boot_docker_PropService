package com.ansa.propertyservice.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.InstanceInfo;

@RestController
public class BaseController {
  @Autowired
  Map<String,String> propertyMap;
  
  @Autowired 
  private ApplicationInfoManager applicationInfoManager;
  
  @Value("${server.port}")
  private String serverPort;
	
  @RequestMapping("/")
  public String checkEndpoint() {
	  InstanceInfo applicationInfo = applicationInfoManager.getInfo();
	  return " Property Service is up in a container with--"
	  		+ "\nContainer Hostname : " + applicationInfo.getHostName()
	  		+ "\nContainer Port :" + serverPort
	  		+ "\nContainer IP Address :" + applicationInfo.getIPAddr();
  }
  
  @RequestMapping("/all")
  public Map<String,String> allProperties() {
	  
	  return propertyMap;
  }  
  
}
