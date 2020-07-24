package com.cg.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.util.DBUtil;

public class Display {

	public static void main(String[] args) {
		
//		String className = "oracle.jdbc.driver.OracleDriver";
//		String user="hr";
//		String pass="hr";
//		String url="jdbc:oracle:thin:@localhost:1521:xe";
		
		String qry = "select * from employee_tbl";
		
		try
		{		
		Connection con = DBUtil.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(qry);
		
		//pstmt.setInt(1, 1001);
		ResultSet rst = pstmt.executeQuery();
		//int num = pstmt.executeUpdate();
		
		while(rst.next())
		{
			int id = rst.getInt("empid");
			String name = rst.getString("empname");
			double salary = rst.getDouble("empsal");
			System.out.println(id+" "+name+" "+salary);
		}
		con.close();
		}
		catch(ClassNotFoundException e)
		{
		//	System.out.println(e);
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}

}
