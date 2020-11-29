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

import com.tcs.employeerestapi.model.Employee;
import com.tcs.employeerestapi.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	@GetMapping
	public List<Employee> getEmployees()
	{
		return employeeService.getEmployees().get();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("id") int id) {
		return employeeService.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployeeById(@PathVariable int id) {
		employeeService.deleteEmployee(id);
		return "success";
	}
	
	@PostMapping("/create")
	public Employee createEmployee(@RequestBody Employee employee)
	{
		return 	employeeService.addEmployee(employee);
	}
}
