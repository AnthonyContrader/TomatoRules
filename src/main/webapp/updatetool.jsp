<%@ page import="it.contrader.dto.ToolDTO"%>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport"       content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description"    content="Tool Edit page">
		<link href="/css/vittoriostyle.css" rel="stylesheet">
		<title>Edit Tool</title>
	</head>
	<body>
		<%@ include file="./css/header.jsp" %>
		<div class="navbar">
			<a href="/homeadmin.jsp">Home</a>
			<a href="/user/getall">Users</a>
			<a class="active" href="/tool/getall">Tools</a>
			<a href="/user/logout" id="logout">Logout</a>
		</div>
		<div class="main">
			<% ToolDTO t = (ToolDTO) request.getSession().getAttribute("dto"); %>
			<form id="floatleft" action="/tool/update" method="post">
				<div class="row">
					<div class="col-25">
						<label for="tool_name">Name</label>
					</div>
					<div class="col-75">
						<input type="text" id="tool_name" name="name" value="<%=t.getName()%>">
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="tool_description">Description</label>
					</div>
					<div class="col-75">
						<input type="text" id="tool_description" name="description" value="<%=t.getDescription()%>">
					</div>
				</div>
				<input type="hidden" name="id" value="<%=t.getId() %>">
				<button type="submit" >Edit</button>
			</form>
		</div>
		<br>
		<%@ include file="./css/footer.jsp" %>	
	</body>
</html>
