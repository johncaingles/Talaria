<%@ page import="model.Account" %>
<%   if ((session.getAttribute("user_account") != null) ){ %>
<%		if(((Account)session.getAttribute("user_account")).getPrivilegeLevel().equals("3")){ %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Model" %>
<%@page import="model.RecordType0" %>
<%@page import="model.RecordType1" %>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accounting Panel</title>

	<jsp:include page="dependencies.jsp" />
<script type="text/javascript">
//     function show() {
//         var selopt = document.getElementById("filter1").value;
//         if (selopt == 1) {
//             document.getElementById("f1").style.display = "block";
//             document.getElementById("f2").style.display = "none";
//             document.getElementById("btn").style.display = "block";
//         }
//         if (selopt == 2) {
//             document.getElementById("f2").style.display = "block";
//             document.getElementById("f1").style.display = "none";

    function show() 
    {
        var select = document.getElementById("filter1").value;
        if (select == 0) {
            document.getElementById("f1").style.display = "block";
            document.getElementById("f2").style.display = "none";
            document.getElementById("f3").style.display = "none";
            document.getElementById("btn").style.display = "block";
        }
        if (select == 1) {
            document.getElementById("f2").style.display = "block";
            document.getElementById("f1").style.display = "none";
            document.getElementById("f3").style.display = "none";
            document.getElementById("btn").style.display = "block";
        }
        if (select == 2) {
            document.getElementById("f3").style.display = "block";
            document.getElementById("f1").style.display = "none";
            document.getElementById("f2").style.display = "none";
            document.getElementById("btn").style.display = "block";
        }
    }
    
    function showTable(num) {
        document.getElementById("table").style.display = "inline-table";
    }
</script>
</head>
<body>

	<jsp:include page="nav-bar.jsp" />
	
	<h1 class="center">Hello, Accounting Manager. </h1> 
	<h6 class="center">Hail Hydra!</h6>
    <div class="container">
	    	
		    <div class="row">
		    	<form action="FinanceRecordServlet" method="post">
			    <div class="input-field col s12">
			    	<div class="col s5">
				      <select id="filter1" name="filter1" onchange="show()">
					      <option value="" disabled selected>Filter by...</option>
					      <option value="0">Total sales</option>
					      <option value="1">Sales per product type</option>
					      <option value="2">Sales per product</option>
					  </select>
				  	</div>
				  	
				  	<div id="f1" class="col s5" style="display:none">
				      <select name="f1" onchange="showTable()">
					      <option value="0">All sales</option>
					      <option value="1">Per product type</option>
					      <option value="2">Per product</option>
					  </select>
				  	</div>
				  	
				  	<div id="f2" class="col s5" style="display:none">
				      <select name="f2" onchange="showTable()">
					      <option value="boots">Boots</option>
					      <option value="shoes">Shoes</option>
					      <option value="sandals">Sandals</option>
					      <option value="slippers">Slippers</option>
					  </select>
				  	</div>
				  	
				  	<div id="f3" class="col s5" style="display:none">
				      <select name="f3" onchange="showTable()">
				      	  <% for(String name : Model.getAllProductNames()){ %>
				      	  	<option value="<% out.print(name); %> "><% out.print(name); %></option>
				      	  <% } %>					      
					  </select>
				  	</div>
				  	
				  	<div id="btn" class="col s2" style="display:none">
				      <button type="submit" class="btn-large red lighten-1" onclick="showTable()">Show</button>
				  	</div>
				</div>
				</form>
		  	</div>
		<div class="row">
			<table id="table" class="striped" style="">
			<% if(request.getAttribute("list")!=null){ System.out.println("pakyuol"); 
				if(request.getAttribute("type").equals("0")){ System.out.println("pakyuol2");%>
				<!-- <h1>iyak</h1>  -->
				<!--  di siya nagsshow kasi sa pag-initialize ng page, may mga hinihide ata -->
		        <thead>
		          <tr>
		              <th>Category</th>
		              <th>Item Price</th>
		          </tr>
		        </thead>
		
		        <tbody>
		          <% ArrayList<RecordType0> list = (ArrayList<RecordType0>)request.getAttribute("list"); %>
 		          <% for(RecordType0 record : list ){ %>
 		          <tr> 
 		            <td><% out.print(record.getCategory_type()); %></td>
 		            <td><% out.print(record.getTotal_price()); %></td>
 		          </tr>
 		          <% } %>
		        </tbody>
		        <% } else { %>
		        	<thead>
		          <tr>
		              <th>Category</th>
		              <th>Item Price</th>
		          </tr>
		        </thead>
		
		        <tbody>
		          <% ArrayList<RecordType1> list = (ArrayList<RecordType1>)request.getAttribute("list"); %>
 		          <% for(RecordType1 record : list ){ %>
 		          <tr> 
 		            <td><% out.print(record.getUsername()); %></td>
 		            <td><% out.print(record.getProduct_Type()); %></td>
 		            <td><% out.print(record.getProduct_name()); %></td>
 		            <td><% out.print(record.getPrice()); %></td>
 		            <td><% out.print(record.getQuantity()); %></td>
 		            <td><% out.print(record.getTotal()); %></td>
 		          </tr>
 		          <% } %>
		        </tbody>
				<% } %>
			<% } %>
	      </table>
      </div>
	</div>
</body>
</html>
<% }} else { %> <jsp:include page="forbidden.jsp" /> <% } %>