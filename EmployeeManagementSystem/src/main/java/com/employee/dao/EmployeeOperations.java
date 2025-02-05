package com.employee.dao;

import java.util.List;

import com.employee.beans.Employee;

public interface EmployeeOperations {

	List<Employee> fetchAllEmployeeDetails();
	
	Employee getEmployeeById(int empno);
	
	boolean insertRecord(Employee e);
	
	boolean updateEmployeeNameById(int empNo, String name);
	
	boolean updateEmployeeSalById(int empNo, double sal);
	
	boolean removeEmployeeById(int empNo);
	
	
	
}
