<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Menu</title>
</head>
<body>
<div class="navbar">
	<a <%
  		if (request.getAttribute("activesection") == "home") {
  			out.print("class='active'");
  		}
  	%> href="/homeadmin.jsp">Home</a>
	<a <%
  		if (request.getAttribute("activesection") == "users") {
  			out.print("class='active'");
  		}
  	%> href="/user/getall">Users</a>
	<a <%
  		if (request.getAttribute("activesection") == "activities") {
  			out.print("class='active'");
  		}
  	%> href="/activity/getall">Activities</a>
	<a <%
  		if (request.getAttribute("activesection") == "categories") {
  			out.print("class='active'");
  		}
  	%> href="/category/getall">Categories</a>
  	<a <%
  		if (request.getAttribute("activesection") == "tools") {
  			out.print("class='active'");
  		}
  	%> href="/tool/getall">Tools</a>
	<a href="/user/logout" id="logout">Logout</a>
</div>
</body>
</html>