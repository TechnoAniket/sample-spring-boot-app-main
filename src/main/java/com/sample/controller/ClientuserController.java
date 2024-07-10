package com.sample.controller;

import com.sample.model.ClientUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Api(value = "User Rest Controller", description = "REST API for User")
@RequestMapping("/api")
@RestController
public class ClientuserController {

	List<ClientUser> clientUsers = new ArrayList<ClientUser>();
	{
		clientUsers.add(new ClientUser(1,"User1", "ADMIN", "user1@test.com"));
		clientUsers.add(new ClientUser(2,"User2", "SUPERVISOR", "user2@test.com"));
		clientUsers.add(new ClientUser(3,"User3", "USER", "user3@test.com"));
		clientUsers.add(new ClientUser(4,"User4", "USER", "user4@test.com"));
	}

	@ApiOperation(value = "Get Users ", response = ClientUser.class, responseContainer = "List")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Success|OK", response = Integer.class),
			@ApiResponse(code = 401, message = "Not Authorized!"),
			@ApiResponse(code = 403, message = "Forbidden!"),
			@ApiResponse(code = 404, message = "Not Found!") })

	@RequestMapping(value = "/getUsers")
	public List<ClientUser> getUsers() {
		return clientUsers;
	}

	@ApiOperation(value = "Get User by User Id ", notes = "User by User Id will be returned.", response = ClientUser.class)
	@RequestMapping(value = "/getUser/{id}")
	public ClientUser getUserById(@PathVariable(value = "id") int id) {
		return clientUsers.stream().filter(x -> x.getId()==(id)).collect(Collectors.toList()).get(0);
	}

	@ApiOperation(value = "Get User by role ", produces = MediaType.APPLICATION_JSON_VALUE, response = ClientUser.class)
	@RequestMapping(value = "/getUser/role/{role}")
	public List<ClientUser> getUserByRole(@PathVariable(value = "role") String role) {
		return clientUsers.stream().filter(x -> x.getRole().equalsIgnoreCase(role))
				.collect(Collectors.toList());
	}
	
	@ApiOperation(value = "Update User by User Id ", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, notes = "Updated User by User Id will be returned.", response = ClientUser.class)
	@RequestMapping(value = "/updateUser/{id}")
	public ClientUser updateUserById(@PathVariable(value = "id") int id) {
		return clientUsers.stream().filter(x -> x.getId()==(id)).collect(Collectors.toList()).get(0);
	}
	
	

}
