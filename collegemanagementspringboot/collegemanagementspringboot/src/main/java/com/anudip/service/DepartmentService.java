package com.anudip.service;

import com.anudip.entity.Department;
import com.anudip.entity.Student;

public interface DepartmentService
{

	// save Student details in db table
		Department addDepartment(Department department);
		
		// method to fetch Student detail based on sid from db table
		Department getDepartmentDetail(int did);
		
		//method to modify Student detail based on sid from db table
		Department updateDepartmentDetail(Department department, int did);
		
		//method to remove Student detail based on sid from db table
		void deleteDepartmentDetail(int did);
}
