package com.tcs.employeerestapi.service;

import java.util.List;
import java.util.Optional;

import com.tcs.employeerestapi.model.Employee;

public interface EmployeeService {
	public Employee addEmployee(Employee employee);
	public String updateEmployee(Employee employee);
	public void deleteEmployee(int id);
	public Optional<Employee> findById(int id);
	public Optional<java.util.List<Employee>> getEmployees();
	public Optional<java.util.List<Employee>> findByOrganizationId(int id);
	
	public void registerEmployee(Employee employee);
}
