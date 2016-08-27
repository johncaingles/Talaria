package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			deleteProduct(response, productID);
		}
	}

	private void deleteProduct(HttpServletResponse response, int productID) throws IOException {
		
		Model.deleteProduct(productID);
		
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
		
		response.sendRedirect("product_manager_view.jsp");
	}

}
