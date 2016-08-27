<%@ page import="model.Account" %>
<%
	Account account = (Account)session.getAttribute("user_account");
   if ((session.getAttribute("user_account") != null) ){ 
		if(account.getPrivilegeLevel().equals("1") ){
			response.sendRedirect("results_page.jsp");
		}else if(account.getPrivilegeLevel().equals("2") ){
			response.sendRedirect("product_manager_view.jsp");
		}else if(account.getPrivilegeLevel().equals("3") ){
			response.sendRedirect("accounting.jsp");
		}else if(account.getPrivilegeLevel().equals("4") ){
			response.sendRedirect("admin.jsp");
		}
	} else { 
		response.sendRedirect("results_page.jsp"); 
	} %>