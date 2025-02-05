package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Student_Update_PreparedStatement {

	public static void main(String[] args) {
		
		String url="jdbc:postgresql://localhost:5433/qsp";
		String user="postgres";
		String password= "root";
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection(url,user,password);
			PreparedStatement ps=con.prepareStatement("UPDATE STUDENT SET PHONE=? WHERE ID=?");
			ps.setInt(2,105);
			ps.setLong(1,8756325438l);
			
			int res=ps.executeUpdate();
			if(res!=0)
			{
				System.out.println(res+" Record updated succesfully!");
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
