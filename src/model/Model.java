package model;

import java.sql.Connection;
//import java.sql.Date;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.util.SimpleByteSource;

import com.mysql.jdbc.Statement;

public class Model {
	
	private static DBConnection db;
	
	public static String getPassword(String username)
	{
		db = new DBConnection();
		db.getConnection();
		
		String password = null;
		
		try{
	        String query = "Select password from accounts where username = ?";
	        PreparedStatement pst = db.getConnection().prepareStatement(query);
	        pst.setString(1, username);
	        ResultSet rs = pst.executeQuery();
	        if(rs.next())
	        	return rs.getString("password");
	        
		} catch(Exception e) {
			
		}
		return password;
	}
	
	public static String getSalt(String username)
	{
		db = new DBConnection();
		db.getConnection();
		
		String salt = null;
		
		try{
	        String query = "Select salt from accounts where username = ?";
	        PreparedStatement pst = db.getConnection().prepareStatement(query);
	        pst.setString(1, username);
	        ResultSet rs = pst.executeQuery();
	        if(rs.next())
	        	return rs.getString("salt");
	        
		} catch(Exception e) {
			
		}
		return salt;
	}
	
	public static boolean checkCredentials(String username, String password) {
		db = new DBConnection();
		db.getConnection();
		
//		Object salt = rng.nextBytes();
//		String hashedPasswordBase64 = new Sha256Hash(password, salt, 1024).toBase64();
		
//		String passwordFromDB = getPassword(username);
//		
		String salt = getSalt(username);
		String hashedPasswordBase64 = new Sha256Hash(password, salt, 1024).toBase64();
//		
//		System.out.println("This is user input password : " + password);
//		
//		System.out.println("This is hashed password from db : " + passwordFromDB);
//		
//		System.out.println("This is the salt from db : " + salt);
//		
//		System.out.println("This is hashed password from user input : " + hashedPasswordBase64);
		
//		if(passwordFromDB.equals(hashedPasswordBase64))
//			System.out.println("Please be true");
//		else
//			System.out.println("Well fuck then");
		
		try{
	        String query = "Select id from accounts where username=? and password=?";
	        PreparedStatement pst = db.getConnection().prepareStatement(query);
	        pst.setString(1, username);
	        pst.setString(2, hashedPasswordBase64);
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
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
//		DefaultHashService hashService = new DefaultHashService();
//		hashService.setHashIterations(500000); // 500000
//		hashService.setHashAlgorithmName(Sha256Hash.ALGORITHM_NAME);
//		hashService.setPrivateSalt(new SimpleByteSource("myVERYSECRETBase64EncodedSalt")); // Same salt as in shiro.ini, but NOT base64-encoded.
//		hashService.setGeneratePublicSalt(true);
//
//		DefaultPasswordService passwordService = new DefaultPasswordService();
//		passwordService.setHashService(hashService);
//		String encryptedPassword = passwordService.encryptPassword(password);
		
		RandomNumberGenerator rng = new SecureRandomNumberGenerator();
		String salt = rng.nextBytes().toString();

		String hashedPasswordBase64 = new Sha256Hash(password, salt, 1024).toBase64();
		
		System.out.println("This is the hash salt : " + salt.toString());
		System.out.println("This is the hashed password : " + hashedPasswordBase64);
		
		try{
	        String query = "INSERT INTO accounts(username, password, privilege, salt, created_date )VALUES(?, ?, ?, ?, NOW());";
	        PreparedStatement pst = db.getConnection().prepareStatement(query);
	        pst.setString(1, username);
	        pst.setString(2, hashedPasswordBase64);
	        pst.setString(3, accountType);
	        pst.setString(4, salt);
	        
	        pst.executeUpdate();
	        
//	        query = "insert table1 (created_date) values (convert(datetime," + dateFormat.format(date) + ",5));";
//	        pst = db.getConnection().prepareStatement(query);
//	        pst.executeUpdate();
	        
//	        java.sql.Statement stmt = db.getConnection().createStatement() ;
//	        query = "insert accounts (created_date) values (convert(datetime," + dateFormat.format(date) + ",5));" ;
//	        stmt.executeUpdate(query) ;
	        
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
		
		RandomNumberGenerator rng = new SecureRandomNumberGenerator();
		String salt = rng.nextBytes().toString();

		String hashedPasswordBase64 = new Sha256Hash(password, salt, 1024).toBase64();
		
		System.out.println("This is the hash salt : " + salt.toString());
		System.out.println("This is the hashed password : " + hashedPasswordBase64);
		
		try{
			
//			String queryString = "INSERT INTO accounts (username, password, email, privilege, firstname, middlename, lastname) VALUES(@username, @password, @email, @privilege, @firstname, @middlename, @lastname)";
//			String queryString = "INSERT INTO billing_addreess (house_num, street, subdivision, city, postal_code, country) VALUES(@bil_house_num, @bil_street, @bil_subdivision, @bil_city, @bil_postal_code, @bil_country)";
//			String queryString = "INSERT INTO shipping_addreess (house_num, street, subdivision, city, postal_code, country) VALUES(@ship_house_num, @ship_street, @ship_subdivision, @ship_city, @ship_postal_code, @ship_country)";
			
//	        String query = "INSERT INTO accounts VALUES " + username + " , " + password + " , " + email + " , " + '1' + " , " + first_name + " , " + middle_name + " , " + last_name;
//	        String query2 = "INSERT INTO billing_address VALUES " + bil_house_num + " , " + bil_street + " , " + bil_subdivision + " , " + bil_city + " , " + bil_postal_code + " , " + bil_country ;
//	        String query3 = "INSERT INTO shipping_address VALUES " + ship_house_num + " , " + ship_street + " , " + ship_subdivision + " , " + ship_city + " , " + ship_postal_code + " , " + ship_country ;
	        
			String query = "INSERT INTO accounts (username, password, email, privilege, firstname, middlename, lastname, salt) VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement pst = db.getConnection().prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, hashedPasswordBase64);
			pst.setString(3, email);
			pst.setString(4, privilegeLevel);
			pst.setString(5, first_name);
			pst.setString(6, middle_name);
			pst.setString(7, last_name);
			pst.setString(8, salt);
			
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
		
		if(filter2.equals("0"))
		{
			try
			{
				System.out.println("I start here");
		        String query = 
		        		"SELECT SUM(p.price * s.quantity) AS 'Total' "
		        		+ "FROM product_sales s , products p, transaction t, accounts a "
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
		else if(filter2.equals("1"))
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
		else if(filter2.equals("2"))
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
		
		if(filter1.equals("1"))
		{
			query =
        		"SELECT a.username AS \"User\", p.category AS \"Product Type\", p.name AS \"Product Name\" "
        		+ ", p.price AS \"Price\", s.quantity AS \"Quantity\", p.price * s.quantity AS \"Total\" "
        		+ "FROM product_sales s , products p, transaction t, accounts a "
        		+ "WHERE s.transaction_id = t.id AND s.product_id = p.id AND t.accounts_id = a.id AND p.category = \"" + filter2 + "\"";
		}
			
		else if(filter1.equals("2"))
		{
			query =
        		"SELECT a.username AS \"User\", p.category AS \"Product Type\", p.name AS \"Product Name\" "
        		+ ", p.price AS \"Price\", s.quantity AS \"Quantity\", p.price * s.quantity AS \"Total\" "
        		+ "FROM product_sales s , products p, transaction t, accounts a "
        		+ "WHERE s.transaction_id = t.id AND s.product_id = p.id AND t.accounts_id = a.id AND p.name = \"" + filter2 + "\"";
		}
		else 
			return null;
		
		try
		{
			System.out.println("I start here");
	        
	        PreparedStatement pst = db.getConnection().prepareStatement(query);			
			pst.setString(1, String.valueOf(filter2));
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

	public static void editProduct(String id, String name, String price,
			String category) {
		db = new DBConnection();
		db.getConnection();
		
		try{
			String query = "UPDATE products SET name = ?, price = ?, category = ? WHERE id = ?";
			PreparedStatement pst = db.getConnection().prepareStatement(query);
			pst.setString(1, name);
			pst.setDouble(2, Double.parseDouble(price));
			pst.setString(3, category);
			pst.setInt(4, Integer.parseInt(id));
	        pst.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void deleteProduct(int id) {
		db = new DBConnection();
		db.getConnection();
		
		try{
			String query = "DELETE FROM products WHERE id=?";
			PreparedStatement pst = db.getConnection().prepareStatement(query);
			pst.setString(1, String.valueOf(id));
	        pst.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void addProduct(String name, String price,
			String category) {
		db = new DBConnection();
		db.getConnection();
		
		try{
			String query = "INSERT INTO products (name, price, category) VALUES (?, ?, ?)";
			PreparedStatement pst = db.getConnection().prepareStatement(query);
			pst.setString(1, name);
			pst.setString(2, price);
			pst.setString(3, category);
	        pst.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Product> getBoughtProducts(int id) {
		db = new DBConnection();
		db.getConnection();
		
		ArrayList<Product> products = new ArrayList<Product>();
		
		try{
	        String query = "SELECT p.id"
	        		+ " FROM accounts a, transaction t, product_sales s, products p"
	        		+ " WHERE t.accounts_id = a.id AND s.transaction_id = t.id AND s.product_id = p.id AND a.id = ?";
	        PreparedStatement pst = db.getConnection().prepareStatement(query);
	        pst.setString(1, String.valueOf(id));
	        ResultSet rs = pst.executeQuery();
	        if(rs.next()){
	        	products.add(Model.getProduct(rs.getInt("p.id")));
	        }
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return products;
	}

	public static void addReview(String review, String productID,
			String accountID) {
		db = new DBConnection();
		db.getConnection();
		
		try{
			String query = "INSERT INTO product_review (product_id, account_id, review) VALUES (?, ?, ?)";
			PreparedStatement pst = db.getConnection().prepareStatement(query);
			pst.setString(1, productID);
			pst.setString(2, accountID);
			pst.setString(3, review);
	        pst.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static int addTransaction(int account_id, double total_price)
	{
		db = new DBConnection();
		db.getConnection();
		int last_inserted_id = -1;
		
		try
		{
			String query = "INSERT INTO transaction (accounts_id, total_price) VALUES (?,?)";
			PreparedStatement pst = db.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, account_id);
			pst.setDouble(2, total_price);
			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();
            if(rs.next())
            {
                last_inserted_id = rs.getInt(1);
            }
			
		} catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return last_inserted_id;
	}
	
	public static void addProductSales(int transaction_id, int product_id, int quantity)
	{
		
		
		String query = "INSERT INTO product_sales (transaction_id, product_id, quantity) VALUES (?,?,?)";
		PreparedStatement pst;
		try 
		{
			pst = db.getConnection().prepareStatement(query);
			pst.setInt(1, transaction_id);
			pst.setInt(2, product_id);
			pst.setInt(3, quantity);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static ResultSet getProductReview(int id)
	{
		db = new DBConnection();
		db.getConnection();
		ArrayList<String> list = new ArrayList<>();
		ResultSet rs = null;
		
		try
		{
			System.out.println("I start here");
	        String query = "SELECT username, review "
	        		+ "FROM products p, product_review r , accounts a "
	        		+ "WHERE r.product_id = p.id AND r.account_id = a.id AND r.product_id = ?";
	        PreparedStatement pst = db.getConnection().prepareStatement(query);
	        pst.setInt(1, id);
	        rs = pst.executeQuery();
//	        while(rs.next())
//	        {
//	        	list.add(rs.getString("review"));
//	        }
	        System.out.println("I end here");
		} catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("EDI PUTA NG PRODUCT");
		}
		
		return rs;
	}
	
	public static ArrayList<Integer> getDate(int id) 
	{
		db = new DBConnection();
		db.getConnection();
		ArrayList<Integer> list = new ArrayList<>();
		
		try{
	        String query = "Select created_date from accounts where id = ?";
	        PreparedStatement pst = db.getConnection().prepareStatement(query);
	        pst.setInt(1, id);
	        ResultSet rs = pst.executeQuery();
	        if(rs.next())
	        {
	        	//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	        	// Year - Month - Day - Hour - Minute - Second
	            Date date = rs.getDate(1);
	            
	            int year = date.getYear();
	            int month = date.getMonth();
	            int day = date.getDate();
	            
	            
	            list.add(year);
	            list.add(month);
	            list.add(day);

	            Time time = rs.getTime(1);
	            int hour = time.getHours();
	            int mins = time.getMinutes();
	            int sec = time.getSeconds();
	            
	            list.add(hour);
	            list.add(mins);
	            list.add(sec);
	            
	            System.out.println("this shit fuck pls  " + year + " " + month + " " + day + " " + hour + " " + mins + " " + sec);
	            
	            //System.out.println("This is the time " + time);
	            //return dateFormat.format(date);
	        	
	        	//list.add(rs.getDate(1).toString());
	        	
	        	
	        	//list.add(rs.getTime(2).toString());
	        	return list;
	        }
	        else return null;
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("EDI PUTA NG DATE");
		}		
		
		return null;
	}
	
	public static void removeAccount(int id) 
	{
		db = new DBConnection();
		db.getConnection();
		
		try
		{
			System.out.println("I start here");
	        String query = "DELETE FROM accounts WHERE id = ?";
	        PreparedStatement pst = db.getConnection().prepareStatement(query);
	        pst.setInt(1, id);
	        pst.executeUpdate();
	        
	        System.out.println("I end here");
		} catch(Exception e) 
		{
			e.printStackTrace();
			System.out.println("EDI PUTA Remove Account");
		}
	}
	
}
