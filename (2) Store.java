package Exercise2;

public class Store {
	
	public Store(String itemName, String itemId, int quantity, int price) {
		super();
		this.itemName = itemName;
		this.itemId = itemId;
		Quantity = quantity;
		Price = price;
	}
	private String itemName;
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
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
	private String itemId;
	private int Quantity;
	private int Price;
	
	public Store()
	{
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
