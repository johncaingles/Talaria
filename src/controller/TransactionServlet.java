package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.Model;
import model.Product;
import model.Transaction;

/**
 * Servlet implementation class TransactionServlet
 */
@WebServlet("/TransactionServlet")
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionServlet() {
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
		ArrayList<Transaction> cartItems = (ArrayList<Transaction>)request.getSession().getAttribute("cart_items");
		Account currAcc = (Account) request.getSession().getAttribute("user_account");
		int quantity = 0;
		if(currAcc==null){
			System.out.println("POTANGINAMOPAKSHET");
		}
		double total = 0;
		int transaction_id, i, j, currProd, ctrProd = 0, mstrProd;
		
		for(i = 0; i < cartItems.size(); i++)
		{
			total += cartItems.get(i).getProd().getPrice() * cartItems.get(i).getQuantity();
			quantity  += 1*cartItems.get(i).getQuantity();
		}
		
		transaction_id = Model.addTransaction(currAcc.getAccountID(), total);
		
		for(i = 0 ; i < cartItems.size(); i++)
		{
			Model.addProductSales(transaction_id, cartItems.get(i).getProd().getProd_id(), cartItems.get(i).getQuantity());
		}
		
		
		//transaction_id = Model.getTransactionId();
		
//		i = 0;
//		j = 0;
		//mstrProd = cartItems.get(i).getProd_id();
		/*
		for(i = 0; i < cartItems.size(); i ++)
		{
			for(j = 0; j < cartItems.size(); j ++)
			{
				System.out.println("Inside WHILE");
				currProd = cartItems.get(j).getProd_id();
				
				if(mstrProd == currProd && j < cartItems.size())
				{
					System.out.println("Inside IF");
					j++;
					ctrProd++;
				}
				else
				{
					System.out.println("Adding in product sales");
					Model.addProductSales(transaction_id, cartItems.get(i).getProd_id(), ctrProd);
					i = j;
					mstrProd = cartItems.get(i).getProd_id();
					ctrProd = 0;
				}
			}
		}
		Model.addProductSales(transaction_id, cartItems.get(i).getProd_id(), ctrProd);
		*/
		/*
		do
		{
			System.out.println("Inside WHILE");
			currProd = cartItems.get(j).getProd_id();
			if(mstrProd == currProd && j < cartItems.size())
			{
				System.out.println("Inside IF");
				j++;
				ctrProd++;
			}
			else
			{
				System.out.println("Adding in product sales");
				Model.addProductSales(transaction_id, cartItems.get(i).getProd_id(), ctrProd);
				i = j;
				mstrProd = cartItems.get(i).getProd_id();
				ctrProd = 0;
			}
		}
		while(j < cartItems.size());
		Model.addProductSales(transaction_id, cartItems.get(i).getProd_id(), ctrProd);
		*/
		/** LOG */
		HttpSession session = request.getSession();
		Account account = (Account)session.getAttribute("user_account");
		String user_name = account.getUsername();
		Logger lg = new Logger();
		lg.log(user_name, "made transaction " + transaction_id);
		/** LOG */

		session.setAttribute("notif", "Successfully bought " + quantity + " items!");
		cartItems = new ArrayList<Transaction>();
		session.setAttribute("cart_items", cartItems);
		response.sendRedirect("index.jsp");
		
	}

}
