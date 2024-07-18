package com.employecrudspring.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employecrudspring.entity.Department;
import com.employecrudspring.repository.DepartmentRepository;
import com.employecrudspring.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department addDepartment(Department dept) {
        return departmentRepository.save(dept);
    }

	@Override
	public Department getDepartment(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteDepartment(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department updateDepartment(int id, Department dept) {
		// TODO Auto-generated method stub
		return null;
	}
}
