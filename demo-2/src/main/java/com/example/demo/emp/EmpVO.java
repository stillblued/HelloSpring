package com.example.demo.emp;

import java.util.Date;

import lombok.Data;

@Data
public class EmpVO {
	String employeeId;
	String firstName;
	String lastName;
	Integer salary;
	Date hireDate;
	String departmentId;
}
