package com.sample.filters;

import org.springframework.web.server.ServerWebExchange;

public class MethodFilter {
	
	public void identifyTheCall(ServerWebExchange exchange) {
		
		String endpointMethod = "GET";
		
		boolean methodMatch = exchange.getRequest().getMethodValue().equals(endpointMethod);
		if (methodMatch ) {
		    System.out.println("Matching successful");
		}
		
	}

		

}
