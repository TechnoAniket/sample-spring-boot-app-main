package com.sample.service.impl;

import org.springframework.stereotype.Service;

import com.sample.model.ClientUser;
import com.sample.service.ClientService;

@Service("ClientService")
public class ClientServiceImpl implements ClientService{
	
	@Override
	public ClientUser findClientUser(int id) {
		return new ClientUser(1000,"ClientServiceUser", "ADMIN", "user1000@test.com");
	}

}
