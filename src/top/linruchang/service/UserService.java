package top.linruchang.service;

import java.sql.Connection;

import top.linruchang.dao.UserDao;
import top.linruchang.modal.User;
import top.linruchang.util.DBUtil;

public class UserService {

	UserDao ud = new UserDao();

	public User login(User user) {
		
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			return ud.login(conn, user);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.closeResource(null, null, conn);
		}

	}

}
