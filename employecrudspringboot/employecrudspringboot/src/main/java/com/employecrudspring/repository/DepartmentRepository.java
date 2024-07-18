package com.employecrudspring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.employecrudspring.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
