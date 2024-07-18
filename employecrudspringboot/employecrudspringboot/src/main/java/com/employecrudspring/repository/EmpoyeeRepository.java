package com.employecrudspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employecrudspring.entity.Employee;
//employee repo extending from jpa repo
public interface EmpoyeeRepository extends JpaRepository<Employee, Integer> {

	
}
