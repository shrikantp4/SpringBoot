package com.capgemini.employee.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.employee.model.Employee;

public interface EmployeeRepositry extends JpaRepository<Employee, String>{

	List<Employee> findBySalaryBetween(double min, double max);

}
