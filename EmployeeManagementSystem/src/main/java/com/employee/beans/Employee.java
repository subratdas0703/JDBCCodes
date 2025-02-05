package com.employee.beans;

public class Employee {

	private int empNo;
	private String eName;
	private String job;
	private double sal;
	private int deptNo;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(int empNo, String eName, String job, double sal, int deptNo) {
		super();
		this.empNo = empNo;
		this.eName = eName;
		this.job = job;
		this.sal = sal;
		this.deptNo = deptNo;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	@Override
	public String toString() {
		return empNo + ", " + eName + ", " + job + ", " + sal + ", " + deptNo;
	}
	
	
	
	
}
