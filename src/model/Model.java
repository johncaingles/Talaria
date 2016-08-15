package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class Model {
	
	private static DBConnection db;

	public static boolean checkCredentials(String username, String password) {
		db = new DBConnection();
		db.getConnection();
		
		try{
	        String query = "Select id from accounts where username=? and password=?";
	        PreparedStatement pst = db.getConnection().prepareStatement(query);
	        pst.setString(1, username);
	        pst.setString(2, password);
	        ResultSet rs = pst.executeQuery();
	        if(rs.next()){
	        	return true;
	        }
	        else return false;
		} catch(Exception e) {
			
		}
		
		return false;
	}

	public static int getAccountID(String username) {

		db = new DBConnection();
		db.getConnection();
		
		try{
	        String query = "Select id_account from accounts where username=?";
	        PreparedStatement pst = db.getConnection().prepareStatement(query);
	        pst.setString(1, username);
	        ResultSet rs = pst.executeQuery();
	        if(rs.next()){
	        	return rs.getInt("id");
	        }
	        else return -1;
		} catch(Exception e) {
			
		}
		
		return -1;
	}
	
	public static void addCustAccount(String username, String password, String first_name, String middle_name, String last_name, 
			String email, String privilegeLevel, String bil_house_num, String bil_street,
			String bil_subdivision, String bil_city, String bil_postal_code,
			String bil_country, String ship_house_num, String ship_street, String ship_subdivision,
			String ship_city, String ship_postal_code, String ship_country)
	{
		db = new DBConnection();
		db.getConnection();
		
		try{
			
//			String queryString = "INSERT INTO accounts (username, password, email, privilege, firstname, middlename, lastname) VALUES(@username, @password, @email, @privilege, @firstname, @middlename, @lastname)";
//			String queryString = "INSERT INTO billing_addreess (house_num, street, subdivision, city, postal_code, country) VALUES(@bil_house_num, @bil_street, @bil_subdivision, @bil_city, @bil_postal_code, @bil_country)";
//			String queryString = "INSERT INTO shipping_addreess (house_num, street, subdivision, city, postal_code, country) VALUES(@ship_house_num, @ship_street, @ship_subdivision, @ship_city, @ship_postal_code, @ship_country)";
			
//	        String query = "INSERT INTO accounts VALUES " + username + " , " + password + " , " + email + " , " + '1' + " , " + first_name + " , " + middle_name + " , " + last_name;
//	        String query2 = "INSERT INTO billing_address VALUES " + bil_house_num + " , " + bil_street + " , " + bil_subdivision + " , " + bil_city + " , " + bil_postal_code + " , " + bil_country ;
//	        String query3 = "INSERT INTO shipping_address VALUES " + ship_house_num + " , " + ship_street + " , " + ship_subdivision + " , " + ship_city + " , " + ship_postal_code + " , " + ship_country ;
	        
			String query = "INSERT INTO accounts (username, password, email, privilege, firstname, middlename, lastname) VALUES (@username, @password, @email, @privilege, @firstname, @middlename, @lastname)";
			String query2 = "INSERT INTO billing_addreess (house_num, street, subdivision, city, postal_code, country) VALUES(@bil_house_num, @bil_street, @bil_subdivision, @bil_city, @bil_postal_code, @bil_country)";
			String query3 = "INSERT INTO shipping_addreess (house_num, street, subdivision, city, postal_code, country) VALUES(@ship_house_num, @ship_street, @ship_subdivision, @ship_city, @ship_postal_code, @ship_country)";
	        PreparedStatement pst = db.getConnection().prepareStatement(query);
	        PreparedStatement pst2 = db.getConnection().prepareStatement(query2);
	        PreparedStatement pst3 = db.getConnection().prepareStatement(query3);
	        
	        ResultSet rs = pst.executeQuery();
	        ResultSet rs2 = pst2.executeQuery();
	        ResultSet rs3 = pst3.executeQuery();
	        
	        
		} catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("EDI PUTA NG ADD ACCOUNT");
		}
		
	}
	
	public static ArrayList<Product> getProductsList()
	{
		System.out.println("KING INA NG PRODUCTS");
		db = new DBConnection();
		db.getConnection();
		ArrayList<Product> list = new ArrayList();

		try
		{
			System.out.println("I start here");
	        String query = "SELECT * FROM products";
	        PreparedStatement pst = db.getConnection().prepareStatement(query);
	        ResultSet rs = pst.executeQuery();
	        if(rs.next())
	        {
	        	list.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getString("category")));
	        }
	        System.out.println("I end here");
		} catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("EDI PUTA NG PRODUCTS");
		}
		
		return list;
		
	}

	public static HashMap<String, ArrayList<Product>> getProductsHash()
	{
		System.out.println("KING INA NG PRODUCTS");
		db = new DBConnection();
		db.getConnection();
		HashMap<String, ArrayList<Product>> hmap = new HashMap<String, ArrayList<Product>>();
		ArrayList<Product> bootsList = new ArrayList<Product>();
		ArrayList<Product> shoesList = new ArrayList<Product>();
		ArrayList<Product> sandalsList = new ArrayList<Product>();
		ArrayList<Product> slippersList = new ArrayList<Product>();
		
		try
		{
			System.out.println("I start here");
	        String query = "SELECT * FROM products";
	        PreparedStatement pst = db.getConnection().prepareStatement(query);
	        ResultSet rs = pst.executeQuery();
	        while(rs.next())
	        {
	        	if(rs.getString("category").equals("boots"))
	        	{
	        		bootsList.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getString("category")));
	        	}
	        	else if(rs.getString("category").equals("shoes"))
	        	{
	        		shoesList.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getString("category")));
	        	}
	        	else if(rs.getString("category").equals("sandals"))
	        	{
	        		sandalsList.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getString("category")));
	        	}
	        	else if(rs.getString("category").equals("slippers"))
	        	{
	        		slippersList.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getString("category")));
	        	}
	        }
	        hmap.put("boots", bootsList);
	        hmap.put("shoes", shoesList);
	        hmap.put("sandals", sandalsList);
	        hmap.put("slippers", slippersList);
	        
	        System.out.println("I end here");
		} catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("EDI PUTA NG PRODUCTS");
		}
		
		return hmap;
	}
	
	public static Product getProduct(int id)
	{
		db = new DBConnection();
		db.getConnection();
		Product prod = new Product();
		
		try
		{
			System.out.println("I start here");
	        String query = "SELECT name, price, category FROM products WHERE id_product = ?";
	        PreparedStatement pst = db.getConnection().prepareStatement(query);
	        pst.setInt(1, id);
	        ResultSet rs = pst.executeQuery();
	        if(rs.next())
	        {
	        	prod.setProd_id(id);
	        	prod.setName(rs.getString("name"));
	        	prod.setPrice(rs.getDouble("price"));
	        	prod.setCategory(rs.getString("category"));
	        }
	        System.out.println("I end here");
		} catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("EDI PUTA NG PRODUCT");
		}
		
		return prod;
	}
	
	
}
