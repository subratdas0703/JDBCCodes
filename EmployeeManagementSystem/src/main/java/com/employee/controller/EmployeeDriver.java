package com.employee.controller;

import java.util.List;
import java.util.Scanner;

import com.employee.beans.Employee;
import com.employee.dao.EmployeeOperationImpl;
import com.employee.dao.EmployeeOperations;

public class EmployeeDriver {

	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		
		EmployeeOperations emp = new EmployeeOperationImpl();
		System.out.println("***** EMPLOYEE DATABASE *****");
		System.out.println();
		for( ; ; )
		{
			System.out.println();
			System.out.println("### EMPLOYEE OPERATIONS ###");
			System.out.println();
			System.out.println("1. Display all Employee details.");
			System.out.println("2. Display Employee details by Employee number.");
			System.out.println("3. Insert record into Employee table.");
			System.out.println("4. Update employee name by employee number.");
			System.out.println("5. Update salary of employee by id.");
			System.out.println("6. Remove Employee by employee number.");
			System.out.println("7. EXIT");
			System.out.println();
			System.out.print("Choose an operation you want to perform : ");
			int op=sc.nextInt();
			System.out.println();
			
			switch(op)
			{
				case 1:
				{
					List<Employee> empList=emp.fetchAllEmployeeDetails();
					if(empList!=null)
					{
						for(Employee e : empList)
						{
							System.out.println(e);
						}
					}
					else {
						System.out.println("No record found!!!");
					}
					break;
				}
				case 2:
				{
					System.out.print("Enter employee number : ");
					System.out.println();
					int empNo=sc.nextInt();
					Employee e=emp.getEmployeeById(empNo);
					if(e!=null)
					{
						System.out.println(e);
					}
					else {
						System.out.println("No record found!!!");
					}
					break;
				}
				case 3:
				{
					System.out.print("Enter empno : ");
					int empno=sc.nextInt();
					System.out.println("Enter employee name : ");
					String ename=sc.next();
					System.out.println("Enter job : ");
					String job=sc.next();
					System.out.println("Enter salary : ");
					double sal=sc.nextDouble();
					System.out.println("Enter department number : ");
					int deptno=sc.nextInt();
					
					Employee e=new Employee();
					e.setEmpNo(empno);
					e.seteName(ename);
					e.setJob(job);
					e.setSal(sal);
					e.setDeptNo(deptno);
					boolean f=emp.insertRecord(e);
					if(f) {
						System.out.println("Record inserted successfully!");
					}
					else {
						System.out.println("Something went wrong.");
					}
					break;
				}
				case 4:
				{
					System.out.print("Enter employee number : ");
					int empNo=sc.nextInt();
					System.out.println();
					System.out.print("Enter employee new name : ");
					String eName=sc.next();
					boolean f=emp.updateEmployeeNameById(empNo, eName);
					if(f) {
						System.out.println("Record updated successfully!");
					}
					else {
						System.out.println("Something went wrong.");
					}
					break;
				}
				case 5:
				{
					System.out.print("Enter employee number : ");
					int empNo=sc.nextInt();
					System.out.println();
					System.out.print("Enter employee new salary : ");
					Double sal=sc.nextDouble();
					boolean f=emp.updateEmployeeSalById(empNo, sal);
					if(f) {
						System.out.println("Record updated successfully!");
					}
					else {
						System.out.println("Something went wrong.");
					}
					break;
				}
				case 6:
				{
					System.out.print("Enter employee number : ");
					int empNo=sc.nextInt();
					boolean f=emp.removeEmployeeById(empNo);
					if(f) {
						System.out.println("Record removed successfully!");
					}
					else {
						System.out.println("Something went wrong.");
					}
					break;
				}
				case 7:
				{
					System.exit(0);
					break;
				}
				default :
				{
					System.out.println("Wrong option choosen!");
					break;
				}
			}
		}//infinite for
	}//main

}
