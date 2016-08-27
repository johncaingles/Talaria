package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.Model;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		String first_name = request.getParameter("first_name"); 
		String middle_name = request.getParameter("middle_name"); 
		String last_name = request.getParameter("last_name"); 
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String bil_house_num = request.getParameter("bil_house_num");
		String bil_street = request.getParameter("bil_street");
		String bil_subdivision = request.getParameter("bil_subdivision");
		String bil_city = request.getParameter("bil_city");
		String bil_postal_code = request.getParameter("bil_postal_code");
		String bil_country = request.getParameter("bil_country");
		
		String ship_house_num = request.getParameter("ship_house_num");
		String ship_street = request.getParameter("ship_street");
		String ship_subdivision = request.getParameter("ship_subdivision");
		String ship_city = request.getParameter("ship_city");
		String ship_postal_code = request.getParameter("ship_postal_code");
		String ship_country = request.getParameter("ship_country");
		
		if(Model.addCustAccount(username, password, first_name, middle_name, last_name, email, "1", bil_house_num, bil_street, bil_subdivision, bil_city, bil_postal_code, bil_country, ship_house_num, ship_street, ship_subdivision, ship_city, ship_postal_code, ship_country))
		{
			Account account = new Account(username, first_name, middle_name, last_name, email, "1", bil_house_num, bil_street, bil_subdivision, bil_city, bil_postal_code, bil_country, ship_house_num, ship_street, ship_subdivision, ship_city, ship_postal_code, ship_country);
			
			HttpSession session = request.getSession();
	        session.setAttribute("user_account", account);
	        System.out.println("Inside servlet customer sucess");
	        
			response.sendRedirect("index.jsp");
		}
		else
		{
			System.out.println("Inside servlet customer fail");
			response.sendRedirect("registration.jsp");
		}
		
		
	}

}
