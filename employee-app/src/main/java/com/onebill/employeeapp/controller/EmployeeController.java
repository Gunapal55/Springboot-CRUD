package com.onebill.employeeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onebill.employeeapp.dao.EmployeeRepository;
import com.onebill.employeeapp.entity.Employee;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository repo;
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		repo.save(employee);
		return employee;	
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return repo.findAll();
	}
	
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		repo.save(employee);
		return employee;
	}
	
	@GetMapping("/employee")
	public Employee findEmpByName(String empName) {
		return repo.findByEmployeeName(empName);
				
	}
	
	
	@DeleteMapping("/employees")
	public String deleteEmployee(Employee employee) {
		 	repo.deleteAll();
		 	return "All records are deleted successfully......";
	}
	
	@DeleteMapping("/employee-name")
	public Integer deleteEmployeeByName(String empName) {
		 	repo.deleteByEmployeeName(empName);
		 	return 0;
	}
	
	
}
