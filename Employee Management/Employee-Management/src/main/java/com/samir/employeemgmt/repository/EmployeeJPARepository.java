package com.samir.employeemgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samir.employeemgmt.model.Employee;

public interface EmployeeJPARepository extends JpaRepository<Employee, Integer> {

	



}
