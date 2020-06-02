package top.linruchang.service;

import java.sql.Connection;
import java.util.List;

import top.linruchang.dao.BookDao;
import top.linruchang.modal.Book;
import top.linruchang.util.DBUtil;

public class BookService {

	BookDao bd = new BookDao();

	public int add(Book book) {

		Connection conn = DBUtil.getConnection();

		try {
			int result = bd.add(conn, book);

			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public List<Book> query(Book book) {

		Connection conn = DBUtil.getConnection();

		try {
			return bd.query(conn, book);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeResource(null, null, conn);
		}

		return null;
	}

	public int delete(Book book) {

		Connection conn = DBUtil.getConnection();

		try {
			int result = bd.delete(conn, book);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public int update(Book book) {

		Connection conn = DBUtil.getConnection();

		try {
			int result = bd.update(conn, book);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

}
