package com.cg.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.util.DBUtil;

public class Display1 {

	public static void main(String[] args) {

		String qry = "select * from employee_tbl";
		
		try
		{		
		Connection con = DBUtil.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement(qry);
		
		//pstmt.setInt(1, 1001);
		ResultSet rst = pstmt.executeQuery();
		//int num = pstmt.executeUpdate();
		
		ArrayList<Employee> list = new ArrayList<Employee>();
		
		while(rst.next())
		{
			int id = rst.getInt("empid");
			String name = rst.getString("empname");
			double salary = rst.getDouble("empsal");
			Employee employee = new Employee(id,name,salary);
			list.add(employee);
		}
		
		TestConnection obj = new TestConnection();
		obj.printEmployeeInfo(list);
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
