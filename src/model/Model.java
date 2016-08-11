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
	        String query = "Select id_account from accounts where username=? and password=?";
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
	        	return rs.getInt("id_account");
	        }
	        else return -1;
		} catch(Exception e) {
			
		}
		
		return -1;
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
	        	list.add(new Product(rs.getInt("id_product"), rs.getString("name"), rs.getFloat("price"), rs.getString("category")));
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
	        		bootsList.add(new Product(rs.getInt("id_product"), rs.getString("name"), rs.getFloat("price"), rs.getString("category")));
	        	}
	        	else if(rs.getString("category").equals("shoes"))
	        	{
	        		shoesList.add(new Product(rs.getInt("id_product"), rs.getString("name"), rs.getFloat("price"), rs.getString("category")));
	        	}
	        	else if(rs.getString("category").equals("sandals"))
	        	{
	        		sandalsList.add(new Product(rs.getInt("id_product"), rs.getString("name"), rs.getFloat("price"), rs.getString("category")));
	        	}
	        	else if(rs.getString("category").equals("slippers"))
	        	{
	        		slippersList.add(new Product(rs.getInt("id_product"), rs.getString("name"), rs.getFloat("price"), rs.getString("category")));
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
}
