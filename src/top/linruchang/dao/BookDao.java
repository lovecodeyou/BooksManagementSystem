package top.linruchang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import top.linruchang.modal.Book;
import top.linruchang.util.StringUtil;

/*
ID  NUMBER           
BOOKNAME  NVARCHAR2(60)  Y        
AUTHOR  NVARCHAR2(30)  Y        
BOOKTYPEID  NUMBER  Y        
BOOKDESC  NVARCHAR2(300)  Y        
PRICE  NUMBER(10,2)  Y        
*/
public class BookDao {

	public int add(Connection conn, Book book) throws Exception {

		String sql = "insert into book values( ?, ?, ?, ?, ?, ?)";

		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setObject(1, book.getId());
		ps.setObject(2, book.getBookName());
		ps.setObject(3, book.getAuthor());
		ps.setObject(4, book.getBookTypeId());
		ps.setObject(5, book.getBookDesc());
		ps.setObject(6, book.getPrice());

		int result = ps.executeUpdate();

		return result;
	}

	public List<Book> query(Connection conn, Book book) throws Exception {

		StringBuilder sb = new StringBuilder("select * from book,booktype where book.bookTypeid = booktype.id ");

		if (!StringUtil.isEmpty(book.getBookName())) {
			sb.append("and bookname like '%" + book.getBookName() + "%' ");
		}
		if (!StringUtil.isEmpty(book.getAuthor())) {
			sb.append("and author like '%" + book.getAuthor() + "%' ");
		}
		if (!StringUtil.isEmpty(book.getBookTypeName())) {
			System.out.println(book.getBookTypeName() == null);

			sb.append(" and booktypeName like '%" + book.getBookTypeName() + "%' ");
		}

		String sql = sb.toString();
		System.out.println("sql£º" + sql);

		PreparedStatement ps = conn.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		List<Book> lists = new ArrayList<Book>();

		while (rs.next()) {
			Integer id = rs.getInt(1);
			String bookName = rs.getString(2);
			double price = rs.getDouble("price");
			String author = rs.getString(3);
			String bookDesc = rs.getString(5);
			Integer bookTypeId = rs.getInt(4);
			String bookTypeName = rs.getString("booktypename");

			Book book_q = new Book(id, bookName, price, author, bookDesc, bookTypeId, bookTypeName);

			lists.add(book_q);

		}

		if (lists.size() == 0) {
			return null;
		} else {
			return lists;
		}
	}

	public int delete(Connection conn, Book book) throws Exception {

		String sql = "delete book where id = ?";

		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setInt(1, book.getId());

		int result = ps.executeUpdate();

		return result;
	}

	public int update(Connection conn, Book book) throws Exception {

		String sql = "update book set bookName=?, author=?, bookTypeId=?, bookdesc=?, price=? where id=" + book.getId();

		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setObject(1, book.getBookName());
		ps.setObject(2, book.getAuthor());
		ps.setObject(3, book.getBookTypeId());
		ps.setObject(4, book.getBookDesc());
		ps.setObject(5, book.getPrice());

		int result = ps.executeUpdate();

		return result;
	}

}
