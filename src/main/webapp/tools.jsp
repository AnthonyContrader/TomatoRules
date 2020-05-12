<%@ page import="it.contrader.dto.ToolDTO" import="java.util.*"%>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport"       content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description"    content="Tool Management">
		<link href="/css/vittoriostyle.css" rel="stylesheet">
		<title>Tool Manager</title>
	</head>
	<body>
		<%@ include file="./css/header.jsp"%>
		<div class="navbar">
			<a href="/homeadmin.jsp">Home</a>
			<a href="/user/getall">Users</a>
			<a class="active" href="/tool/getall">Tools</a>
			<a href="/user/logout" id="logout">Logout</a>
		</div>
		<div class="main">
			<%
				List<ToolDTO> list = (List<ToolDTO>) request.getSession().getAttribute("list");
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
					for (ToolDTO t : list) {
				%>
				<tr>
					<td><a href="/tool/read?id=<%=t.getId()%>"> <%=t.getName()%> </a></td>
					<td><%=t.getDescription()%></td>
					<td><a href="/tool/preupdate?id=<%=t.getId()%>">Edit</a></td>
					<td><a href="/tool/delete?id=<%=t.getId()%>">Delete</a></td>
				</tr>
				<%
					}
				%>
			</table>
			<form id="floatright" action="/tool/insert" method="post">
				<div class="row">
					<div class="col-25">
						<label for="tool_name">Name</label>
					</div>
					<div class="col-75">
						<input type="text" id="tool_name" name="name"
							placeholder="inserisci il nome">
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="tool_description">Description</label>
					</div>
					<div class="col-75">
						<input type="text" id="tool_description" name="description"
							placeholder="inserisci la descrizione">
					</div>
				</div>
				<button type="submit">Insert</button>
			</form>
		</div>
		<br>
		<%@ include file="./css/footer.jsp"%>
	</body>
</html>
