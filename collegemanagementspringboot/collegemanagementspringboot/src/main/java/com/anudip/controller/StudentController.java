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

import com.anudip.entity.Student;
import com.anudip.entity.Teacher;
import com.anudip.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentController {
	
	@Autowired
	StudentService sservice;
	
	@PostMapping("/addstudent")
	public ResponseEntity<Student> saveStudent(@Valid @RequestBody Student student) {
		
		return new  ResponseEntity<Student>(sservice.addStudent(student),HttpStatus.CREATED);
	}
	
	@GetMapping("/Student/get/{sid}")
	public ResponseEntity<Student> getStudent(@PathVariable ("sid") int sid)
	{
		return new ResponseEntity<Student>(sservice.getStudentDetail(sid),HttpStatus.OK);
	}
	
	@DeleteMapping("/Student/remove/{sid}")
	public ResponseEntity<String> deleteStudent(@PathVariable ("sid") int sid)
	{
		sservice.deleteStudentDetail(sid);
		return new ResponseEntity<String>("Deleted Sucessfully", HttpStatus.OK);
	}
	
	@PutMapping("/Student/update/{sid}")
	public ResponseEntity<String> updateStudentDetail(@RequestBody Student student, @PathVariable ("sid") int sid){
		
		 sservice.updateStudentDetail(student, sid);
		 return new ResponseEntity<String>("update Sucessfully", HttpStatus.OK);
	}

}
