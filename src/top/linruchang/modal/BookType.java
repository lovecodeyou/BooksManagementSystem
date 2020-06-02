package top.linruchang.modal;

public class BookType {
	private Integer id;
	private String bookTypeName;
	private String bookTypeDesc;
	
	
	
	public BookType() {
		super();
	}
	
	public BookType(Integer id, String bookTypeName, String bookTypeDesc) {
		super();
		this.id = id;
		this.bookTypeName = bookTypeName;
		this.bookTypeDesc = bookTypeDesc;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBookTypeName() {
		return bookTypeName;
	}
	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}
	public String getBookTypeDesc() {
		return bookTypeDesc;
	}
	public void setBookTypeDesc(String bookTypeDesc) {
		this.bookTypeDesc = bookTypeDesc;
	}
	@Override
	public String toString() {
		return "BookType [id=" + id + ", bookTypeName=" + bookTypeName + ", bookTypeDesc=" + bookTypeDesc + "]";
	}
	
	
	
}
