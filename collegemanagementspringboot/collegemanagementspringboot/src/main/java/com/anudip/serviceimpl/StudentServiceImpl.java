package com.anudip.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.entity.Student;
import com.anudip.entity.Teacher;
import com.anudip.exception.StudentIDIdNotFoundException;
import com.anudip.exception.TeacherIdNotFoundException;
import com.anudip.repository.StudentRepository;
import com.anudip.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepo;

	@Override
	public Student addStudent(Student studentss) {
		// TODO Auto-generated method stub
		return studentRepo.save(studentss);
	}

	@Override
	public Student getStudentDetail(int sid) {
		// TODO Auto-generated method stub
		return studentRepo.findById(sid).
				orElseThrow(()-> new StudentIDIdNotFoundException("Student id is not corrected"));
	}

	@Override
	public Student updateStudentDetail(Student Student, int sid) {
		Student UpdateStudent = studentRepo.findById(sid).
				orElseThrow(()-> new StudentIDIdNotFoundException("Student id is not corrected"));
				// set new values
		UpdateStudent.setSphone(Student.getSphone());
		UpdateStudent.setSaddr(Student.getSaddr());
		studentRepo.save(UpdateStudent);
		return UpdateStudent;
	}

	@Override
	public void deleteStudentDetail(int sid) {
		Student delStudent=studentRepo.findById(sid).
				orElseThrow(()-> new StudentIDIdNotFoundException("Student id is not corrected"));
		studentRepo.delete(delStudent);
		
	}

	
	}
	


