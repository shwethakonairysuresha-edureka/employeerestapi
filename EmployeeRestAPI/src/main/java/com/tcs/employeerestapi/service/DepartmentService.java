package com.tcs.employeerestapi.service;

import java.util.List;
import java.util.Optional;

import com.tcs.employeerestapi.model.Department;

public interface DepartmentService {
	public Department addDepartment(Department department);
	public String updateDepartment(Department department);
	public void deleteDepartment(int id);
	public Optional<Department> findById(int id);
	public Optional<List<Department>> getDepartments();
	public Optional<List<Department>> findByOrganizationId(int id);
	
	public void registerDepartment(Department department);
}