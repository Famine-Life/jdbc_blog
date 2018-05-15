package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBhelper {
	
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://127.0.0.1:3306/jdbc_mysql";
	private static final String user = "root";
	private static final String password = "admin";
	
	//静态代码
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("驱动加载失败!");
		}
	}
	
	public static Connection getConnection() throws SQLException{
		//返回connection连接
		return DriverManager.getConnection(url,user,password);
	}
}





