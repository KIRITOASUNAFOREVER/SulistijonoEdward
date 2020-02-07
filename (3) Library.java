package Exercise3;

public class Library {

	public Library(String bookName, String bookId, int quantity, int price) {
		super();
		this.bookName = bookName;
		this.bookId = bookId;
		Quantity = quantity;
		Price = price;
	}
	private String bookName;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	private String bookId;
	private int Quantity;
	private int Price;
	
	public Library()
	{
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
