package com.cg.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.cg.util.DBUtil;

public class Insert {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
//		String className = "oracle.jdbc.driver.OracleDriver";
//		String user="hr";
//		String pass="hr";
//		String url="jdbc:oracle:thin:@localhost:1521:xe";
		
		String qry = "insert into employee_tbl values(employee_seq.nextval,?,?)";
//		Class.forName(className);
		
		Connection con = DBUtil.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(qry);
		
		
		System.out.println("Enter Emp Name :");
		String name = sc.next();
		pstmt.setString(1,name);
		System.out.println("Enter Emp Salary :");
		double sal = sc.nextDouble();
		pstmt.setDouble(2, sal);
		
		int n = pstmt.executeUpdate();
		System.out.println(n+" row inserted");
		
		con.close();
		
	}

}
