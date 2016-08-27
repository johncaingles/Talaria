<%@ page import="model.Account" %>
<%@ page import="org.owasp.encoder.Encode" %>
<nav class="light-red lighten-1" role="navigation">
    <div class="nav-wrapper container"><a id="logo-container" href="index.jsp" class="brand-logo">Talaria</a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
        <%   if ((session.getAttribute("cart_items") != null) ){ %>
        		<li><a href="cart.jsp"><i class="material-icons">shopping_cart</i></a></li>
        <% } %>
        <li><%   if ((session.getAttribute("user_account") == null) ){ %>
    		<a class="modal-trigger" href="#login_modal">Login</a>
    	<% } else {
			Account account = (Account)session.getAttribute("user_account");
			String user_name = account.getUsername(); 
			if(account.getPrivilegeLevel().equals("1")){%>
    		<a class="dropdown-button" href="#!" data-activates="customer_dropdown"><% out.print(Encode.forHtml(user_name)); %><i class="material-icons right">arrow_drop_down</i></a>
    	<% }else{ %> 
    		<a class="dropdown-button" href="#!" data-activates="account_dropdown"><% out.print(Encode.forHtml(user_name)); %><i class="material-icons right">arrow_drop_down</i></a>
    	<% }} %>
      </ul>
    </div>
  </nav>
  
  <ul id="customer_dropdown" class="dropdown-content">
  <li><a href="bought_items.jsp">Your Items</a></li>
  <li class="divider"></li>
  <li><a href="/Talaria/LogoutServlet">Logout</a></li>
</ul>

<ul id="account_dropdown" class="dropdown-content">
  <li><a href="/Talaria/LogoutServlet">Logout</a></li>
</ul>

<div id="login_modal" class="modal">
    <div class="modal-content">
        <div class="row">
        	<div class="col s6">
        		<h4> Existing User? </h4>
                <form action="LoginServlet" method="post">
                    <div class="input-field col s12">
                        <input name="username" value="" id="username" type="text" class="validate">
                        <label class="active" for="username">Username</label>
                    </div>
                    <div class="input-field col s12">
                        <input name="password" value="" id="password" type="password" class="validate">
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