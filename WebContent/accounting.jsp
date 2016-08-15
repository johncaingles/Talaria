<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accounting Panel</title>

	<jsp:include page="dependencies.jsp" />
<script type="text/javascript">
    function show() {
        var selopt = document.getElementById("filter1").value;
        if (selopt == 1) {
            document.getElementById("f1").style.display = "block";
            document.getElementById("f2").style.display = "none";
            document.getElementById("btn").style.display = "block";
        }
        if (selopt == 2) {
            document.getElementById("f2").style.display = "block";
            document.getElementById("f1").style.display = "none";
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
			    <div class="input-field col s12">
			    	<div class="col s5">
				      <select id="filter1" name="filter1" onchange="show()">
					      <option value="" disabled selected>Filter by...</option>
					      <option value="1">Total sales</option>
					      <option value="2">Sales per product type</option>
					  </select>
				  	</div>
				  	
				  	<div id="f1" class="col s5" style="display:none">
				      <select name="f1" onchange="showTable()">
					      <option value="1">All sales</option>
					      <option value="2">Per product type</option>
					      <option value="3">Per product</option>
					  </select>
				  	</div>
				  	
				  	<div id="f2" class="col s5" style="display:none">
				      <select name="f2" onchange="showTable()">
					      <option value="1">Boots</option>
					      <option value="2">Shoes</option>
					      <option value="3">Sandals</option>
					      <option value="4">Slippers</option>
					  </select>
				  	</div>
				  	<div id="btn" class="col s2" style="display:none">
				      <button class="btn-large red lighten-1" onclick="showTable()">Show</button>
				  	</div>
				</div>
		  	</div>
		<div class="col s12">
			<table id="table" class="striped" style="display:none">
		        <thead>
		          <tr>
		              <th>Name</th>
		              <th>Item Name</th>
		              <th>Item Price</th>
		          </tr>
		        </thead>
		
		        <tbody>
		          <tr>
		            <td>Alvin</td>
		            <td>Eclair</td>
		            <td>$0.87</td>
		          </tr>
		          <tr>
		            <td>Alan</td>
		            <td>Jellybean</td>
		            <td>$3.76</td>
		          </tr>
		          <tr>
		            <td>Jonathan</td>
		            <td>Lollipop</td>
		            <td>$7.00</td>
		          </tr>
		          <tr>
		            <td>Jonathan</td>
		            <td>Lollipop</td>
		            <td>$7.00</td>
		          </tr>
		          <tr>
		            <td>Jonathan</td>
		            <td>Lollipop</td>
		            <td>$7.00</td>
		          </tr>
		          <tr>
		            <td>Jonathan</td>
		            <td>Lollipop</td>
		            <td>$7.00</td>
		          </tr>
		        </tbody>
	      </table>
      </div>
	</div>
</body>
</html>