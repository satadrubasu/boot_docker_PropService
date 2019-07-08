package com.ansa.propertyservice.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

  private final Logger        logger            = LoggerFactory.getLogger(this.getClass());
  
  @RequestMapping("/")
  public String checkEndpoint() {
	  InstanceInfo applicationInfo = applicationInfoManager.getInfo();
	  logger.info("Property Service check health endpoint called.");
	  return " Property Service is up in a container with --"
	  		+ "\n   Container Hostname   : " + applicationInfo.getHostName()
	  		+ "\n   Container Port       : " + serverPort
	  		+ "\n   Container IP Address : " + applicationInfo.getIPAddr();
  }
  
  @RequestMapping("/all")
  public Map<String,String> allProperties() {
	  
	  return propertyMap;
  }  
  
}
