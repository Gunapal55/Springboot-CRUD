package com.onebill.employeeapp.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onebill.employeeapp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	public Employee findByEmployeeName(String empName);
	
	@Transactional
	@Modifying
	@Query(value="delete  from Employee e  where e.employeeName=:empName")
	public Integer deleteByEmployeeName(@Param("empName") String empName);

}
