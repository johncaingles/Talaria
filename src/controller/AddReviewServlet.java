package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.owasp.encoder.Encode;

import model.Account;
import model.Model;

/**
 * Servlet implementation class AddReviewServlet
 */
@WebServlet("/AddReviewServlet")
public class AddReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReviewServlet() {
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
		String review = request.getParameter("review");
		String productID = request.getParameter("product_id");
		
		HttpSession session = request.getSession();
		String accountID = String.valueOf(((Account)(request.getSession().getAttribute("user_account"))).getAccountID());
		
		Model.addReview(review, productID, accountID);
		
		response.sendRedirect("bought_items.jsp");
		
		Account account = (Account)session.getAttribute("user_account");
		String user_name = account.getUsername();
		Logger lg = new Logger();
		lg.log(user_name, "added Review for" + productID);
	}

}
