package com.xiaoyue.xml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

public class LinkMysq {
	static Connection connection = null;
	
	public static void main(String[] args)   {
		XmlJdbcConfig xmlJdbcConfig = new XmlJdbcConfig();
		Map<String, String> map = XmlJdbcConfig.getMap();
		String url = map.get("url");
		String name = map.get("name");
		String password = map.get("password");
		try {
			connection = getConnection(url, name, password);
//			 connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/af_school", "root", "aabbcc123");
			System.out.println(connection);
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
/**
 * @param url 路径
 * @param user 用户名
 * @param password 密码
 * @return
 * @throws SQLException
 */
public static Connection getConnection(String url,String user,String password) throws SQLException {
	Connection conn = DriverManager.getConnection(url, user, password);
	return conn;
}
}
