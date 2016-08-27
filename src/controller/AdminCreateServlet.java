package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.owasp.encoder.Encode;
import org.owasp.encoder.Encoder;

import model.Account;
import model.Model;

/**
 * Servlet implementation class AdminCreateServlet
 */
@WebServlet("/AdminCreateServlet")
public class AdminCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");   
        String password = request.getParameter("password");
        String privLevel = request.getParameter("accType");

        if(!Model.checkIfUsernameExists(username))
		{
			Model.createAccount(username, password, privLevel);
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		} 
		else 
		{
			request.setAttribute("creationStatus", "Account with that username already exists");
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		}
	}

}
