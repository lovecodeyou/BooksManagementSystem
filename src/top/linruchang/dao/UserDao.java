package top.linruchang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import top.linruchang.modal.User;
import top.linruchang.util.DBUtil;

/**
 * 1. 连接用户表的类
 * @author lrc
 *
 */
public class UserDao {
	
	/**
	 * 
	 * @Description 登录操作
	 * @param conn
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(Connection conn, User user) throws Exception{
		
		String sql = "select * from b_user where username=? and password = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setObject(1,  user.getUserName());
		ps.setObject(2, user.getPassword());
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			User user1 = new User();
			user1.setUserName(rs.getString(1));
			user1.setPassword(rs.getString(2));
			return user1;
		}
		return null;
	}
	
	@Test
	public void test() throws Exception {
		
		Connection conn = DBUtil.getConnection();
		User user = new User();
		user.setPassword("admin");
		user.setUserName("admin");
		User login = new UserDao().login(conn,user);
		
		System.out.println(login);
	}
	
}
