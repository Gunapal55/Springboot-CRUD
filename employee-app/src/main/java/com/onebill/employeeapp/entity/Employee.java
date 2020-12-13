package com.onebill.employeeapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="emp")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
	private Integer employeeId;
	
	@Column(name="emp_name")
	private String employeeName;
	
	@Column(name="emp_email")
	private String employeeEmail;
	
	@Column(name="emp_dept")
	private String employeeDepartment;
	
	@Column(name="emp_sal")
	private String employeeSalary;
	
	@Column(name="emp_mgr")
	private String employeeManager;
	
	
}
