package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_ProductOperations {

	static Connection conn;
	static Scanner sc=new Scanner(System.in);
	static {
		try {
			Class.forName("org.postgresql.Driver");
			conn=DriverManager.getConnection("jdbc:postgresql://localhost:5433/qsp","postgres","root");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
		for( ; ; )
		{
			System.out.println();
			System.out.println("*** Operations on product table ***");
			System.out.println();
			System.out.println("1. Insert product.");
			System.out.println("2. Update product price.");
			System.out.println("3. Delete product by Id.");
			System.out.println("4. find product by id");
			System.out.println("5. find all ");
			System.out.println();
			System.out.print("Choose n operation you want to perform : ");
			int op=sc.nextInt();
			
			switch(op)
			{
				case 1:
				{
					System.out.print("Enter product id: ");
					int pid=sc.nextInt();
					System.out.print("Enter product name: ");
					String name=sc.next();
					System.out.println("Enter price: ");
					double price=sc.nextDouble();
					insertProduct(pid,name,price);
					break;
				}
				case 2:
				{
					System.out.print("Enter product id: ");
					int pid=sc.nextInt();
					System.out.print("Enter new price: ");
					double price=sc.nextDouble();
					updateProductPrice(pid,price);
					break;
				}
				case 3:
				{
					System.out.print("Enter product id: ");
					int pid=sc.nextInt();
					removeProductById(pid);
					break;
				}
				case 4:
				{
					System.out.print("Enter product id: ");
					int pid=sc.nextInt();
					findProductById(pid);
					break;
				}
				case 5:
				{
					findAllProduct();
					break;
				}
				default:
				{
					System.out.println("Wrong option choosen.");
					break;
				}
			}
		}//for
		
	}//main
	
	public static void insertProduct(int pid,String name,double price) {
		
		
		try {
			String sql="INSERT INTO PRODUCT VALUES(?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setString(2, name);
			ps.setDouble(3, price);
			
			int i=ps.executeUpdate();
			if(i!=0)
			{
				System.out.println("Record inserted successfully!");
			}
			else
			System.out.println("Some Db problem");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//method1
	
	public static void updateProductPrice(int pid,double price)
	{
		try {
			String sql="UPDATE PRODUCT SET PRICE=? WHERE ID=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(2, pid);
			ps.setDouble(1, price);
			int i=ps.executeUpdate();
			
			if(i!=0)
			{
				System.out.println("Record updated successfully!");
			}
			else
			System.out.println("Some Db problem");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void removeProductById(int pid) {
		try {
			String sql="DELETE FROM PRODUCT WHERE ID=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, pid);
			int i=ps.executeUpdate();
			
			if(i!=0)
			{
				System.out.println("Record deleted successfully!");
			}
			else
			System.out.println("Some Db problem");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void findProductById(int pid)
	{
		try {
			String sql="SELECT * FROM PRODUCT WHERE ID=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, pid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void findAllProduct()
	{
		try {
			String sql="SELECT * FROM PRODUCT";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
