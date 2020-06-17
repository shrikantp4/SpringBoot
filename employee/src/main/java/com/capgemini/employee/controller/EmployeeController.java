package com.capgemini.employee.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.capgemini.employee.model.Employee;
import com.capgemini.employee.service.EmployeeService;
import com.capgemini.employee.util.EmployeeNotFoundException;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<com.capgemini.employee.model.Employee> getAllEmployee()
	{
		List<com.capgemini.employee.model.Employee> empList = new ArrayList<>();
		empList = employeeService.getAllEmployee();
		return empList;
	}
	
	@GetMapping("/employee/{empId}")
	public Employee getEmployeeById(@PathVariable String empId)
	{
		Employee emp = null;
		try {
			emp = employeeService.getEmployeeById(empId);
		} catch (EmployeeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}
	
	@GetMapping("/employee")
	public List<com.capgemini.employee.model.Employee> getEmployeeBySalary(@RequestParam("min") double min,@RequestParam("max") double max)
	{
		List<com.capgemini.employee.model.Employee> empList = new ArrayList<>();
		empList = employeeService.getEmployeeBySalary(min,max);
		return empList;
	}
	
	
	@PostMapping("/employee")
	public ResponseEntity<Object> addEmployee(@RequestBody Employee employee)
	{
		Employee saveEmp = employeeService.addEmployee(employee);
		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(saveEmp.getEmpId()).toUri();;
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/employee/{empId}")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee,@PathVariable String empId)
	{
		try {
			employeeService.updateEmployee(empId, employee);
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().build();
	
	}
	
	@DeleteMapping("/employee/{empId}")
	public void deleteEmployee(@PathVariable String empId)
	{
		System.out.print(empId);
		employeeService.deleteEmployee(empId);
	
	}

}
