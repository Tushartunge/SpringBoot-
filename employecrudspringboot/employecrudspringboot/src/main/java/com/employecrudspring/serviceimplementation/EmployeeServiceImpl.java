package com.employecrudspring.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employecrudspring.entity.Employee;
import com.employecrudspring.repository.EmpoyeeRepository;
import com.employecrudspring.service.EmployeeService;

@Service
public class EmployeeServiceImpl<EmployeeRepository> implements EmployeeService{

	@Autowired
	EmpoyeeRepository empRepository;
	
	@Override
	public Employee addEmployee(Employee emp) {
		empRepository.save(emp);
		return null;
	}

	@Override
	public Employee getEmployee(int id) {
		
		return null;
	}

	@Override
	public String deleteEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee updateEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
