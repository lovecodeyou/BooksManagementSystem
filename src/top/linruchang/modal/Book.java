package top.linruchang.modal;


/*
ID  NUMBER           
BOOKNAME  NVARCHAR2(60)  Y        
AUTHOR  NVARCHAR2(30)  Y        
BOOKTYPEID  NUMBER  Y        
BOOKDESC  NVARCHAR2(300)  Y        
PRICE  NUMBER(10,2)  Y    
 */

public class Book {
	private Integer id;
	private String bookName;
	private double price;
	private String author;
	private String bookDesc;
	private Integer bookTypeId;
	private String bookTypeName;
	
	
	
	public Book(Integer id, String bookName, double price, String author, String bookDesc, Integer bookTypeId,
			String bookTypeName) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.price = price;
		this.author = author;
		this.bookDesc = bookDesc;
		this.bookTypeId = bookTypeId;
		this.bookTypeName = bookTypeName;
	}



	public Book() {
		
	}
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBookDesc() {
		return bookDesc;
	}
	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}
	public Integer getBookTypeId() {
		return bookTypeId;
	}
	public void setBookTypeId(Integer bookTypeId) {
		this.bookTypeId = bookTypeId;
	}
	public String getBookTypeName() {
		return bookTypeName;
	}
	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", price=" + price + ", author=" + author + ", bookDesc="
				+ bookDesc + ", bookTypeId=" + bookTypeId + ", bookTypeName=" + bookTypeName + "]";
	}
	
	
	
	
}
