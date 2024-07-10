package com.sample.service.impl;

import org.springframework.stereotype.Service;

import com.sample.model.ClientUser;
import com.sample.service.ClientService;

@Service("MockClientService")
public class MockClientService implements ClientService{
	
	@Override
	public ClientUser findClientUser(int id) {
		return new ClientUser(2000,"MockClientServiceUser", "ADMIN", "user2000@test.com");
	}

}