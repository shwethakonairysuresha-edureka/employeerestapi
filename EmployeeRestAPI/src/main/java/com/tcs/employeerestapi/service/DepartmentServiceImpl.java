package com.tcs.employeerestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.employeerestapi.model.Department;
import com.tcs.employeerestapi.repository.DepartmentRepository;
import com.tcs.employeerestapi.repository.OrganizationRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
//	private DepartmentServiceImpl()
//	{
//	}
//	
//	private static DepartmentService dao;
//	
//	public static DepartmentService getInstance()
//	{
//		if(dao == null)
//		{
//			dao = new DepartmentServiceImpl();
//			return dao;
//		}
//		return dao;
//	}
	
//	@Autowired
//	private DepartmentDAO departmentDao;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	OrganizationRepository organizationRepository;

	@Override
	public Department addDepartment(Department department) {
		// TODO Auto-generated method stub
		Department department2 = null;
		try
		{
			department2 = departmentRepository.save(department);
			return department2;
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String updateDepartment(Department department) {
		// TODO Auto-generated method stub
		Department department2 = null;
		try
		{
			department2 = departmentRepository.save(department);
			return "success";
		}catch(Exception e)
		{
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public void deleteDepartment(int id) {
		// TODO Auto-generated method stub
		departmentRepository.deleteById(id);
	}

	@Override
	public Optional<Department> findById(int id) {
		// TODO Auto-generated method stub
		return departmentRepository.findById(id);
	}

	@Override
	public Optional<List<Department>> getDepartments() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(departmentRepository.findAll());
	}

	@Override
	public Optional<List<Department>> findByOrganizationId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerDepartment(Department department) {
		// TODO Auto-generated method stub
		//if(departmentRepository.existsByName(department.getName())) {
		//	return "existing department";
		    Department department2 = departmentRepository.save(department);
		}
		
		//Department department2 = departmentRepository.save(department);
		//return department2!=null?"success":"fail";
	}
