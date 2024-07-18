package com.employecrudspring.service;


import com.employecrudspring.entity.Department;

public interface DepartmentService {
    Department addDepartment(Department dept);
    Department getDepartment(int id);
    String deleteDepartment(int id);
    Department updateDepartment(int id, Department dept);
}
