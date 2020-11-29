package com.tcs.employeerestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.employeerestapi.model.Department;
import com.tcs.employeerestapi.service.DepartmentService;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;

	@GetMapping
	public List<Department> getDepartments()
	{
		return departmentService.getDepartments().get();
	}
	
	@GetMapping("/{id}")
	public Department getDepartmentById(@PathVariable("id") int id) {
		return departmentService.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public String deleteDepartmentById(@PathVariable int id) {
		departmentService.deleteDepartment(id);
		return "success";
	}
	
	@PostMapping("/create")
	public Department createDepartment(@RequestBody Department department)
	{
		return 	departmentService.addDepartment(department);
	}
}