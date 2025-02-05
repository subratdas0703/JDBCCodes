package com.qsp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Student_Insert_StoredProcedure {

	public static void main(String[] args) {
		
		String url="jdbc:postgresql://localhost:5433/qsp";
		String user="postgres";
		String password= "root";
		Scanner sc=new Scanner(System.in);
		
		try {
			//1st step
			Class.forName("org.postgresql.Driver");
			//2nd step
			Connection con=DriverManager.getConnection(url,user,password);
			//3rd step
			CallableStatement cs=con.prepareCall("call create_student(112,'Gavaskar',768654321)");
			//4th step
			System.out.println(cs.execute());
			System.out.println("inserted");
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
