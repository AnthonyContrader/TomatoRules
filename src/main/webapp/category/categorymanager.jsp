<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
    import="it.contrader.dto.CategoryDTO" 
    import="it.contrader.dto.ToolDTO" 
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Category Manager</title>
</head>
<body>
<%
	request.setAttribute("activesection", "categories");
%>
<%@ include file="../css/header.jsp" %>
<%@ include file="../css/navbar.jsp" %>

<!-- <div class="navbar">
	<a href="homeadmin.jsp">Home</a>
	<a href="UserServlet?mode=userlist">Users</a>
	<a href="ActivityServlet?mode=activitylist">Activities</a>
	<a class="active" href="CategoryServlet?mode=categorylist">Categories</a>
  	<a href="ToolServlet?mode=toollist">Tools</a>
	<a href="LogoutServlet" id="logout">Logout</a>
</div>
-->
<div class="main">
	<% 
		List<CategoryDTO> list = (List<CategoryDTO>) request.getAttribute("list");
		List<ToolDTO> listTool = (List<ToolDTO>) request.getAttribute("list_T");
		String toolname;
	%>
	
<br>

	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Description</th>
			<th>Tool</th>
			<th></th>
			<th></th>
		</tr>
		<% 
			for (CategoryDTO c : list) {
				toolname = "";
				for (ToolDTO t : listTool) {
					int x = c.getIdtool();
					if (c.getIdtool() == t.getId()) {
						System.out.println(c.getIdtool());
						toolname = t.getName();
						break;
					}
				}
		%>
		<tr>
			<td><%=c.getId() %></td>
			<td><a href=CategoryServlet?mode=read&id=<%=c.getId()%>>
					<%=c.getName()%>
			</a></td>
			<td><%=c.getDescription()%></td>
			<td><%=toolname%></td>
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
			<input type="text" id="category" name="name" placeholder="nome categoria">
		</div>
	</div>
	<div class="row">
		<div class="col-25">
			<label for="desc">Description</label>
		</div>
		<div class="col-75">
			<input type="text" id="desc" name="description" placeholder="descrizione categoria">
		</div>
	</div>
	<div class="row">
		<div class="col-25">
			<label for="type">Select Tool</label>
		</div>
		<div class="col-75">
			<select id="tool" name="idtool" required>
				<option value="" disabled selected>Select Tools</option>
				<%
					for (ToolDTO t : listTool) {
				%>
				<option value="<%=t.getId()%>"><%=t.getName()%></option>
				<% 
					}
				%>
			</select>
		</div>
	</div>
	
	
		<button type="submit" >Insert</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>
</body>
</html>