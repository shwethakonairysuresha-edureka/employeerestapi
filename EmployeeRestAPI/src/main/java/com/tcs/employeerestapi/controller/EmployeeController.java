package com.tcs.employeerestapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.tcs.employeerestapi.exception.ResourceNotFoundException;
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
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) throws ResourceNotFoundException
	{
		Employee employee = employeeService.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not found"));
		return ResponseEntity.ok().body(employee);
	}
	
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteEmployeeById(@PathVariable int id) throws ResourceNotFoundException
	{
		Employee employee = employeeService.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not found"));
		employeeService.deleteEmployee(id);
		HashMap<String, Boolean> hashMap = new HashMap<>();
		hashMap.put("deleted", Boolean.TRUE);
		return hashMap;
	}
	
	@PostMapping
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee,UriComponentsBuilder uriComponentsBuilder,HttpServletRequest request)
	{
		Employee employee2 = employeeService.addEmployee(employee);
		UriComponents uriComponents = uriComponentsBuilder
				.path(request.getRequestURI()+"/{id}")
				.buildAndExpand(employee2.getId());
		return ResponseEntity.created(uriComponents.toUri()).body(employee2);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Integer id,
			@Valid @RequestBody Employee employee ) throws ResourceNotFoundException {
		Employee employee2 = employeeService.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Product not found"));
		employee.setId(id);
		Employee employee3 =employeeService.addEmployee(employee);		
		return ResponseEntity.ok(employee3);
	}
}
