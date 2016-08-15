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
	
	public static boolean checkIfUsernameExists(String username) {
		db = new DBConnection();
		db.getConnection();
		
		try{
	        String query = "Select id_account from accounts where username=?";
	        PreparedStatement pst = db.getConnection().prepareStatement(query);
	        pst.setString(1, username);
	        ResultSet rs = pst.executeQuery();
	        if(rs.next()){
	        	return true;
	        }
	        else return false;
		} catch(Exception e) {
			
		}
		
		return false;
	}

	public static void createAccount(String username, String password, String accountType) {
		db = new DBConnection();
		db.getConnection();
		
		try{
	        String query = "INSERT INTO accounts(username, password, accounttype)VALUES(?, ?, ?);";
	        PreparedStatement pst = db.getConnection().prepareStatement(query);
	        pst.setString(1, username);
	        pst.setString(2, password);
	        pst.setString(3, accountType);
	        pst.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int getAccountID(String username) {

		db = new DBConnection();
		db.getConnection();
		
		try{
	        String query = "Select id from accounts where username=?";
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
	
	public static boolean addCustAccount(String username, String password, String first_name, String middle_name, String last_name, 
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
	        
			String query = "INSERT INTO accounts (username, password, email, privilege, firstname, middlename, lastname) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement pst = db.getConnection().prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, password);
			pst.setString(3, email);
			pst.setString(4, privilegeLevel);
			pst.setString(5, first_name);
			pst.setString(6, middle_name);
			pst.setString(7, last_name);
			
			String query2 = "INSERT INTO billing_address (house_num, street, subdivision, city, postal_code, country) VALUES(?,?,?,?,?,?)";
			PreparedStatement pst2 = db.getConnection().prepareStatement(query2);
			pst2.setString(1, bil_house_num);
			pst2.setString(2, bil_street);
			pst2.setString(3, bil_subdivision);
			pst2.setString(4, bil_city);
			pst2.setString(5, bil_postal_code);
			pst2.setString(6, bil_country);

			String query3 = "INSERT INTO shipping_address (house_num, street, subdivision, city, postal_code, country) VALUES(?,?,?,?,?,?)";    
	        PreparedStatement pst3 = db.getConnection().prepareStatement(query3);
	        pst3.setString(1, ship_house_num);
	        pst3.setString(2, ship_street);
	        pst3.setString(3, ship_subdivision);
	        pst3.setString(4, ship_city);
	        pst3.setString(5, ship_postal_code);
	        pst3.setString(6, ship_country);
	        
	        pst.executeUpdate();
	        pst2.executeUpdate();
	        pst3.executeUpdate();
	        
	        System.out.println("Inside model add customer");
	        
	        return true;
		} catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("EDI PUTA NG ADD ACCOUNT");
			return false;
		}
		
	}
	
	public static ArrayList<Product> getProductsList()
	{
		System.out.println("KING INA NG PRODUCTS");
		db = new DBConnection();
		db.getConnection();
		ArrayList<Product> list = new ArrayList<Product>();

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
	        String query = "SELECT name, price, category FROM products WHERE id = ?";
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
	
	public static ArrayList<RecordType0> getFinanceRecordsType0(String filter2)
	{
		db = new DBConnection();
		db.getConnection();
		ArrayList<RecordType0> list = null;
		
		if(filter2 == "0")
		{
			try
			{
				System.out.println("I start here");
		        String query = 
		        		"SELECT SUM(p.price * s.quantity) AS \"Total\" "
		        		+ "FROM product_sales s , products p, transaction t, accounts a"
		        		+ "WHERE s.transaction_id = t.id AND s.product_id = p.id AND t.accounts_id = a.id";
		        PreparedStatement pst = db.getConnection().prepareStatement(query);
		        ResultSet rs = pst.executeQuery();
		        list = new ArrayList();
		        if(rs.next())
		        {
		        	list.add(new RecordType0("Total Sales", rs.getDouble("Total")));
		        }
		        
		        System.out.println("I end here");
			} catch(Exception e) 
			{
				e.printStackTrace();
				System.out.println("EDI PUTA NG FINANCE");
			}
		}
		else if(filter2 == "1")
		{
			try
			{
				System.out.println("I start here");
		        String query = 
		        		"SELECT p.category AS \"Product Type\",  SUM(p.price * s.quantity) AS \"Total\" "
		        		+ "FROM product_sales s , products p, transaction t, accounts a "
		        		+ "WHERE s.transaction_id = t.id AND s.product_id = p.id AND t.accounts_id = a.id "
		        		+ "GROUP BY p.name";
		        PreparedStatement pst = db.getConnection().prepareStatement(query);
		        ResultSet rs = pst.executeQuery();
		        list = new ArrayList();
		        if(rs.next())
		        {
		        	list.add(new RecordType0(rs.getString("Product Type"), rs.getDouble("Total")));
		        }
		        
		        System.out.println("I end here");
			} catch(Exception e) 
			{
				e.printStackTrace();
				System.out.println("EDI PUTA NG FINANCE");
			}
		}
		else if(filter2 == "2")
		{
			try
			{
				System.out.println("I start here");
		        String query = 
		        		"SELECT p.name AS \"Product Name\",  SUM(p.price * s.quantity) AS \"Total\" "
		        		+ "FROM product_sales s , products p, transaction t, accounts a "
		        		+ "WHERE s.transaction_id = t.id AND s.product_id = p.id AND t.accounts_id = a.id "
		        		+ "GROUP BY p.category";
		        PreparedStatement pst = db.getConnection().prepareStatement(query);
		        ResultSet rs = pst.executeQuery();
		        list = new ArrayList();
		        if(rs.next())
		        {
		        	list.add(new RecordType0(rs.getString("Product Name"), rs.getDouble("Total")));
		        }
		        
		        System.out.println("I end here");
			} catch(Exception e) 
			{
				e.printStackTrace();
				System.out.println("EDI PUTA NG FINANCE");
			}
		}
		else
			return null;
		return list;
	}
	
	public static ArrayList<RecordType1> getFinanceRecordsType1(String filter1, String filter2)
	{
		db = new DBConnection();
		db.getConnection();
		ArrayList<RecordType1> list = null;
		String filter = null, query = null;
		
		if(filter1 == "1")
		{
			query = 
        		"SELECT a.username AS \"User\", p.category AS \"Product Type\", p.name AS \"Product Name\""
        		+ ", p.price AS \"Price\", s.quantity AS \"Quantity\", p.price * s.quantity AS \"Total\""
        		+ "FROM product_sales s , products p, transaction t, accounts a"
        		+ "WHERE s.transaction_id = t.id AND s.product_id = p.id AND t.accounts_id = a.id AND p.category = \"" + filter2 + "\"";
		}
			
		else if(filter1 == "2")
		{
			query = 
        		"SELECT a.username AS \"User\", p.category AS \"Product Type\", p.name AS \"Product Name\""
        		+ ", p.price AS \"Price\", s.quantity AS \"Quantity\", p.price * s.quantity AS \"Total\""
        		+ "FROM product_sales s , products p, transaction t, accounts a"
        		+ "WHERE s.transaction_id = t.id AND s.product_id = p.id AND t.accounts_id = a.id AND p.name = \"" + filter2 + "\"";
		}
		else 
			return null;
		
		try
		{
			System.out.println("I start here");
	        
	        PreparedStatement pst = db.getConnection().prepareStatement(query);
	        ResultSet rs = pst.executeQuery();
	        list = new ArrayList();
	        if(rs.next())
	        {
	        	list.add(new RecordType1(rs.getString("User"), rs.getString("Product Type"), rs.getString("Product Name"), rs.getDouble("Price"), rs.getInt("Quantity") , rs.getDouble("Total")));
	        }
	        
	        System.out.println("I end here");
		} catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("EDI PUTA NG FINANCE");
		}
		
		return list;
	}
	
	public static ArrayList<String> getAllProductNames()
	{
		db = new DBConnection();
		db.getConnection();
		ArrayList<String> list = null;
		
		try
		{
			System.out.println("I start here");
	        String query = 
	        		"SELECT name FROM products ORDER BY name asc";
	        PreparedStatement pst = db.getConnection().prepareStatement(query);
	        ResultSet rs = pst.executeQuery();
	        list = new ArrayList();
	        if(rs.next())
	        {
	        	list.add(rs.getString("name"));
	        }
	        
	        System.out.println("I end here");
		} catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("EDI PUTA NG PRODUCT NAMES");
		}
		
		return list;
	}
	
	public static String getPrivilegeLevel(int id) {

		db = new DBConnection();
		db.getConnection();
		
		try{
	        String query = "Select privilege from accounts where id=?";
	        PreparedStatement pst = db.getConnection().prepareStatement(query);
	        pst.setString(1, String.valueOf(id));
	        ResultSet rs = pst.executeQuery();
	        if(rs.next()){
	        	return rs.getString("privilege");
	        }
	        else return "not exist";
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "error dafuq";
	}
}
