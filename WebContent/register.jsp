<html>
	<head>
<!-- 		<link rel="stylesheet" type="text/css" href="css\skeleton.css"> -->
		<jsp:include page="dependencies.jsp" />
		<style>
		</style>
	</head>
	<jsp:include page="nav-bar.jsp" />
	<body bgcolor = "">
		<div class="container">
			<div class="row">
				<form action="RegisterServlet" method="post">
					<div class = "card-panel hoverable col s3">
						<h5>Personal Info</h5>
						<div class="input-field col s12">
	                        <input name="first_name" value="" id="first_name" type="text" pattern="\D{1,45}" maxlength="45" oninput="setCustomValidity('')" oninvalid="setCustomValidity('Cannot be empty and must be less than 45 characters')" class="validate" required="" aria-required="true">
	                        <label class="active" for="first_name">First Name</label>
	                    </div>
						<div class="input-field col s12">
	                        <input name="middle_name" value="" id="middle_name" type="text" pattern="\D{1}" maxlength="1" oninput="setCustomValidity('')" oninvalid="setCustomValidity('Cannot be empty and must be less than 45 characters')" class="validate" required="" aria-required="true">
	                        <label class="active" for="middle_name">Middle Name</label>
	                    </div>
						<div class="input-field col s12">
	                        <input name="last_name" value="" id="last_name" type="text" pattern="\D{1,45}" maxlength="45" oninput="setCustomValidity('')" oninvalid="setCustomValidity('Cannot be empty and must be less than 45 characters')" class="validate" required="" aria-required="true">
	                        <label class="active" for="last_name">Last Name</label>
	                    </div>
						<div class="input-field col s12">
	                        <input name="email" value="" id="email" type="email" pattern="\D{1,45}" maxlength="45" oninput="setCustomValidity('')" oninvalid="setCustomValidity('Cannot be empty and must be less than 45 characters')" class="validate" required="" aria-required="true">
	                        <label class="active" for="email">Email Address</label>
	                    </div>
						<div class="input-field col s12">
	                        <input name="username" value="" id="username" type="text" pattern="\D{1,45}" maxlength="45" oninput="setCustomValidity('')" oninvalid="setCustomValidity('Cannot be empty and must be less than 45 characters')" class="validate" required="" aria-required="true">
	                        <label class="active" for="username">Username</label>
	                    </div>
						<div class="input-field col s12">
	                        <input name="password" value="" id=""password"" type=""password"" pattern="\D{1,45}" maxlength="45" oninput="setCustomValidity('')" oninvalid="setCustomValidity('Cannot be empty and must be less than 45 characters')" class="validate" required="" aria-required="true">
	                        <label class="active" for="password">Password</label>
	                    </div>
						<input type = "password" placeholder = "Confirm Password" name = "confirm_password" required="" aria-required="true">					
					</div>
	
					<div class="card-panel hoverable col s3 offset-s1">
						<h5>Billing Address</h5>
						<input type = "text" placeholder = "House #" name = "bil_house_num" required="" aria-required="true"><br>
						<input type = "text" placeholder = "Street" name = "bil_street" required="" aria-required="true"><br>
						<input type = "text" placeholder = "Subdivision" name = "bil_subdivision" required="" aria-required="true"><br>
						<input type = "text" placeholder = "City" name = "bil_city" required="" aria-required="true"><br>
						<input type = "number" placeholder = "Postal Code" maxlength = "1" name = "bil_postal_code" required="" aria-required="true"><br>
						<input type = "text" placeholder = "Country" name = "bil_country" required="" aria-required="true"><br>
					</div>
	
					<div class="card-panel hoverable col s3 offset-s1">
						<h5>Shipping Address</h5>
						<input type = "text" placeholder = "House #" name = "ship_house_num" required="" aria-required="true"><br>
						<input type = "text" placeholder = "Street" name = "ship_street" required="" aria-required="true"><br>
						<input type = "text" placeholder = "Subdivision" name = "ship_subdivision" required="" aria-required="true"><br>
						<input type = "text" placeholder = "City" name = "ship_city" required="" aria-required="true"><br>
						<input type = "number" placeholder = "Postal Code" maxlength = "1" name = "ship_postal_code" required="" aria-required="true"><br>
						<input type = "text" placeholder = "Country" name = "ship_country" required="" aria-required="true"><br>
						<input type = "submit" value = "submit" style="background-color:rgb(191, 191, 191);">
					</div>
				</form>
			</div>
		</div>
	</body>
</html>