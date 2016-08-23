package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;
import model.Product;
import model.Transaction;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
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

        HttpSession session = request.getSession();
        
        if(session.getAttribute("cart_items")==null){
        	session.setAttribute("cart_items", new ArrayList<Transaction>());
        }
        
        ArrayList<Transaction> cart_items = (ArrayList<Transaction>) session.getAttribute("cart_items");
        int id = Integer.valueOf(request.getParameter("productID"));
        int quantity = Integer.valueOf(request.getParameter("quantity"));
        Product prod = Model.getProduct(id);
        Transaction tran = new Transaction(quantity, prod) ;
        
        cart_items.add(tran);
        session.setAttribute("cart_items", cart_items);

		response.sendRedirect("index.jsp");
	}

}
