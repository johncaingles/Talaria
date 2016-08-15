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
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("product_id"));   
        String name = Model.getProduct(id).getName();
        double price = Model.getProduct(id).getPrice();
        String category = Model.getProduct(id).getCategory();
		
		Product sendProduct = new Product( id, name , price , category );
        request.setAttribute("sendProduct", sendProduct);
        
        request.getRequestDispatcher("product.jsp").forward(request, response);
     
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public void initProductView(){
		
	}

}
