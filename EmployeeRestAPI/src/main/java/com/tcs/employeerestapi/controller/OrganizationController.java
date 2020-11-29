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

import com.tcs.employeerestapi.model.Organization;
import com.tcs.employeerestapi.service.OrganizationService;

@RestController
@RequestMapping("/api/v1/organization")
public class OrganizationController {
	
	@Autowired
	OrganizationService organizationService;

	@GetMapping
	public List<Organization> getOrganization()
	{
		return organizationService.getOrganization().get();
	}
	
	@GetMapping("/{id}")
	public Organization getOrganizationById(@PathVariable("id") int id) {
		return organizationService.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public String deleteOrganizationById(@PathVariable int id) {
		organizationService.deleteOrganization(id);
		return "success";
	}
	
	@PostMapping("/create")
	public Organization createOrganization(@RequestBody Organization organization)
	{
		return 	organizationService.addOrganization(organization);
	}
}