<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ActivityDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Read Activity</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
	<a href="homeadmin.jsp">Home</a>
	<a class="active" href="ActivityServlet?mode=activitylist">Activities</a>
	<a href="LogoutServlet" id="Logout">Logout</a>
</div>
<br>

<div class="main">
<%ActivityDTO u = (ActivityDTO) request.getAttribute("dto");%>


<table>
	<tr>
		<th>Name</th>
		<th>Time</th>
	</tr>
	<tr>
		<td><%=u.getName()%></td>
		<td> <%=u.getTime()%></td>
	</tr>
</table>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>


</div>

<%@ include file="../css/footer.jsp" %>				
</body>
</html>