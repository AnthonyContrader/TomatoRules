<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"
    import="it.contrader.dto.ActivityDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Activity Manager</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>

<div class="navbar">
	<a href="homeadmin.jsp">Home</a>
	<a href="UserServlet?mode=userlist">Users</a>
	<a class="active" href="ActivityServlet?mode=activitylist">Activities</a>
	<a href="CategoryServlet?mode=categorylist">Categories</a>
  	<a href="ToolServlet?mode=toollist">Tools</a>
	<a href="LogoutServlet" id="logout">Logout</a>
</div>
<div class="main">
	<%
		List<ActivityDTO> list = (List<ActivityDTO> ) request.getAttribute("list");
	%>	
	
<br>

	<table>
		<tr>
			<th>Name</th>
			<th>Time</th>
			<th></th>
			<th></th>
		</tr>
		<%
			for (ActivityDTO u : list) {
		%>
		<tr>
			<td><a href=ActivityServlet?mode=read&id=<%=u.getId() %>>
					<%=u.getName()%>
			</a></td>
			<td><%=u.getTime()%></td>
			<td><a href=ActivityServlet?mode=read&update=true&id=<%=u.getId()%>>Edit</a>		
			</td>
			<td><a href=ActivityServlet?mode=delete&id=<%=u.getId()%>>Delete</a>
			</td>
			
		</tr>
		<%
			}
		%>	
	</table>
		
			
			
<form id="floatright" action="ActivityServlet?mode=insert" method="post">
	<div class="row">
	  <div class="col-25">
	    <label for="activity">Name</label>
	  </div>
	  <div class="col-75">
	     <input type="text" id="activity" name="name" 	placeholder="inserisci name">
	  </div>
	 </div>
	 <div class="row">
	   <div class="col-25">
	    <label for="tim">Time</label>
	   </div>
	   <div class="col-75">
	     <input type="text" id="tim" name="time" placeholder="inserisci time">
	   </div>
	  </div>
	  
	  	<button type="submit" >Insert</button>  		
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>	    	 		      			
</body>
</html>