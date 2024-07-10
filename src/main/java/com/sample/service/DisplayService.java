package com.sample.service;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DisplayService {

    public String sayHello(String name) {
        return "Hello "+ name;
    }
    
    public String getDisplay(String resourceUrl) {
    	
    	RestTemplate restTemplate = new RestTemplate();
    	
    	ResponseEntity<String> responseEntity
    	  = restTemplate.getForEntity(resourceUrl, String.class);
    	
    	if(HttpStatus.valueOf(responseEntity.getStatusCode().value()).equals(HttpStatus.OK)) {
    		return responseEntity.getBody();
    	}
    	
        return null;
    }
    
    
}
