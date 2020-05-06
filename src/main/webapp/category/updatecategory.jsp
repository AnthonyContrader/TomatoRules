<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CategoryDTO"
    import="it.contrader.dto.ToolDTO"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Category</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
	<a href="homeadmin.jsp">Home</a>
	<a class="active" href="CategoryServlet?mode=categorylist">Categories</a>
	<a href="LogoutServlet" id="Logout">Logout</a>
</div>
<br>
<div class="main">

<%CategoryDTO c = (CategoryDTO) request.getAttribute("dto");
	ToolDTO t = (ToolDTO) request.getAttribute("tooldto");
%>


<form id="floatleft" action="CategoryServlet?mode=update&id=<%=c.getId()%>" method="post">
	<div class="row">
		<div class="col-25">
			<label for="category">Name</label>
		</div>
		<div class="col-75">
			<input type="text" id="category" name="name" value=<%=c.getName()%>>
		</div>
	</div>
	<div class="row">
		<div class="col-25">
			<label for="desc">Description</label>
		</div>
		<div class="col-75">
			<input
				type="text" id="desc" name="description" value=<%=c.getDescription()%>>
		</div>
	</div>
	<!--  <div class="row">
		<div class="col-25">
			<label for="type">Select Tool</label>
		</div>
		<div class="col-75">
			<select id="tool" name="idtool" required>
				<option value="" disabled selected>Select Tools</option>
				<%
					//for (ToolDTO t : listTool) {
				%>
				<option value="<%//=t.getId()%>"><%//=t.getName()%></option>
				<% 
					//}
				%>
			</select>
		</div>
	</div>
	-->
	<button type="submit" >Edit</button>
</form>


</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>