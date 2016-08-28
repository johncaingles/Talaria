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
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
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
		String oldPw = request.getParameter("old_password");
		String newPw = request.getParameter("new_password");
		String confNewPw = request.getParameter("confirm_new_password");

        HttpSession session = request.getSession();
		Account account = (Account)session.getAttribute("user_account");
		String user_name = account.getUsername();
		
		if(Model.checkCredentials(user_name, oldPw)){
			if( newPw.equals(confNewPw)){
				Model.updateAccountPassword(account.getAccountID(), newPw);
				session.setAttribute("notif", "Successfully changed password!");
				response.sendRedirect("index.jsp");
			}
			else session.setAttribute("notif", "Confirmation of new password did not match!");
		}
		else {
			session.setAttribute("notif", "Old password did not match!");
			response.sendRedirect("change_password.jsp");
		}
		
		/** LOG */
		Logger lg = new Logger();
		lg.log(user_name, "changed password");
		/** LOG */
	}

}
