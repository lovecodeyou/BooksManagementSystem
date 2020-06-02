package top.linruchang.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import top.linruchang.modal.BookType;
import top.linruchang.util.StringUtil;

public class BookTypeDao {
	
	
	public int add(Connection conn, BookType bt) throws Exception{
		
		String sql = "insert into booktype values ( ?, ?, ? )";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		
		statement.setObject(1, bt.getId());
		statement.setObject(2, bt.getBookTypeName());
		statement.setObject(3, bt.getBookTypeDesc());
		
		int result = statement.executeUpdate();
		
		return result;
	}
	
	
	public List<BookType> query(Connection conn, BookType bt) throws Exception{
		
		
		String sql = new String("select * from bookType where bookTypeName like  ?");
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		String bookTypeName = bt.getBookTypeName();
		if(bookTypeName == null) {
			bookTypeName = "";
		}
		ps.setString(1, "%"+ bookTypeName +"%");
		
		ResultSet rs = ps.executeQuery();
		
		List<BookType> bts = new ArrayList<BookType>();
		while(rs.next()) {
			BookType cbt = new BookType();
			cbt.setId(rs.getInt(1));
			cbt.setBookTypeName(rs.getString(2));
			cbt.setBookTypeDesc(rs.getString(3));
			bts.add(cbt);
		}
		
		return bts;
		
	}
	
	
	public int delete(Connection conn, int id) throws Exception{
		
		
		String sql = "delete bookType where id = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setObject(1, id);
		
		
		int result = ps.executeUpdate();
		
		return result;
	}
	
	
	public int update(Connection conn, BookType bt) throws Exception{
		
		String sql = "update bookType set bookTypeName = ? , bookTypeDesc = ? where id = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		
		
		
		ps.setObject(1, StringUtil.initalEmpty(bt.getBookTypeName()));
		
		ps.setObject(2, StringUtil.initalEmpty(bt.getBookTypeDesc()));
			
		ps.setObject(3, bt.getId());
		
		int result = ps.executeUpdate();
		
		return result;
	}
	
	
	
}
