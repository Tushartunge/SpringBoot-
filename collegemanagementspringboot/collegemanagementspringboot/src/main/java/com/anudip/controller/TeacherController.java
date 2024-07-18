package com.anudip.controller;

import java.util.List;

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

import com.anudip.dto.TeacherDTO;
import com.anudip.entity.Teacher;
import com.anudip.service.TeacherService;
import com.anudip.util.TeacherConverter;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
public class TeacherController {
	
	//private static final Teacher Teacher = null;
	//private static final com.anudip.entity.Teacher UpdateTeacher = null;
	@Autowired
	TeacherService tservice;
	
	
	Teacher teacher;
	@Autowired
	TeacherConverter tconvert;
	
//	@PostMapping("/add")
//	public ResponseEntity<Teacher> saveTeacher(@Valid @RequestBody Teacher teacher) {
//		
//		return new  ResponseEntity<Teacher>(tservice.addTeacher(teacher),HttpStatus.CREATED);
//	}
	
	@PostMapping("/add")
	public ResponseEntity<TeacherDTO> saveTeacher(@Valid @RequestBody TeacherDTO tdo) {
		
		Teacher teacher = tconvert.ConvertTeacherDTOToTeacher(tdo);
		return new  ResponseEntity<TeacherDTO>(tservice.addTeacher(teacher),HttpStatus.CREATED);
	}
	
	@GetMapping("/Teacher/get/{tid}")
	public ResponseEntity<Teacher> getTeacher(@PathVariable ("tid") int tid)
	{
		return new ResponseEntity<Teacher>(tservice.getTeacherDetail(tid),HttpStatus.OK);
	}
	
	@DeleteMapping("/Teacher/remove/{tid}")
	public ResponseEntity<String> deleteTeacher(@PathVariable ("tid") int tid)
	{
		tservice.deleteTeacherDetail(tid);
		return new ResponseEntity<String>("Deleted Sucessfully", HttpStatus.OK);
	}
	
	@PutMapping("/Teacher/update/{tid}")
	public ResponseEntity<String> updateTeacherDetail(@RequestBody Teacher teacher, @PathVariable ("tid") int tid){
		
		 tservice.updateTeacherDetail(teacher, tid);
		 return new ResponseEntity<String>("update Sucessfully", HttpStatus.OK);
	}
	
	
	@GetMapping("/Teacher/getTphone/{tphone}")
	public ResponseEntity<Teacher> getTeacherbyPhone(@PathVariable ("tphone") long tphone)
	{
		return new ResponseEntity<Teacher>(tservice.getTeacherByPhone(tphone),HttpStatus.OK);
	}
	
	@GetMapping("/Teacher/getdesignation/{designation}")
	public  List<Teacher> getTeacherdesignation(@PathVariable ("designation") String designation)
	{
		return tservice.getTeacherdesignation(designation);
	}
	
	
}
