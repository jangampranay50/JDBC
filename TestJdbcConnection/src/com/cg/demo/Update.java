package com.cg.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.cg.util.DBUtil;

public class Update {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
//		String className = "oracle.jdbc.driver.OracleDriver";
//		String user="hr";
//		String pass="hr";
//		String url="jdbc:oracle:thin:@localhost:1521:xe";
		
		String qry = "update employee_tbl set empsal = ? where empid = ?";
//		Class.forName(className);
		
		Connection con = DBUtil.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(qry);
		
		System.out.println("Enter Emp Id :");
		int id = sc.nextInt();
		
		System.out.println("Enter Updated Salary :");
		Double sal = sc.nextDouble();
		
		pstmt.setDouble(1, sal);
		pstmt.setInt(2, id);
		
		int n = pstmt.executeUpdate();
		System.out.println(n+" row updated");
		
		con.close();

	}

}
