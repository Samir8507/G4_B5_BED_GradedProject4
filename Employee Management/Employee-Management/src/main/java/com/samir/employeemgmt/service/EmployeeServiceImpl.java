package com.samir.employeemgmt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.samir.employeemgmt.model.Employee;
import com.samir.employeemgmt.repository.EmployeeJPARepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeJPARepository employeeRepository;
	@Override
	public String addSingleEmployee(Employee employee) {
		this.employeeRepository.save(employee);
		return "saved Employee";
	}

	@Override
	public String addAllEmployee(List<Employee> employee) {
		this.employeeRepository.saveAll(employee);
		return "Saved All Employee";
	}

	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		return this.employeeRepository.saveAndFlush(employee);
	}

	@Override
	public List<Employee> fetchAllEmployee(Employee employee) {
		List<Employee> listofEmployee = this.employeeRepository.findAll();
		return listofEmployee;
	}
	
	public Direction EmployeeServiceImpl(String strDirection) {
		Sort.Direction direction = strDirection.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
		
		return direction;
	}

	@Override
	public Employee getEmployeeById(int EmployeeId) {
		Optional <Employee> optionalEmployee = this.employeeRepository.findById(EmployeeId);
		return optionalEmployee.orElseThrow();
	}

	@Override
	public void deleteEmployeeById(int id) {
	this.employeeRepository.deleteById(id);

	}

	@Override
	public Employee updateEmployee(int id, Employee updatedEmployee) {
		Employee existingEmployee = this.employeeRepository.findById(id).orElseThrow();
		existingEmployee.setId(id);
		existingEmployee.setFirstName(updatedEmployee.getFirstName());
		existingEmployee.setLastName(updatedEmployee.getLastName());
		existingEmployee.setEmail(updatedEmployee.getEmail());
		return this.employeeRepository.save(existingEmployee);
	}

}
