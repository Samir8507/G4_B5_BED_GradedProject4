package com.samir.employeemgmt.service;

import java.util.List;

import com.samir.employeemgmt.model.Employee;

public interface EmployeeService {
	String addSingleEmployee(Employee employee);

	String addAllEmployee(List<Employee> employee);

	Employee save(Employee employee);

	List<Employee> fetchAllEmployee(Employee employee);

	Employee getEmployeeById(int EmployeeId);

	void deleteEmployeeById(int id);

	Employee updateEmployee(int id, Employee updatedEmployee);
}
