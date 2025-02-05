package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Remove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:postgresql://localhost:5433/qsp";
		String user="postgres";
		String pass="root";
		try {
			//step-1
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver class is loaded.");
			//step-2
     		Connection conn=DriverManager.getConnection(url,user,pass);
//			Connection conn=DriverManager.getConnection(url);
			System.out.println(conn);
			System.out.println("Connection created");
			//step-3
			Statement stmt=conn.createStatement();
			//step4
			boolean res=stmt.execute("delete from employee where empno=7654");
			//"insert into Employee values(7369,'SMITH','CLERK',3000,20),(7499,'ALLEN','SALESMAN',2000,30),(7521,'WARD','SALESMAN',1250,30),(7566,'JONES','MANAGER',2975,20),(7654,'MARTIN','SALESMAN',1250,10)"
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
