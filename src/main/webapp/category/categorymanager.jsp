<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
    import="it.contrader.dto.CategoryDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Category Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
	<a href="homeadmin.jsp">Home</a>
	<a href="UserServlet?mode=userlist">Users</a>
	<a class="active" href="CategoryServlet?mode=categorylist">Categories</a>
	<a href="ActivityServlet?mode=activitylist">Activities</a>
  	<a href="ToolServlet?mode=toollist">Tools</a>
	<a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<% 
		List<CategoryDTO> list = (List<CategoryDTO>) request.getAttribute("list");
	%>
	
<br>

	<table>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th></th>
			<th></th>
		</tr>
		<% 
			for (CategoryDTO c : list) {
		%>
		<tr>
			<td><a href=CategoryServlet?mode=read&id=<%=c.getId()%>>
					<%=c.getName()%>
			</a></td>
			<td><%=c.getDescription()%></td>
			<td><a href=CategoryServlet?mode=read&update=true&id=<%=c.getId()%>>Edit</a>
			</td>
			<td><a href=CategoryServlet?mode=delete&id=<%=c.getId()%>>Delete</a>
			</td>
			
		</tr>
		<%
			}
		%>
	</table>


<form id="floatright" action="CategoryServlet?mode=insert" method="post">
	<div class="row">
		<div class="col-25">
			<label for="category">Name</label>
		</div>
		<div class="col-75">
			<input type="text" id="category" name="name" placeholder="inserisci name">
		</div>
	</div>
	<div class="row">
		<div class="col-25">
			<label for="desc">Description</label>
		</div>
		<div class="col-75">
			<input type="text" id="desc" name="description" placeholder="inserisci description">
		</div>
	</div>
	
		<button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>