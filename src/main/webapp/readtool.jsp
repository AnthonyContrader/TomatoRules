<%@ page import="it.contrader.dto.ToolDTO"%>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport"       content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description"    content="Tool Read">
		<link href="/css/vittoriostyle.css" rel="stylesheet">
		<title>Read Tool</title>
	</head>
	<body>
		<%@ include file="./css/header.jsp"%>
		<div class="navbar">
			<a href="/homeadmin.jsp">Home</a>
			<a href="/user/getall">Users</a>
			<a class="active" href="/tool/getall">Tools</a>
			<a href="/user/logout" id="logout">Logout</a>
		</div>
		<br>
		<div class="main">
			<%
				ToolDTO t = (ToolDTO) request.getSession().getAttribute("dto");
			%>
			<table>
				<tr>
					<th>Name</th>
					<th>Description</th>
				</tr>
				<tr>
					<td><%=t.getName()%></td>
					<td><%=t.getDescription()%></td>
				</tr>
			</table>
			<br> <br> <br> <br> <br> <br> <br>
			<br> <br> <br> <br> <br> <br> <br>
		</div>
		<%@ include file="./css/footer.jsp"%>
	</body>
</html>
