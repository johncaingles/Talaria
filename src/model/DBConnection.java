package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection
{
private String url, username, password;
private boolean connectionStatus=false;
private Connection connection;
private static DBConnection instance;
    
    public  DBConnection()
    {
        this.username="root";
        this.password="password";
        this.url="jdbc:mysql://localhost:3306/Talaria";   

            try 
            {
                Class.forName("com.mysql.jdbc.Driver");
                connection= DriverManager.getConnection(url, username, password);
                connectionStatus=true;
            } catch (Exception e) 
            {
               System.out.println("Unable to connect to db");
            }
    }

    public boolean getConnectionStatus()
    {
        return this.connectionStatus;
    }

    public Connection getConnection() 
    {
        return this.connection;
    }

    public static DBConnection getInstance() 
    {
		if(instance == null) 
                    instance = new DBConnection();
		
        return instance;
    }
    
    public void close()
    {
    	try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}