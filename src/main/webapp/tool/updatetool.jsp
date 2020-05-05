<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="it.contrader.dto.ToolDTO"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link href="../css/vittoriostyle.css" rel="stylesheet">
		<title>Edit Tool</title>
	</head>
	<body>
		<%@ include file="../css/header.jsp" %>
		<div class="navbar">
			<a href="homeadmin.jsp">Home</a>
			<a class="active" href="ToolServlet?mode=toollist">Tools</a>
			<a href="LogoutServlet" id="logout">Logout</a>
		</div>
		<br>
		<div class="main">
			<%ToolDTO u = (ToolDTO) request.getAttribute("dto");%>
			<form id="floatleft" action="ToolServlet?mode=update&id=<%=u.getId()%>" method="post">
				<div class="row">
					<div class="col-25">
						<label for="tool_name">Name</label>
					</div>
					<div class="col-75">
						<input type="text" id="tool_name" name="name" value=<%=u.getName()%>>
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="tool_description">Description</label>
					</div>
					<div class="col-75">
						<input type="text" id="tool_description" name="description" value=<%=u.getDescription()%>> 
					</div>
				</div>
				<button type="submit">Edit</button>
			</form>
		</div>
		<br>
		<%@ include file="../css/footer.jsp" %>	
	</body>
</html>
