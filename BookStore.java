package Latihan1;

public class BookStore {
	
	public BookStore(String bookName, String bookID, int quantity, int price)
	{
		super();
		this.bookName = bookName;
		this.bookID = bookID;
		this.quantity = quantity;
		this.price = price;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	private String bookName;
	private String bookID;
	private int quantity;
	private int price;
	
	
	
	public BookStore()
	{
		
	}
}
