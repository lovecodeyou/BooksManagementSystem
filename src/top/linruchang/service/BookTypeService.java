package top.linruchang.service;

import java.sql.Connection;
import java.util.List;

import top.linruchang.dao.BookTypeDao;
import top.linruchang.modal.BookType;
import top.linruchang.util.DBUtil;

public class BookTypeService {
	
	BookTypeDao btd = new BookTypeDao();
	
	public int add(BookType bt) {
		
		Connection conn = DBUtil.getConnection();
		
		int result;
		try {
			result = btd.add(conn, bt);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("添加失败");
			return 0;
		} finally {
			DBUtil.closeResource(null, null, conn);
		}
		
		
	}
	
	
	public List<BookType> query(BookType bt) {
		Connection conn = DBUtil.getConnection();
		
		try {
			List<BookType> lists = btd.query(conn, bt);
			return lists;
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("查询数据失败");
			return null;
		} finally {
			DBUtil.closeResource(null ,null, conn);
		}
		
	}
	
	
	public int update(BookType bt) {
		
		Connection conn = DBUtil.getConnection();
		
		try {
			int result = btd.update(conn, bt);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeResource(null, null, conn);
		}
		
		return 0;
	}
	
	
	public int delete(int id) {
		
		Connection conn = DBUtil.getConnection();
		
		try {
			int result = btd.delete(conn, id);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeResource(null, null, conn);
		}
		
		return 0;
		
	}
	
	
	
	
}
