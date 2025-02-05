package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Student_Insert_PreparedStatement2 {

	public static void main(String[] args) {
		
		String url="jdbc:postgresql://localhost:5433/qsp";
		String user="postgres";
		String password= "root";
		Scanner sc=new Scanner(System.in);
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection(url,user,password);
			PreparedStatement ps=con.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?)");
			ps.setInt(1,105);
			ps.setString(2, "Swapnali");
			ps.setLong(3, 9876543210l);
			
			int res=ps.executeUpdate();
			if(res!=0)
			{
				System.out.println(res+" Record inserted succesfully!");
			}
			else {
				System.out.println("Some Db problem");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
