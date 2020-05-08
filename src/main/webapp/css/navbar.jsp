<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>
</head>
<body>
<div class="navbar">
	<a <%
  		if (request.getAttribute("activesection") == "home") {
  			out.print("class='active'");
  		}
  	%> href="homeadmin.jsp">Home</a>
	<a <%
  		if (request.getAttribute("activesection") == "users") {
  			out.print("class='active'");
  		}
  	%> href="UserServlet?mode=userlist">Users</a>
	<a <%
  		if (request.getAttribute("activesection") == "activities") {
  			out.print("class='active'");
  		}
  	%> href="ActivityServlet?mode=activitylist">Activities</a>
	<a <%
  		if (request.getAttribute("activesection") == "categories") {
  			out.print("class='active'");
  		}
  	%> href="CategoryServlet?mode=categorylist">Categories</a>
  	<a <%
  		if (request.getAttribute("activesection") == "tools") {
  			out.print("class='active'");
  		}
  	%> href="ToolServlet?mode=toollist&activesection=tools">Tools</a>
	<a href="LogoutServlet" id="logout">Logout</a>
</div>
</body>
</html>