package com.capgemini.employee.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.employee.model.Employee;
import com.capgemini.employee.repository.EmployeeRepositry;
import com.capgemini.employee.util.EmployeeNotFoundException;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepositry employeeRepo;

	public List<Employee> getAllEmployee() {
		
		return (List<Employee>) employeeRepo.findAll();
	
	}

	public Employee addEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	public Employee getEmployeeById(String empId) throws EmployeeNotFoundException {
	  Optional<Employee> emp = employeeRepo.findById(empId);
	  if(!emp.isPresent())
	
			throw new EmployeeNotFoundException("its null");
	
	  return emp.get();
	}

	public Employee updateEmployee(String empId, Employee employee) throws EmployeeNotFoundException {
		Optional<Employee> empOptional = employeeRepo.findById(empId);

		if (!empOptional.isPresent())
			throw new EmployeeNotFoundException("not found");

		employee.setEmpId(empId);
		
		return employeeRepo.save(employee);

	}

	public void deleteEmployee(String empId) {

		System.out.print("1111"+empId);
		employeeRepo.deleteById(empId);
	}

	public List<Employee> getEmployeeBySalary(double min,double max) {
		
		return employeeRepo.findBySalaryBetween(min,max);
	}

}
