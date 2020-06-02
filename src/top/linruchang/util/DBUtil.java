package top.linruchang.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;


public class DBUtil {
	
	private static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static String userName = "test";
	private static String password = "123456";
	private static String driverClass = "oracle.jdbc.driver.OracleDriver";
	
	
	public static Connection getConnection(){
		
		Connection conn = null;
		try {
			Class.forName(driverClass);
			
			conn = DriverManager.getConnection(url, userName, password);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据库连接获取且失败");
			return conn;
		}
		
	}
	
	
	public static void closeResource(ResultSet rs, Statement statement, Connection con) {
		try {
			
			if(rs != null) {
				rs.close();
			}
			if( statement != null) {
				statement.close();
			}
			if( con != null) {
				con.close();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
	}
	
	@Test
	public void test() throws Exception {
		System.out.println(getConnection());
	}
	
}
