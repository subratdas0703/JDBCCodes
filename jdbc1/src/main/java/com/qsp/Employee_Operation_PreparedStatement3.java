package com.qsp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.qsp.connection.DbConnect;

public class Employee_Operation_PreparedStatement3 {

	static Scanner sc=new Scanner(System.in);
	static Connection conn=DbConnect.getConnection();
	
	public static void main(String[] args) {
		
		 for(;;) {
			System.out.println("*** Welcome to Employee Database ***");
			System.out.println();
			System.out.println("1. Show all the details of Employee table.");
			System.out.println("2. Insert record into Employee table.");
			System.out.println("3. Update record of Employee table.");
			System.out.println("4. Delete record from Employee table.");
			System.out.println("5. Exit");
			System.out.println();
			System.out.print("Choose an operation you want to perform: ");
			int op=sc.nextInt();
			
			switch(op)
			{
				case 1:
				{
					fetchAllDetails(conn);
					break;
				}
				case 2:
				{
					insertData(conn);
					break;
				}
				case 3:
				{
					
					break;
				}
				case 4:
				{
					break;
				}
				case 5: {
					System.exit(0);
					break ;
				}
				default: {
					System.out.println("Wrong option.");
				}
			}//switch
			
		}//for
		
		
	}//main
	
	public static void fetchAllDetails(Connection conn)
	{
	    String sql="SELECT * FROM EMPLOYEE";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getDouble(4)+" "+rs.getInt(5));
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}//show
	
	public static void insertData(Connection conn)
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
		
		String sql="INSERT INTO EMPLOYEE VALUES(?,?,?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, empno);
			ps.setString(2, ename);
			ps.setString(3, job);
			ps.setDouble(4, sal);
			ps.setInt(5, deptno);
			
			int res=ps.executeUpdate();
			if(res!=0)
			{
				System.out.println(res+" record inserted successfully!");
			}
			else {
				System.out.println("Some DB problem");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
