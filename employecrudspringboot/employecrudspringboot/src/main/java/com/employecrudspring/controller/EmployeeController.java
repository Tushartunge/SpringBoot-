package com.employecrudspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employecrudspring.entity.Employee;
import com.employecrudspring.serviceimplementation.EmployeeServiceImpl;

/*  post mapping -insert data
 * get mapping- retrive
 * put - update
 * delete- delete
 * */

// url-->  http://localhost:8080/addEmp

@RestController  // accept the request
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl service;
	
	@PostMapping("/addEmp")
	public Employee empAdd (@RequestBody Employee emp) // its work with my sql  // create 
	{
		return service.addEmployee(emp);
	}
}
