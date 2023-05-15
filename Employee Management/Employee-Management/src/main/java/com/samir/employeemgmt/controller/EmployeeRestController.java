package com.samir.employeemgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samir.employeemgmt.model.Employee;
import com.samir.employeemgmt.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> fetchAllEmployee(){
		return this.employeeService.fetchAllEmployee(null);
	}
	
	@GetMapping("/{id}")
	public Employee fetchEmployeeById(@PathVariable("id") int employeeid) {
		return this.employeeService.getEmployeeById(employeeid);
	}
	
	@PostMapping
	public void saveEmployeeById(@RequestBody Employee Employee) {
		this.employeeService.addSingleEmployee(Employee);
	}
	
	@PutMapping("/{id}")
	public void updateEmployeeById(@PathVariable("id") int employeeid, Employee updatedEmployee) {
		this.employeeService.updateEmployee(employeeid, updatedEmployee);
	}

	
	@DeleteMapping("/{id}")
	public void deleteEmployeeById(@PathVariable("id") int employeeid) {
		this.employeeService.deleteEmployeeById(employeeid);
	}
	
	
}

