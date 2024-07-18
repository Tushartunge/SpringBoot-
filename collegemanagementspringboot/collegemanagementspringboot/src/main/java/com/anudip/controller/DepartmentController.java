package com.anudip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anudip.entity.Department;
import com.anudip.entity.Student;
import com.anudip.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentService dservice;

    @PostMapping("/Department/addDepartment")
    public ResponseEntity<Department> saveDepartment(@Valid @RequestBody Department department) {
        return new ResponseEntity<>(dservice.addDepartment(department), HttpStatus.CREATED);
    }
    
  //@PathVariable : bind to URI template variable
  	//http://localhost:8080/Teacher/get(1)
  	@GetMapping("/Department/get/{did}")
  	public ResponseEntity<Department> getDepartment(@PathVariable ("did") int did)
  	{
  		return new ResponseEntity<Department>(dservice.getDepartmentDetail(did),HttpStatus.OK);
  	}
  	
 // delete
 	@DeleteMapping("/Department/remove/{did}")
 	public ResponseEntity<String> deleteStudent(@PathVariable ("did") int did)
 	{
 		dservice.deleteDepartmentDetail(did);
 		return new ResponseEntity<String>("Deleted Sucessfully", HttpStatus.OK);
 	}
 	
 	//update
 		//@RequestBody : Student object call to JSON file
 		@PutMapping("/Department/update/{did}")
 		public ResponseEntity<String> updatedepartment(@RequestBody Department department,@PathVariable("did") int did) {
 		dservice.updateDepartmentDetail(department,did); // Delegate to service layer
 		return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
 		
 		}
}
