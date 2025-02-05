package com.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConnect;
import com.employee.beans.Employee;

public class EmployeeOperationImpl implements EmployeeOperations {

	Connection conn=DBConnect.getConnection();
	@Override
	public List<Employee> fetchAllEmployeeDetails() {
		
		List<Employee> empList=new ArrayList<Employee>();
		Employee emp=null;
		try {
			String sql="SELECT * FROM EMPLOYEE";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				emp=new Employee();
				emp.setEmpNo(rs.getInt(1));
				emp.seteName(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setSal(rs.getDouble(4));
				emp.setDeptNo(rs.getInt(5));
				
				empList.add(emp);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return empList;

	}

	@Override
	public Employee getEmployeeById(int empno) {
		Employee emp=null;
		try {
			String sql="SELECT * FROM EMPLOYEE WHERE EMPNO=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, empno);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				emp=new Employee();
				emp=new Employee();
				emp.setEmpNo(rs.getInt(1));
				emp.seteName(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setSal(rs.getDouble(4));
				emp.setDeptNo(rs.getInt(5));
			
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return emp;
	}

	@Override
	public boolean insertRecord(Employee e) {
		boolean f=false;
		try {
			String sql="INSERT INTO EMPLOYEE VALUES(?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,e.getEmpNo());
			ps.setString(2, e.geteName());
			ps.setString(3, e.getJob());
			ps.setDouble(4, e.getSal());
			ps.setInt(5, e.getDeptNo());
			
			int i=ps.executeUpdate();
			if(i!=0) {
				f=true;
			}else {
				f=false;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return f;
	}

	@Override
	public boolean updateEmployeeNameById(int empNo, String name) {
		boolean f=false;
		try {
			String sql="UPDATE EMPLOYEE SET ENAME=? WHERE EMPNO=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2,empNo);
			int i=ps.executeUpdate();
			if(i!=0)
			{
				f=true;
			}
			else {
				f=false;
			}
			} catch (SQLException se) {
			se.printStackTrace();
		}
		return f;
	}

	@Override
	public boolean updateEmployeeSalById(int empNo, double sal) {
		boolean f=false;
		try {
			String sql="UPDATE EMPLOYEE SET SAL=? WHERE EMPNO=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setDouble(1, sal);
			ps.setInt(2,empNo);
			int i=ps.executeUpdate();
			if(i!=0)
			{
				f=true;
			}
			else {
				f=false;
			}
			} catch (SQLException se) {
			se.printStackTrace();
		}
		return f;
	}

	@Override
	public boolean removeEmployeeById(int empNo) {
		boolean f=false;
		try {
			String sql="DELETE FROM EMPLOYEE WHERE EMPNO=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, empNo);
			int i=ps.executeUpdate();
			if(i!=0)
			{
				f=true;
			}
			else {
				f=false;
			}
			} catch (SQLException se) {
			se.printStackTrace();
		}
		return f;	}

}
