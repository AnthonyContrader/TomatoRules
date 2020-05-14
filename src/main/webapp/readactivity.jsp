<%@ page 
	import="it.contrader.dto.ActivityDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Activity Read">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Read Activity</title>
</head>
<meta charset="utf-8">
<body>
<%@ include file="./css/header.jsp"%>
	<div class="navbar">
		<a href="/homeadmin.jsp">Home</a>
		 <a class="active" 	href="/activity/getall">Activities</a>
		  <a href="/user/logout" id="logout">Logout</a>
	</div>
	<br>

	<div class="main">
		<%
			ActivityDTO a = (ActivityDTO)   request.getSession().getAttribute("dto");
		%>


		<table>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Time</th>
				<th>Tool</th>
				<th>Category</th>
				<th>Cat.Tool</th>
			</tr>
			<tr>
				<td><%=a.getId()%></td>
				<td><%=a.getName()%></td>
				<td><%=a.getTime()%></td>
				<td><%=a.getActivitytool().getName()%></td>
				<td><%=a.getCategory().getName()%></td>
				<td><%=a.getCategory().getTool().getName() %></td>
			</tr>
		</table>

		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br> <br> <br> <br>


	</div>

	<%@ include file="./css/footer.jsp"%>
</body>
</html>
