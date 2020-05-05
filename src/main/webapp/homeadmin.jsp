<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="it.contrader.dto.UserDTO"
	import="it.contrader.dto.CategoryDTO"
	
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Admin</title>
<link href="css/vittoriostyle.css" rel="stylesheet">
</head>
<body>
<%@include file="css/header.jsp"%>


<div class="navbar">
  <a class="active" href="homeadmin.jsp">Home</a>
  <a href="UserServlet?mode=userlist">Users</a>
  <a href="CategoryServlet?mode=categorylist">Categories</a>
  <a href="ActivityServlet?mode=activitylist">Activities</a>
  <a href="ToolServlet?mode=toollist">Tools</a>
  
  
  <a href="LogoutServlet" id="logout">Logout</a>
</div>

<div class="main">
<h1>Welcome ${user.getUsername()}</h1>

SPERIAMOFUNZIONI. SPERIAMOFUNZIONI. SPERIAMOFUNZIONI.<br> 
SPERIAMOFUNZIONI. SPERIAMOFUNZIONI. SPERIAMOFUNZIONI.<br>



</div>


<%@ include file="css/footer.jsp" %>

</body>
</html>