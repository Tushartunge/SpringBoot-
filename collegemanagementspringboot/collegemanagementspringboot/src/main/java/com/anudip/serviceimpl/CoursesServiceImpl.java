package com.anudip.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.entity.Courses;
import com.anudip.entity.Student;
import com.anudip.exception.CoursesIdNotFoundException;
//import com.anudip.exception.StudentIdNotFoundException;
import com.anudip.exception.TeacherIdNotFoundException;
import com.anudip.repository.CoursesRepository;
import com.anudip.service.CoursesService;


@Service
public class CoursesServiceImpl implements CoursesService
{

	@Autowired
	CoursesRepository coRepo;
	
	@Override
	public Courses addCourses(Courses courses) {
		return coRepo.save(courses);
	}

	@Override
	public Courses getCoursesDetail(int cid) {
		return coRepo.findById(cid).
				orElseThrow(()-> new CoursesIdNotFoundException("Course id is not corrected"));
	}

	@Override
	public Courses updateCoursesDetail(Courses courses, int cid) {

		Courses UpdateCourses = coRepo.findById(cid).
				orElseThrow(()-> new CoursesIdNotFoundException("Student id is not corrected"));
				// set new value
		//Student.setSphone(student.getSphone());
		UpdateCourses.setCourseName(courses.getCourseName());
		UpdateCourses.setDuration(courses.getDuration());
		coRepo.save(UpdateCourses);
		return UpdateCourses;
	}

	@Override
	public void deleteCoursesDetail(int cid) {
		Courses delCourses =coRepo.findById(cid).
				orElseThrow(()-> new CoursesIdNotFoundException("Student id is not corrected"));
		coRepo.delete(delCourses);
	}

}
