<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"	import="it.contrader.dto.CategoryDTO"
    	 	%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Category Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Category</title>
</head>
<body>
	<%@ include file="./css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a> 
		<a class="active" href="/category/getall">Categories</a> 
		<a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>
	
	<div class="main">
		<% 
			CategoryDTO c = (CategoryDTO) request.getSession().getAttribute("dto");
			
		%>
	
		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Description</th>
				<th>Tool</th>
			</tr>
			<tr>
				<td><%=c.getId()%></td>
				<td><%=c.getName()%></td>
				<td><%=c.getDescription()%></td>
				<td><%=c.getTool()%></td>
			</tr>
		</table>
		
		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>
		
	
	</div>

	<%@ include file="./css/footer.jsp" %>
</body>
</html>