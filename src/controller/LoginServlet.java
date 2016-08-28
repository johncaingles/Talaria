package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.Model;
import model.Product;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");   
        String password = request.getParameter("password");
        boolean ifDelete = false;        
        if(Model.checkCredentials(username, password))
		{
			int accountID = Model.getAccountID(username);
			Account account = new Account(accountID);
			account.setUsername(username);
//			account.setName(Model.getAccountName(accountID));
			account.setPrivilegeLevel(Model.getPrivilegeLevel(accountID));
			//logging
			Logger lg = new Logger();
			lg.log(username, "Logged in");
			
			
			if(account.getPrivilegeLevel().equals("2") || account.getPrivilegeLevel().equals("3"))
			{
				
				ArrayList<Integer> date = Model.getDate(accountID);
				Date tempDate = new Date(date.get(0), date.get(1), date.get(2), date.get(3), date.get(4), date.get(5));
//				System.out.println("Temp date is this " + tempDate);
				Date currDate = new Date();
//				System.out.println("Curr date is this " + currDate);
				long MILLIS_PER_DAY = 24 * 60 * 60 * 1000L;
				boolean moreThanDay = Math.abs(currDate.getTime() - tempDate.getTime()) > MILLIS_PER_DAY;
				
				System.out.println(moreThanDay);
				if(moreThanDay)
				{
					Model.removeAccount(accountID);
					ifDelete = true;
				}
			}
	      
          if(ifDelete)
          {
        	  response.sendRedirect("index.jsp");
          }
          else
          {
        	  HttpSession session = request.getSession();
              session.setAttribute("user_account", account);
              System.out.println("KANTOTAN: " +account.getPrivilegeLevel());
              System.out.println("KANTOTAN2: " +account.getAccountID());
        	  
        	  switch(account.getPrivilegeLevel())
        	  {
		          case "1": response.sendRedirect("index.jsp");break;
		          case "2": response.sendRedirect("product_manager_view.jsp");break;
		          case "3": response.sendRedirect("accounting.jsp");break;
		          case "4": response.sendRedirect("admin.jsp");break;
        	  }
          }	  
        }     
    	else 
  		{
  		   response.sendRedirect("index.jsp");
  		}
			
			
	//			rd.forward(request, response);
			//response.sendRedirect("results.jsp");
//          Cookie idCookie = new Cookie("user_id", String.valueOf(account.getAccountID()));
//          Cookie nameCookie = new Cookie("user_name", String.valueOf(account.getName()));
//          //setting cookie to expiry in 30 mins
//          idCookie.setMaxAge(30 * 60);
//          nameCookie.setMaxAge(30 * 60);
          
//          response.addCookie(idCookie);
//          response.addCookie(nameCookie);
		 
		
        
//        else if (account != null)
//        {
//            Cookie idCookie = new Cookie("user_id", String.valueOf(account.getUser_id()));
//            Cookie nameCookie = new Cookie("user_name", String.valueOf(account.getFullName()));
//            //setting cookie to expiry in 30 mins
//            HttpSession session = request.getSession();
//            session.setAttribute("userAccount", account);
//            idCookie.setMaxAge(30 * 60);
//            nameCookie.setMaxAge(30 * 60);
//            response.addCookie(idCookie);
//            response.addCookie(nameCookie);
//            response.sendRedirect("index.jsp");
//        }
//        
//        else if (org != null)
//        {
//            HttpSession session = request.getSession();
//            session.setAttribute("admin", org);
//            response.sendRedirect("admin.jsp");
//        }
	}

}
