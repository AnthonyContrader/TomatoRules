<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List" import="it.contrader.dto.ToolDTO"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="../css/vittoriostyle.css" rel="stylesheet">
		<title>Tool Manager</title>
	</head>
	<body>
		<%@ include file="../css/header.jsp" %>
		<div class="navbar">
			<a href="homeadmin.jsp">Home</a>
			<a class="active" href="ToolServlet?mode=toollist">Tools</a>
			<a href="LogoutServlet" id="logout">Logout</a>
		</div>
		<div class="main">
			<%
				List<ToolDTO> list = (List<ToolDTO>) request.getAttribute("list");
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
					for (ToolDTO u : list) {
				%>
				<tr>
					<td><a href=ToolServlet?mode=read&id=<%=u.getId()%>>
							<%=u.getName()%>
					</a></td>
					<td><%=u.getDescription()%></td>
					<td><a href=ToolServlet?mode=read&update=true&id=<%=u.getId()%>>Edit</a>
					</td>
					<td><a href=ToolServlet?mode=delete&id=<%=u.getId()%>>Delete</a>
					</td>
				</tr>
				<%
					}
				%>
			</table>
			<form id="floatright" action="ToolServlet?mode=insert" method="post">
				<div class="row">
					<div class="col-25">
						<label for="tool_name">Name</label>
					</div>
					<div class="col-75">
						<input type="text" id="tool_name" name="name" placeholder="inserisci il nome">
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="tool_description">Description</label>
					</div>
					<div class="col-75">
						<input type="text" id="tool_description" name="description" placeholder="inserisci il tipo di attivit&agrave;"> 
					</div>
				</div>
				<button type="submit" >Insert</button>
			</form>
		</div>
		<br>
		<%@ include file="../css/footer.jsp" %>
	</body>
</html>
