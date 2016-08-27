package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Model;
import model.Product;

/**
 * Servlet implementation class ProductViewServlet
 */
@WebServlet("/ProductViewServlet")
public class ProductViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String method = request.getParameter("method");
		if(method.equals("initProductView")){
			int productID = Integer.parseInt(request.getParameter("productID"));
			System.out.println("KANTOT: " + productID);
			initProductView(request, response, productID);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public void initProductView(HttpServletRequest request, HttpServletResponse response, int productID) throws ServletException, IOException {
		   
        String name = Model.getProduct(productID).getName();
        double price = Model.getProduct(productID).getPrice();
        String category = Model.getProduct(productID).getCategory();
		
		Product product = new Product( productID, name , price , category );
        request.setAttribute("product", product);
        System.out.println("MAX CHICKEN YUM");
        request.getRequestDispatcher("product.jsp").forward(request, response);
     
	}

}
