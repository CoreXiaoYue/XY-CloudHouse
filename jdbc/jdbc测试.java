package com.xaioyue.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class test1 {
	static Connection com = null;
	static Statement statement = null;
	static final String url = "jdbc:mysql://127.0.0.1:3306/jpa?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8";
	static final String user = "root";// 账号
	static final String password = "aabbcc123";// 密码

//	static {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			System.out.println("mysql驱动注册失败。");
//			e.printStackTrace();
//		}
//	}

	/**
	 * @return 返回数据库连接对象
	 */
	public static Connection getCom() {
		try {
			com = DriverManager.getConnection(url, user, password);// 获取数据库连接对象
			if (com != null) {
				System.out.println("数据库连接成功。");
				return com;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("数据库连接失败。");
		return null;
	}

	/**
	 * 执行查询操作 executeQuery(sql):只能执行查询操作
	 * 
	 * @param sql 要执行的事sql语句
	 * @throws SQLException sql语句错误异常
	 */
	public static void query(String sql) {
		if (com != null && !sql.equals("")) {
			try {
				statement = com.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
					String name = resultSet.getString("t_name");
					System.out.println(name);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
//			System.out.println(result);
		} else {
			System.out.println("sql为空");
		}
	}

	/**
	 * @param sql sql语句
	 * @throws SQLException
	 */
	public static void execute(String sql) throws SQLException {
		if (com != null && !sql.equals("")) {
			statement = com.createStatement();

			boolean result = statement.execute(sql);// 返回Boolean值，执行后第一个结果是reauleSet就返回True,否则false
			System.out.println(result);
			ResultSet resultSet = statement.getResultSet();// 获取结果集对象
			ResultSetMetaData metaData = resultSet.getMetaData();
			int columnCount = metaData.getColumnCount();
			// 遍历结果集
			while (resultSet.next()) {// 是否有下一个
				for (int i = 0; i < columnCount; i++) {
					String name = resultSet.getString(i + 1) + "\t";// 指定列名返回值

					System.out.print(name);
				}
				System.out.println();
			}
		} else {
			System.out.println("sql为空");
		}
	}

	// 分页
	/**
	 * @param sql      sql语句
	 * @param pageSize 每页显示记录数
	 * @param page     页数
	 * @throws SQLException
	 */
	public static void executeRowSet(String sql, int pageSize, int page) throws SQLException {
		if (com != null && !sql.equals("")) {
			statement = com.createStatement();

			boolean result = statement.execute(sql);// 返回Boolean值，执行后第一个结果是reauleSet就返回True,否则false
			System.out.println(result);
			ResultSet resultSet = statement.getResultSet();// 获取结果集对象
			ResultSetMetaData metaData = resultSet.getMetaData();
			int columnCount = metaData.getColumnCount();
			RowSetFactory factory = RowSetProvider.newFactory();
			CachedRowSet cachedRS = factory.createCachedRowSet();
			cachedRS.setPageSize(pageSize);// 设置每页显示记录数
			cachedRS.populate(resultSet, (page - 1) * pageSize + 1);

			while (cachedRS.next()) {
				System.out.println(cachedRS.getString(1) + "\t" + cachedRS.getString(2) + "\t" + cachedRS.getString(3));
			}
		} else {

			System.out.println("sql为空");
		}
	}

	/**
	 * 执行DML语句：增删改操作 executeUpdate(sql)：执行增删改操作。 execute(sql):执行任意sql
	 * 
	 * @param sql 要执行的事sql语句
	 * @throws SQLException sql语句错误异常
	 */
	public static void update(String sql) throws SQLException {
		if (com != null && !sql.equals("")) {
			statement = com.createStatement();

			int result = statement.executeUpdate(sql);// 影响记录数
			System.out.println(result);
		} else {
			System.out.println("sql为空");
		}
	}

	/**
	 * 使用预编译的PreparedStatement对象
	 * 
	 * @param args1 sql语句的第一个？参数，
	 * @param args2 sql语句的第二个？参数，
	 * @throws SQLException sql拼写错误
	 */
	public static void preparedStatement(String args1, int args2) throws SQLException {
		if (com != null && !args1.equals("")) {
			PreparedStatement ps = com.prepareStatement("update user1 set email=? where id = ?");
			ps.setString(1, args1);
			ps.setInt(2, args2);
			int result = ps.executeUpdate();// 执行DML语句返回影响的行数，执行DDL语句返回0
			System.out.println("执行" + result + "条记录");
		} else {
			System.out.println("sql为空");
		}
	}

	public static void main(String[] args) {
		Connection connection = getCom();
//		String sql="set global time_zone='+8:00';";//设置mysql时区。
		String sel = "select * from user";// 查询语句
		String add = "insert into teacher(t_name) values('宏老师 '  )  ";// 插入语句
		String del = "delete from teacher where t_id = 5";// 执行删除语句
		String update = "update user1 set email=\"409656175@qq.com\" where id = 4";// 执行更新语句
		String createTable = "CREATE TABLE teacher1" + " ( t_id INT PRIMARY KEY , t_name VARCHAR(20))";// 测试执行DDL语句
//		query(sel);
		try {
//			update(add);
//			update(del);
//			update(update);
//			execute(sel);
//			update(createTable);
//			preparedStatement("775485884@qq.com",10);
			executeRowSet(sel, 3, 2);
		} catch (SQLException e) {
			System.out.println("sql错误");
			e.printStackTrace();
		}
		close();

	}

	static void close() {
		try {
			if (statement != null) {
				statement.close();
				System.out.println("statement已关闭");
			}
//		if(com!=null) {
//			com.close(); 
//			System.out.println("数据库已关闭。");
//		}
		} catch (SQLException e) {
			System.out.println("关闭失败。");
			e.printStackTrace();
		}
	}
}