package com.Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentRecord {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// Register driver class
		Class.forName("com.mysql.jdbc.Driver");
		
		// build connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StuDemo", "root", "root");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id");
		int id = sc.nextInt();
		
		System.out.println("ENter name");
		String name = sc.next();
		
		// using preparedstatement
		PreparedStatement ps = con.prepareStatement("insert into student values(? , ?)");
	
		ps.setInt(1, id);
		ps.setString(2, name);
		
		int x = ps.executeUpdate();
		System.out.println(x);
		System.out.println("Data is Inserted successfully....");
		con.close();
	}
}