package com.employecrudspring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.employecrudspring.entity.Department;
import com.employecrudspring.service.DepartmentService;

//url--> http://localhost:8080/addDept

@RestController

public class DepartmentController 
{

    @Autowired
    private DepartmentService service;

    @PostMapping("/addDept")
    public Department addDepartment(@RequestBody Department dept) 
    {
        
    	return service.addDepartment(dept);
    }

    
}
