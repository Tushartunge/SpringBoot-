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

import com.anudip.entity.Courses;

import com.anudip.service.CoursesService;

import jakarta.validation.Valid;

@RestController
public class CoursesController 
{
	@Autowired
	CoursesService couservice;
	
	@PostMapping("/Courses/addCourse")
	public ResponseEntity<Courses> saveCourses(@Valid @RequestBody Courses courses)
	{
		return new ResponseEntity<Courses>(couservice.addCourses(courses),HttpStatus.CREATED);
		
	}
	//@PathVariable : bind to URI template variable
	//http://localhost:8080/Teacher/get(1)
	@GetMapping("/Courses/get/{cid}")
	public ResponseEntity<Courses> getCourses(@PathVariable ("cid") int cid)
	{
		return new ResponseEntity<Courses>(couservice.getCoursesDetail(cid),HttpStatus.OK);
	}
	
	// delete
	@DeleteMapping("/Courses/remove/{cid}")
	public ResponseEntity<String> deleteCourses(@PathVariable ("cid") int cid)
	{
		couservice.deleteCoursesDetail(cid);
		return new ResponseEntity<String>("Deleted Sucessfully", HttpStatus.OK);
	}
	
	//update
	//@RequestBody : Student object call to JSON file
	@PutMapping("/Courses/update/{cid}")
	public ResponseEntity<String> updateCourses(@RequestBody Courses courses,@PathVariable("cid") int cid) {
	couservice.updateCoursesDetail(courses,cid); // Delegate to service layer
	return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
	
	}
}
