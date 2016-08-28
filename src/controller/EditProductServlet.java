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
 * Servlet implementation class EditProductServlet
 */
@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if(method.equals("deleteProduct")){
			int productID = Integer.parseInt(request.getParameter("productID"));
			deleteProduct(request, response, productID);
		}
	}

	private void deleteProduct(HttpServletRequest request, HttpServletResponse response, int productID) throws IOException {
		
		Model.deleteProduct(productID);
		HttpSession session = request.getSession();
		/** LOG */
		Account account = (Account)session.getAttribute("user_account");
		String user_name = account.getUsername();
		Logger lg = new Logger();
		lg.log(user_name, "deleted product " + productID);
		/** LOG */
		session.setAttribute("notif", "Successfully deleted a product!");
		response.sendRedirect("product_manager_view.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("product_id");
		String name = request.getParameter("product_name");
		String price = request.getParameter("product_price");
		String category = request.getParameter("product_category");
		
		Model.editProduct(id, name, price, category);
		/** LOG */
		HttpSession session = request.getSession();
		Account account = (Account)session.getAttribute("user_account");
		String user_name = account.getUsername();
		Logger lg = new Logger();
		lg.log(user_name, "Edited product" + id);
		/** LOG */
		session.setAttribute("notif", "Successfully edited " + Model.getProduct(Integer.valueOf(id)).getName() + " !");
		response.sendRedirect("product_manager_view.jsp");
	}

}
