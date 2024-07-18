package com.anudip.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.anudip.dto.TeacherDTO;
import com.anudip.entity.Teacher;
// this class will be responsible to convert DTO to entity and vice versa

//instead of teacher entity we are using teacher DTO 
@Component
public class TeacherConverter {
	
	public Teacher ConvertTeacherDTOToTeacher(TeacherDTO tdto) {
		
		Teacher te=new Teacher();
		if(tdto!=null) {
			
			BeanUtils.copyProperties(tdto, te);
		}
		
		return te;
	}
	
	public TeacherDTO ConvertTeacherToTeacherDTO(Teacher teacher) {
		
		TeacherDTO tdto=new TeacherDTO();
		if(teacher!=null) {
			
			BeanUtils.copyProperties(teacher, tdto);
		}
		
		return tdto;
		
	}
	

}
