<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page import="model.Model" %>
<%@page import="java.util.HashMap"%>
<%@page import="org.apache.commons.lang.StringUtils" %>
<%@ page import="org.owasp.encoder.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

	<jsp:include page="dependencies.jsp" />

<script>function loadData(){
    $.ajax({
        url:'ResultServlet',
       success: function(response){
                        $("#test").text(response);
            //myDiv is the id of element in which the server data is to be shown
       }
   });
}</script>
<head>
<body>

	<jsp:include page="nav-bar.jsp" />
	
	<h1 class="center">RESULTS</h1>
	
	
	
<%-- 	<c:forEach var="element" items="${sendThis}"> --%>
<%--         <c:out value="${element}"/> --%>
<%--     </c:forEach> --%>
    
<!--     <input type="button" value="click to load db" onclick="loadData();"/> -->
    <div class="container">
    		
    		<nav>
		    <div class="nav-wrapper">
		      <form action="ResultServlet" method="get">
		        <div class="input-field" style="height: 64px" >
		          <input id="search" name="search" type="search">
		          <label for="search"><i class="material-icons">search</i></label>
		          <i class="material-icons">close</i>
		        </div>
		      </form>
		    </div>
		  </nav>
	    	
		    <div class="row">
		    <div class="col s12">
		      <ul class="tabs">
		        <li class="tab col s3"><a onclick="Materialize.showStaggeredList('#boots_list')" href="#boots_cards">Boots</a></li>
		        <li class="tab col s3"><a onclick="Materialize.showStaggeredList('#shoes_list')" href="#shoes_cards">Shoes</a></li>
		        <li class="tab col s3"><a onclick="Materialize.showStaggeredList('#sandals_list')" href="#sandals_cards">Sandals</a></li>
		        <li class="tab col s3"><a onclick="Materialize.showStaggeredList('#slippers_list')" href="#slippers_cards">Slippers</a></li>
		      </ul>
		    </div>
		  </div>
		  
		  
		  <%	
		HashMap<String, ArrayList<Product>> listCategorizedProducts = new HashMap<String, ArrayList<Product>>();
        listCategorizedProducts = Model.getProductsHash();
        
        if(request.getAttribute("search")==null){
        	request.setAttribute("search", "");
        	System.out.println("KANTOTAN");
        }
        String search = (String)request.getAttribute("search");
		%>
		
		  <div class="row" id="boots_cards">
		  	<ul id="boots_list">
		    <% for (Product product : listCategorizedProducts.get("boots")) { %>
		    <% if(StringUtils.containsIgnoreCase(Encode.forHtml(product.getName()), search)){ %>
		    <li>
		    <form class="card" method="get" action="">
								
							<input type="hidden" name="product_id" value="">
							
								<div class="col s4">
							        <div class="card " style="overflow: hidden;">
						              <div class="card-image waves-effect waves-block waves-light"  >
						                <a href="/Talaria/ProductViewServlet?method=initProductView&productID=<% out.print(product.getProd_id()); %>"><img class="activator" src="img/shoe_0.jpg"></a>
						                <span class="card-title"><% out.print(Encode.forHtml(product.getName())); %></span>
						              </div>
						              <div class="card-content">
						                <span class="card-title activator grey-text text-darken-4"><% out.print(product.getPrice()); %>
						                		<i class="material-icons right" >more_vert</i>
						                </span>
		
						              </div>
						              <div class="card-action">
							              <a href="/Talaria/ProductViewServlet?method=initProductView&productID=<% out.print(product.getProd_id()); %>">See Product</a>
						           	 </div>
	       				            </div>
				            </div>
			            </form>
			            </li>
	            	<% } %> 
	            <% } %>
	            </ul>
            </div>
            
            <div class="row" id="shoes_cards">
		  	<ul id="shoes_list">
	    <% for (Product product : listCategorizedProducts.get("shoes")) { %>
		    <% if(StringUtils.containsIgnoreCase(Encode.forHtml(product.getName()), search)){ %>
		    <li>
		    <form class="card" method="get" action="">
								
							<input type="hidden" name="product_id" value="">
							
								<div class="col s4">
							        <div class="card " style="overflow: hidden;">
						              <div class="card-image waves-effect waves-block waves-light"  >
						                <a href="/Talaria/ProductViewServlet?method=initProductView&productID=<% out.print(product.getProd_id()); %>"><img class="activator" src="img/shoe_0.jpg"></a>
						                <span class="card-title"><% out.print(Encode.forHtml(product.getName())); %></span>
						              </div>
						              <div class="card-content">
						                <span class="card-title activator grey-text text-darken-4"><% out.print(product.getPrice()); %>
						                		<i class="material-icons right" >more_vert</i>
						                </span>
		
						              </div>
						              <div class="card-action">
							              <a href="/Talaria/ProductViewServlet?method=initProductView&productID=<% out.print(product.getProd_id()); %>">See Product</a>
						           	 </div>
	       				            </div>
				            </div>
			            </form>
			            </li>
	            	<% } %> 
            <% } %>
            </ul>
            </div>
            
            <div class="row" id="sandals_cards">
		  	<ul id="sandals_list">
	    <% for (Product product : listCategorizedProducts.get("sandals")) { %>
		    <% if(StringUtils.containsIgnoreCase(Encode.forHtml(product.getName()), search)){ %>
		    <li>
		    <form class="card" method="get" action="">
								
							<input type="hidden" name="product_id" value="">
							
								<div class="col s4">
							        <div class="card " style="overflow: hidden;">
						              <div class="card-image waves-effect waves-block waves-light"  >
						                <a href="/Talaria/ProductViewServlet?method=initProductView&productID=<% out.print(product.getProd_id()); %>"><img class="activator" src="img/shoe_0.jpg"></a>
						                <span class="card-title"><% out.print(Encode.forHtml(product.getName())); %></span>
						              </div>
						              <div class="card-content">
						                <span class="card-title activator grey-text text-darken-4"><% out.print(product.getPrice()); %>
						                		<i class="material-icons right" >more_vert</i>
						                </span>
		
						              </div>
						              <div class="card-action">
							              <a href="/Talaria/ProductViewServlet?method=initProductView&productID=<% out.print(product.getProd_id()); %>">See Product</a>
						           	 </div>
	       				            </div>
				            </div>
			            </form>
			            </li>
	            	<% } %> 
            <% } %>
            </ul>
            </div>
            
    	<div class="row" id="slippers_cards">
		  	<ul id="slippers_list">
    	<% for (Product product : listCategorizedProducts.get("slippers")) { %>
		    <% if(StringUtils.containsIgnoreCase(Encode.forHtml(product.getName()), search)){ %>
		    <li>
		    <form class="card" method="get" action="">
								
							<input type="hidden" name="product_id" value="">
							
								<div class="col s4">
							        <div class="card " style="overflow: hidden;">
						              <div class="card-image waves-effect waves-block waves-light"  >
						                <a href="/Talaria/ProductViewServlet?method=initProductView&productID=<% out.print(product.getProd_id()); %>"><img class="activator" src="img/shoe_0.jpg"></a>
						                <span class="card-title"><% out.print(Encode.forHtml(product.getName())); %></span>
						              </div>
						              <div class="card-content">
						                <span class="card-title activator grey-text text-darken-4"><% out.print(product.getPrice()); %>
						                		<i class="material-icons right" >more_vert</i>
						                </span>
		
						              </div>
						              <div class="card-action">
							              <a href="/Talaria/ProductViewServlet?method=initProductView&productID=<% out.print(product.getProd_id()); %>">See Product</a>
						           	 </div>
	       				            </div>
				            </div>
			            </form>
			            </li>
	            	<% } %> 
		            <% } %>
            </ul>
            </div>
     </div>

    
    <div id="test"></div>
</body>
</html>