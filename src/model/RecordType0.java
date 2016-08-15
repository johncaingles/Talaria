package model;

public class RecordType0 
{
	private String category_type;
	private double total_price;
	
	
	public RecordType0() {
	}
	public RecordType0(String category_type, double total_price) 
	{
		this.category_type = category_type;
		this.total_price = total_price;
	}
	public String getCategory_type() {
		return category_type;
	}
	public void setCategory_type(String category_type) {
		this.category_type = category_type;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	
	
}
