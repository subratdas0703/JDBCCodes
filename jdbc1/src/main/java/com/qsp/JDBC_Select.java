package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Select {

	public static void main(String[] args) {
		
		String url="jdbc:postgresql://localhost:5433/qsp";
		String user="postgres";
		String pass="root";
		try {
			//step-1
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver class is loaded.");
			//step-2
     		Connection conn=DriverManager.getConnection(url,user,pass);
			System.out.println(conn);
			System.out.println("Connection created");
			//step-3
			Statement stmt=conn.createStatement();
			//step4
			boolean res=stmt.execute("select * from employee");
			System.out.println(res);
			//step-5
			conn.close();
		} catch (ClassNotFoundException c) {
			// TODO: handle exception
			c.printStackTrace();
		}catch(SQLException se)
		{
			se.printStackTrace();
		}
	}
}
