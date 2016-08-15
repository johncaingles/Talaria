package model;

public class RecordType1 
{
	private String username;
	private String product_Type;
	private String product_name;
	private double price;
	private int quantity;
	private double total;
	
	public RecordType1() {
	}
	
	public RecordType1(String username, String product_Type,
			String product_name, double price, int quantity, double total) {
		this.username = username;
		this.product_Type = product_Type;
		this.product_name = product_name;
		this.price = price;
		this.quantity = quantity;
		this.total = total;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getProduct_Type() {
		return product_Type;
	}
	public void setProduct_Type(String product_Type) {
		this.product_Type = product_Type;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
	
}
