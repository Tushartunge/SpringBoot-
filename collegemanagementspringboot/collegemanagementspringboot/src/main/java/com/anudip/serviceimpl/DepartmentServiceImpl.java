package com.anudip.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.entity.Department;
import com.anudip.exception.DepartmentIdNotFoundException;
import com.anudip.repository.DepartmentRepository;
import com.anudip.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService
{
	@Autowired
	DepartmentRepository deptRepo;
	
	@Override
	public Department addDepartment(Department department) {
		return deptRepo.save(department);
	}
	@Override
	public Department getDepartmentDetail(int did) 
	{
	
		return deptRepo.findById(did).
				orElseThrow(()-> new DepartmentIdNotFoundException("Department id is not corrected.."));
	}
	
				

	@Override
	public Department updateDepartmentDetail(Department department, int did) {
		return null;
//		Department UpdateDepartment = deptRepo.findById(did).
//				orElseThrow(()-> new DepartmentIdNotFoundException("Teacher id is not corrected"));
//				// set new value
//		//Student.setSphone(student.getSphone());
//		UpdateDepartment.setDeptHOD(deptRepo.getSphone());
//		UpdateDepartment.setNoofEmp(deptRepo.getSaddr());
//		deptRepo.save(UpdateDepartment);
//		return UpdateDepartment;
	}

	@Override
	public void deleteDepartmentDetail(int did) {
		Department delDepartment =deptRepo.findById(did).
				orElseThrow(()-> new DepartmentIdNotFoundException("Teacher id is not corrected"));
		deptRepo.delete(delDepartment);
		
	}

}
