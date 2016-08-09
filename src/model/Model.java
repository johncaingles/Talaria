package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

}
