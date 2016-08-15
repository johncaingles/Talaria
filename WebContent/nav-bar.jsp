<nav class="light-red lighten-1" role="navigation">
    <div class="nav-wrapper container"><a id="logo-container" href="" class="brand-logo">Talaria</a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
        <li><a href="">Researchers</a></li>
        <li><a href="">Studies</a></li>
        <li><a href="">Genomes</a></li>
        <li><a href="">About</a></li>
        <%@ page import="model.Account" %>
        <li><%   if ((session.getAttribute("user_account") == null) ){ %>
    		<a class="modal-trigger" href="#login_modal">Login</a>
    	<% } else {
			Account account = (Account)session.getAttribute("user_account");
			String user_name = account.getName(); %>
    		<a class="dropdown-button" href="#!" data-activates="account_dropdown"><% out.print(user_name); %>'<i class="material-icons right">arrow_drop_down</i></a>
    	<% } %>
      </ul>
    </div>
  </nav>
  
  <ul id="account_dropdown" class="dropdown-content">
  <li><a href="">Profile</a></li>
  <li class="divider"></li>
  <li><a href="">Logout</a></li>
</ul>

<div id="login_modal" class="modal">
    <div class="modal-content">
        <div class="row">
        	<div class="col s6">
        		<h4> Existing User? </h4>
                <form action="" method="get">
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