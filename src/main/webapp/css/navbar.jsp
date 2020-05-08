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
	<a href="homeadmin.jsp">Home</a>
	<a href="UserServlet?mode=userlist">Users</a>
	<a href="ActivityServlet?mode=activitylist">Activities</a>
	<a class="active" href="CategoryServlet?mode=categorylist">Categories</a>
  	<a href="ToolServlet?mode=toollist">Tools</a>
	<a href="LogoutServlet" id="logout">Logout</a>
</div>
</body>
</html>