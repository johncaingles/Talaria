package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

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

//		response.setContentType("text/plain");
//		String sex = request.getParameter("password");
//		PrintWriter out = response.getWriter();
//		out.print("hi: " + sex);

        String username = request.getParameter("username");   
        String password = request.getParameter("password");
        
        String sendThis = "This is sent yo";
        
        request.setAttribute("sendThis", sendThis);
//        RequestDispatcher rd = getServletContext()
//                .getRequestDispatcher("results.jsp");
        
        
		if(Model.checkCredentials(username, password))
		{
			request.getRequestDispatcher("results.jsp").forward(request, response);
//			rd.forward(request, response);
			//response.sendRedirect("results.jsp");
		} 
		else 
		{
		   response.sendRedirect("index.jsp");
		}
        
        
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
