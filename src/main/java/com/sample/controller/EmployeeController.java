package com.sample.controller;


import com.sample.model.Employee;
import com.sample.service.EmployeeService;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/service")
public class EmployeeController {

	private EmployeeService service = new EmployeeService();

	// http://localhost:8080/jaxrsdemo/service/Employees
	@GET
	@Path("/Employees")
	public List<Employee> getEmployees() {
		List<Employee> Employees = service.getAllEmployees();
		if (Employees.size() > 0)
			return Employees;
		throw new WebApplicationException(Response.Status.NOT_FOUND);
	}

	// http://localhost:8080/jaxrsdemo/service/Employees/1
	@GET
	@Path("/Employees/{id}")
	public Employee getEmployee(@PathParam("id") int id) {
		Employee Employee = service.getEmployee(id);
		if (Employee == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return Employee;
	}

	// http://localhost:8080/jaxrsdemo/service/Employees
	@POST
	@Path("/Employees")
	@Consumes(MediaType.APPLICATION_JSON) // HTTP Error 415 if not JSON
	@Produces(MediaType.APPLICATION_JSON) // HTTP Error 406 if not JSON
	public Response addEmployee(Employee Employee) {
		Employee newEmployee = service.add(Employee);
		if (newEmployee == null) {
			throw new WebApplicationException(Response.Status.NOT_IMPLEMENTED);
		}
		String message = "Employee id " + newEmployee.getId() + " created.";
		return Response
			      .status(Response.Status.CREATED)
			      .entity(message)
			      .build();
	}

	// http://localhost:8080/jaxrsdemo/service/Employees/1
	@DELETE
	@Path("/Employees/{id}")
	public Response deleteEmployee(@PathParam("id") int id) {
		Employee removedEmployee = service.delete(id);
		if (removedEmployee == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		String message = "Employee id " + removedEmployee.getId() + " removed.";
		return Response
			      .status(Response.Status.OK)
			      .entity(message)
			      .build();
	}
	
	// http://localhost:8080/jaxrsdemo/service/Employees/1
	@PUT
	@Path("/Employees/{id}")
	@Consumes(MediaType.APPLICATION_JSON) // HTTP Error 415 if not JSON
	@Produces(MediaType.APPLICATION_JSON) // HTTP Error 406 if not JSON
	public Response updateEmployee(@PathParam("id") int id, Employee Employee) {
		System.out.println("update received");
		Employee updateEmployee = service.update(id, Employee);
		if (updateEmployee == null) {
			throw new WebApplicationException(Response.Status.NOT_IMPLEMENTED);
		}
		String message = "Employee id " + updateEmployee.getId() + " updated.";
		return Response
			      .status(Response.Status.CREATED)
			      .entity(message)
			      .build();
	}
}