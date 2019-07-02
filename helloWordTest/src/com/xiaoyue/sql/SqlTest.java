package com.xiaoyue.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlTest {
	static Connection con;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("驱动注册失败");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8","root","aabbcc123");
		} catch (SQLException e) {
			System.out.println("数据库链接失败。");
			e.printStackTrace();
		}
		return con;
		
	}

	public static void main(String[] args) {
		
		Connection connection = SqlTest.getConnection();
		Statement statement = null;
		System.out.println("数据库链接成功。"+connection);
		try {
			statement = connection.createStatement();
			String sql = "select * from test";
//			boolean execute = statement.execute(sql);
//			ResultSet execute = statement.executeQuery(sql);
			PreparedStatement prepareStatement = connection.prepareStatement("select * from test t where t.fenshu=?");
			prepareStatement.setDouble(1, 81.5);
			ResultSet executeQuery = prepareStatement.executeQuery();
			while(executeQuery.next()) {
//				System.out.println(execute.getString("NAME"));
				System.out.println(executeQuery.getString("NAME"));
				System.out.println(executeQuery.getString("kecheng"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			if(connection !=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(statement !=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		
		
	}

}
