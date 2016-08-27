<%@ page import="model.Account" %>
<%   if ((session.getAttribute("user_account") != null) ){ %>
<%		if(((Account)session.getAttribute("user_account")).getPrivilegeLevel().equals("2")){ %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page import="model.Model" %>
<%@page import="java.util.HashMap"%>
<%@ page import="org.owasp.encoder.Encode" %>
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
	
	<h1 class="center">Hello, Product Manager. </h1> 
	<h6 class="center">Hail Hydra!</h6>
	
<%-- 	<c:forEach var="element" items="${sendThis}"> --%>
<%--         <c:out value="${element}"/> --%>
<%--     </c:forEach> --%>
    
<!--     <input type="button" value="click to load db" onclick="loadData();"/> -->
    <div class="container">
    		
    	<div class="row">
    		<nav class="col m9">
		    <div class="nav-wrapper">
		      <form>
		        <div class="input-field" style="height: 64px" >
		          <input id="search" type="search" required>
		          <label for="search"><i class="material-icons">search</i></label>
		          <i class="material-icons">close</i>
		        </div>
		      </form>
		    </div>
		  </nav>
		  	
		  	<div class="col m3">
	    		<a class="waves-effect waves-light btn modal-trigger light-red lighten-1 col s12" href="#add_product_modal">Add Product</a>
	    		<div id="add_product_modal" class="modal">
				            <div class="modal-content">
					        	<div class="col s12">
					        		<h4> Add New Product Info</h4>
					                <form action="AddProductServlet" method="post">
					                    <div class="input-field col s12">
					                        <input name="product_name" value="" id="product_name" type="text" class="validate">
					                        <label class="active" for="product_name">Name</label>
					                    </div>
					                    <div class="input-field col m12">
					                        <input name="product_price" value="" id="product_price" type="text" class="validate">
					                        <label class="active" for="product_price">Price</label>
					                    </div>
					                    <div class="input-field col s12">
										    <select name="product_category">
										      <option value="" disabled selected>Select Category</option>
										      <option value="boots">Boots</option>
										      <option value="shoes">Shoes</option>
										      <option value="sandals">Sandals</option>
										      <option value="slippers">Slippers</option>
										    </select>
										    <label>Category</label>
										  </div>
					                    <button class="btn waves-effect waves-light blue" type="submit">Apply
					                        <i class="material-icons right">send</i>
					                    </button>
					                </form>
					        	</div>
					        </div>
					        <div class="modal-footer">
						      <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Cancel</a>
						    </div>
				        </div>
	    		</div>
	    	</div>
	    	
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
        
        System.out.println(listCategorizedProducts.get("boots").get(0).getName());
        
		%>
		
		  <div class="row" id="boots_cards">
		  	<ul id="boots_list">
		    <% for (Product product : listCategorizedProducts.get("boots")) { %>
		    <li>
		    <form class="card" method="get" action="">
								
							<input type="hidden" name="product_id" value="">
							
								<div class="col s4">
							        <div class="card " style="overflow: hidden;">
						              <div class="card-image waves-effect waves-block waves-light"  >
						                <a href="#product_modal_<% out.print(product.getProd_id()); %>" class="modal-trigger"><img class="activator" src="img/shoe_0.jpg"></a>
						                <span class="card-title"><% out.print(Encode.forHtml(product.getName())); %></span>
						              </div>
						              <div class="card-content">
						                <span class="card-title activator grey-text text-darken-4">$<% out.print(product.getPrice()); %>
						                </span>
						                <p>Category: <% out.print(product.getCategory().substring(0, 1).toUpperCase() + product.getCategory().substring(1)); %>
						              </div>
						              <div class="card-action">
							              <a href="#product_modal_<% out.print(product.getProd_id()); %>" class="modal-trigger">Edit Product</a>
							              <a href="/Talaria/EditProductServlet?method=deleteProduct&productID=<% out.print(product.getProd_id()); %>">Delete Product</a>
						           	 </div>
	       				            </div>
				            </div>
			            </form>
			            </li>
			            <div id="product_modal_<% out.print(product.getProd_id()); %>" class="modal">
				            <div class="modal-content">
					        	<div class="col s12">
					        		<h4> Make changes </h4>
					                <form action="EditProductServlet" method="post">
					                <input type="hidden" name="product_id" value="<% out.print(product.getProd_id()); %>">
					                    <div class="input-field col s12">
					                        <input name="product_name" value="<% out.print(Encode.forHtml(product.getName())); %>" id="product_name" type="text" class="validate">
					                        <label class="active" for="product_name">Name</label>
					                    </div>
					                    <div class="input-field col m12">
					                        <input name="product_price" value="<% out.print(product.getPrice()); %>" id="product_price" type="text" class="validate">
					                        <label class="active" for="product_price">Price</label>
					                    </div>
					                    <div class="input-field col s12">
										    <select name="product_category">
										      <option value="<% out.print(product.getCategory()); %>" disabled selected>Select Category</option>
										      <option value="boots">Boots</option>
										      <option value="shoes">Shoes</option>
										      <option value="sandals">Sandals</option>
										      <option value="slippers">Slippers</option>
										    </select>
										    <label>Category</label>
										  </div>
					                    <button class="btn waves-effect waves-light blue" type="submit">Apply
					                        <i class="material-icons right">send</i>
					                    </button>
					                </form>
					        	</div>
					        </div>
					        <div class="modal-footer">
						      <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Cancel</a>
						    </div>
				        </div>
	            <% } %>
	            </ul>
            </div>
            
            <div class="row" id="shoes_cards">
		  	<ul id="shoes_list">
	    <% for (Product product : listCategorizedProducts.get("shoes")) { %>
		    <li>
		    <form class="card" method="get" action="">
								
							<input type="hidden" name="product_id" value="">
							
								<div class="col s4">
							        <div class="card " style="overflow: hidden;">
						              <div class="card-image waves-effect waves-block waves-light"  >
						                <a href="#product_modal_<% out.print(product.getProd_id()); %>" class="modal-trigger"><img class="activator" src="img/shoe_0.jpg"></a>
						                <span class="card-title"><% out.print(Encode.forHtml(product.getName())); %></span>
						              </div>
						              <div class="card-content">
						                <span class="card-title activator grey-text text-darken-4">$<% out.print(product.getPrice()); %>
						                </span>
						                <p>Category: <% out.print(product.getCategory().substring(0, 1).toUpperCase() + product.getCategory().substring(1)); %>
						              </div>
						              <div class="card-action">
							              <a href="#product_modal_<% out.print(product.getProd_id()); %>" class="modal-trigger">Edit Product</a>
							              <a href="/Talaria/EditProductServlet?method=deleteProduct&productID=<% out.print(product.getProd_id()); %>">Delete Product</a>
						           	 </div>
	       				            </div>
				            </div>
			            </form>
			            </li>
			            <div id="product_modal_<% out.print(product.getProd_id()); %>" class="modal">
				            <div class="modal-content">
					        	<div class="col s12">
					        		<h4> Make changes </h4>
					                <form action="EditProductServlet" method="post">
					                <input type="hidden" name="product_id" value="<% out.print(product.getProd_id()); %>">
					                    <div class="input-field col s12">
					                        <input name="product_name" value="<% out.print(Encode.forHtml(product.getName())); %>" id="product_name" type="text" class="validate">
					                        <label class="active" for="product_name">Name</label>
					                    </div>
					                    <div class="input-field col m12">
					                        <input name="product_price" value="<% out.print(product.getPrice()); %>" id="product_price" type="text" class="validate">
					                        <label class="active" for="product_price">Price</label>
					                    </div>
					                    <div class="input-field col s12">
										    <select name="product_category">
										      <option value="<% out.print(product.getCategory()); %>" disabled selected>Select Category</option>
										      <option value="boots">Boots</option>
										      <option value="shoes">Shoes</option>
										      <option value="sandals">Sandals</option>
										      <option value="slippers">Slippers</option>
										    </select>
										    <label>Category</label>
										  </div>
					                    <button class="btn waves-effect waves-light blue" type="submit">Apply
					                        <i class="material-icons right">send</i>
					                    </button>
					                </form>
					        	</div>
					        </div>
					        <div class="modal-footer">
						      <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Cancel</a>
						    </div>
				        </div>
            <% } %>
            </ul>
            </div>
            
            <div class="row" id="sandals_cards">
		  	<ul id="sandals_list">
	    <% for (Product product : listCategorizedProducts.get("sandals")) { %>
		    <li>
		    <form class="card" method="get" action="">
								
							<input type="hidden" name="product_id" value="">
							
								<div class="col s4">
							        <div class="card " style="overflow: hidden;">
						              <div class="card-image waves-effect waves-block waves-light"  >
						                <a href="#product_modal_<% out.print(product.getProd_id()); %>" class="modal-trigger"><img class="activator" src="img/shoe_0.jpg"></a>
						                <span class="card-title"><% out.print(Encode.forHtml(product.getName())); %></span>
						              </div>
						              <div class="card-content">
						                <span class="card-title activator grey-text text-darken-4">$<% out.print(product.getPrice()); %>
						                </span>
						                <p>Category: <% out.print(product.getCategory().substring(0, 1).toUpperCase() + product.getCategory().substring(1)); %>
						              </div>
						              <div class="card-action">
							              <a href="#product_modal_<% out.print(product.getProd_id()); %>" class="modal-trigger">Edit Product</a>
							              <a href="/Talaria/EditProductServlet?method=deleteProduct&productID=<% out.print(product.getProd_id()); %>">Delete Product</a>
						           	 </div>
	       				            </div>
				            </div>
			            </form>
			            </li>
			            <div id="product_modal_<% out.print(product.getProd_id()); %>" class="modal">
				            <div class="modal-content">
					        	<div class="col s12">
					        		<h4> Make changes </h4>
					                <form action="EditProductServlet" method="post">
					                <input type="hidden" name="product_id" value="<% out.print(product.getProd_id()); %>">
					                    <div class="input-field col s12">
					                        <input name="product_name" value="<% out.print(Encode.forHtml(product.getName())); %>" id="product_name" type="text" class="validate">
					                        <label class="active" for="product_name">Name</label>
					                    </div>
					                    <div class="input-field col m12">
					                        <input name="product_price" value="<% out.print(product.getPrice()); %>" id="product_price" type="text" class="validate">
					                        <label class="active" for="product_price">Price</label>
					                    </div>
					                    <div class="input-field col s12">
										    <select name="product_category">
										      <option value="<% out.print(product.getCategory()); %>" disabled selected>Select Category</option>
										      <option value="boots">Boots</option>
										      <option value="shoes">Shoes</option>
										      <option value="sandals">Sandals</option>
										      <option value="slippers">Slippers</option>
										    </select>
										    <label>Category</label>
										  </div>
					                    <button class="btn waves-effect waves-light blue" type="submit">Apply
					                        <i class="material-icons right">send</i>
					                    </button>
					                </form>
					        	</div>
					        </div>
					        <div class="modal-footer">
						      <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Cancel</a>
						    </div>
				        </div>
            <% } %>
            </ul>
            </div>
            
    	<div class="row" id="slippers_cards">
		  	<ul id="slippers_list">
    	<% for (Product product : listCategorizedProducts.get("slippers")) { %>
		    <li>
		    <form class="card" method="get" action="">
								
							<input type="hidden" name="product_id" value="">
							
								<div class="col s4">
							        <div class="card " style="overflow: hidden;">
						              <div class="card-image waves-effect waves-block waves-light"  >
						                <a href="#product_modal_<% out.print(product.getProd_id()); %>" class="modal-trigger"><img class="activator" src="img/shoe_0.jpg"></a>
						                <span class="card-title"><% out.print(Encode.forHtml(product.getName())); %></span>
						              </div>
						              <div class="card-content">
						                <span class="card-title activator grey-text text-darken-4">$<% out.print(product.getPrice()); %>
						                </span>
						                <p>Category: <% out.print(product.getCategory().substring(0, 1).toUpperCase() + product.getCategory().substring(1)); %>
						              </div>
						              <div class="card-action">
							              <a href="#product_modal_<% out.print(product.getProd_id()); %>" class="modal-trigger">Edit Product</a>
							              <a href="/Talaria/EditProductServlet?method=deleteProduct&productID=<% out.print(product.getProd_id()); %>">Delete Product</a>
						           	 </div>
	       				            </div>
				            </div>
			            </form>
			            </li>
			            <div id="product_modal_<% out.print(product.getProd_id()); %>" class="modal">
				            <div class="modal-content">
					        	<div class="col s12">
					        		<h4> Make changes </h4>
					                <form action="EditProductServlet" method="post">
					                <input type="hidden" name="product_id" value="<% out.print(product.getProd_id()); %>">
					                    <div class="input-field col s12">
					                        <input name="product_name" value="<% out.print(Encode.forHtml(product.getName())); %>" id="product_name" type="text" class="validate">
					                        <label class="active" for="product_name">Name</label>
					                    </div>
					                    <div class="input-field col m12">
					                        <input name="product_price" value="<% out.print(product.getPrice()); %>" id="product_price" type="text" class="validate">
					                        <label class="active" for="product_price">Price</label>
					                    </div>
					                    <div class="input-field col s12">
										    <select name="product_category">
										      <option value="<% out.print(product.getCategory()); %>" disabled selected>Select Category</option>
										      <option value="boots">Boots</option>
										      <option value="shoes">Shoes</option>
										      <option value="sandals">Sandals</option>
										      <option value="slippers">Slippers</option>
										    </select>
										    <label>Category</label>
										  </div>
					                    <button class="btn waves-effect waves-light blue" type="submit">Apply
					                        <i class="material-icons right">send</i>
					                    </button>
					                </form>
					        	</div>
					        </div>
					        <div class="modal-footer">
						      <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Cancel</a>
						    </div>
				        </div>
		            <% } %>
            </ul>
            </div>
     </div>

    
    <div id="test"></div>
</body>
</html>
<% }} else { %> <jsp:include page="forbidden.jsp" /> <% } %>