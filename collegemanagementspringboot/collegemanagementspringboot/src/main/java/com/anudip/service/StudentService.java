package com.anudip.service;



import com.anudip.entity.Student;
import com.anudip.entity.Teacher;


public interface StudentService {
	
	// save teacher details in db table
		Student addStudent(Student studentss);
		
		// method to fetch teacher detail based on tid from db table
		Student getStudentDetail(int sid);
		
		//method to modify teacher detail based on tid from db table
		Student updateStudentDetail(Student student, int sid);
		
		//method to remove teacher detail based on tid from db table
		void deleteStudentDetail(int sid);

}
