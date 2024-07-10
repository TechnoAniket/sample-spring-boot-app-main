package com.sample.service;


import com.sample.model.Employee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeService {
	private static List<Employee> Employees = new ArrayList<Employee>();

	private static int EmployeesCount = 0;
	static {
		Employees.add(new Employee(++EmployeesCount, "Tony Stark", "ironman@avengers.inc"));
		Employees.add(new Employee(++EmployeesCount, "Steve Rogers", "captain@avengers.inc"));
		Employees.add(new Employee(++EmployeesCount, "Bruce Banner", "hulk@avengers.inc"));
	}

	public List<Employee> getAllEmployees() {
		return Employees;
	}

	public Employee getEmployee(int id) {
		for (Employee Employee : Employees) {
			if (Employee.getId() == id) {
				return Employee;
			}
		}
		return null;
	}

	public Employee add(Employee Employee) {
		Employee.setId(++EmployeesCount);
		Employees.add(Employee);
		return Employee;
	}

	public Employee delete(int id) {
		Iterator<Employee> iterator = Employees.iterator();
		while (iterator.hasNext()) {
			Employee Employee = iterator.next();
			if (Employee.getId() == id) {
				iterator.remove();
				return Employee;
			}
		}
		return null;
	}

	public Employee update(int id, Employee updatedEmployee) {
		Employee foundEmployee = getEmployee(id);
		if (foundEmployee == null || updatedEmployee == null) {
			return null;
		}
		foundEmployee.setEmail(updatedEmployee.getEmail());
		foundEmployee.setName(updatedEmployee.getName());
		return null;
	}
}
