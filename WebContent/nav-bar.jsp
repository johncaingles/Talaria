<%@ page import="model.Account" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Transaction" %>
<%@ page import="org.owasp.encoder.Encode" %>
<nav class="light-red lighten-1" role="navigation">
    <div class="nav-wrapper container"><a id="logo-container" href="index.jsp" class="brand-logo">Talaria</a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
<%--         <%   if ((session.getAttribute("cart_items") != null) ){ %> --%>
<!--         		<li><a href="cart.jsp"><i class="material-icons">shopping_cart</i></a></li> -->
<%--         <% } %> --%>
		<%	int cartTotal = 0; 
		if (session.getAttribute("cart_items") != null){
			for(Transaction trans: ((ArrayList<Transaction>)session.getAttribute("cart_items"))){
				cartTotal  += 1*trans.getQuantity();	
			}
		}%>
        <li><%   if ((session.getAttribute("user_account") == null) ){ %>
        	<li><a class="modal-trigger" href="#login_modal"><i class="material-icons">shopping_cart</i></a></li>
    		<a class="modal-trigger" href="#login_modal">Login</a>
    	<% } else {
			Account account = (Account)session.getAttribute("user_account");
			String user_name = account.getFirst_name(); 
			if(account.getPrivilegeLevel().equals("1")){%>
<%-- 			<li><a href="cart.jsp"><span class="new badge" data-badge-caption="custom caption"><% out.print(cartTotal); %></span><i class="material-icons">shopping_cart</i></a></li> --%>
			<li><a href="cart.jsp"><i class="material-icons">shopping_cart</i></a></li>
    		<a class="dropdown-button" href="#!" data-activates="customer_dropdown"><% out.print(Encode.forHtml(user_name)); %><i class="material-icons right">arrow_drop_down</i></a>
    	<% }else{ %> 
    		<a class="dropdown-button" href="#!" data-activates="account_dropdown"><% out.print(Encode.forHtml(user_name)); %><i class="material-icons right">arrow_drop_down</i></a>
    	<% }} %>
      </ul>
    </div>
  </nav>
  
  <%   if ((session.getAttribute("notif") != null) ){ %>
  <div class="row">
      <div class="col s12">
        <div class="card-panel red lighten-1">
          <span class="white-text"><% out.print(session.getAttribute("notif")); %>
          </span>
        </div>
      </div>
    </div>
    <% } %>
    <% session.setAttribute("notif", null); %>
  
  <ul id="customer_dropdown" class="dropdown-content">
  <li><a href="bought_items.jsp">Your Items</a></li>
  <li><a href="change_password.jsp">Change Password</a></li>
  <li class="divider"></li>
  <li><a href="/Talaria/LogoutServlet">Logout</a></li>
</ul>

<ul id="account_dropdown" class="dropdown-content">
  <li><a href="change_password.jsp">Change Password</a></li>
  <li><a href="/Talaria/LogoutServlet">Logout</a></li>
</ul>

<div id="login_modal" class="modal">
    <div class="modal-content">
        <div class="row">
        	<div class="col s6">
        		<h4> Existing User? </h4>
                <form action="LoginServlet" method="post">
                    <div class="input-field col s12">
                        <input name="username" value="" id="username" type="text" class="validate" required="" aria-required="true">
                        <label class="active" for="username">Username</label>
                    </div>
                    <div class="input-field col s12">
                        <input name="password" value="" id="password" type="password" class="validate" required="" aria-required="true">
                        <label class="active" for="password">Password</label>
                    </div>
                    <button class="btn waves-effect waves-light blue" type="submit">Login
                        <i class="material-icons right">send</i>
                    </button>
                </form>
        	</div>

        	<div class="col s6">
        		<h4> Create an account </h4>
        		<a href="register.jsp">REGISTER</a>
        	</div>
        </div>

    <div class="modal-footer">
      <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Cancel</a>
    </div>

    </div>
</div>

<script type="text/javascript">
$(document).ready(function() {
    $('select').material_select();
    $('.modal-trigger').leanModal();
});
</script>