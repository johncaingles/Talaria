package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Model;
import model.RecordType0;
import model.RecordType1;

/**
 * Servlet implementation class FinanceRecordServlet
 */
@WebServlet("/FinanceRecordServlet")
public class FinanceRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinanceRecordServlet() {
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
		
		String filter1 = request.getParameter("filter1");
        String filter2_1 = request.getParameter("f1");
        String filter2_2 = request.getParameter("f2");
        String filter2_3 = request.getParameter("f3");
        ArrayList<RecordType0> real_list0 = null;
        ArrayList<RecordType1> real_list1 = null;
        String type = null;
        
        System.out.println("I AM FILTER: "+filter1);
        if(filter1.equals("0"))
        {
        	System.out.println("IAM PASOK ANO");
        	ArrayList<RecordType0> list = new ArrayList();
        	list = Model.getFinanceRecordsType0(filter2_1);
        	real_list0 = list;
        	type = "0";
        	request.setAttribute("list", real_list0);
        }
        else if(filter1.equals("1") || filter1.equals("2"))
        {
        	ArrayList<RecordType1> list = new ArrayList();
        	list = Model.getFinanceRecordsType1(filter1, filter2_2);
        	real_list1 = list;
        	type = "1";
        	request.setAttribute("list", real_list1);
        }
        
		
		request.setAttribute("type", type);
        
		request.getRequestDispatcher("accounting.jsp").forward(request, response);
	}

}
