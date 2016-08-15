package model;

public class Product 
{
	private int prod_id;
	private String name;
	private double price;
	private String category;
	public Product(int prod_id, String name, double price, String category) 
	{
		super();
		this.prod_id = prod_id;
		this.name = name;
		this.price = price;
		this.category = category;
	}
	
	public int getProd_id()
	{
		return prod_id;
	}
	public void setProd_id(int prod_id)
	{
		this.prod_id = prod_id;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public double getPrice()
	{
		return price;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	public String getCategory()
	{
		return category;
	}
	public void setCategory(String category)
	{
		this.category = category;
	}
	
	
}