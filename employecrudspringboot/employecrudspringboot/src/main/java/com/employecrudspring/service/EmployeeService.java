package com.employecrudspring.service;

import com.employecrudspring.entity.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee emp); // abstract method---> body in implemented class
	
	public Employee getEmployee (int id);	// return type can be anything Employee or String or int
	
	public String deleteEmployee();  // it can be also public Employee deleteEmployee(int id);
	public Employee updateEmployee(int id);


}
