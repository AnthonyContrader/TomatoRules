<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ActivityDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../css/vittoriostyle.css" rel="stylesheet">
<title>Edit Activity</title>
</head>
<body>
<%@ include file="../css/header.jsp" %>
<div class="navbar">
	<a href="homeadmin.jsp">Home</a>
	<a class="active" href="ActivityServlet?mode=activitylist">Activities</a>
	<a href="LogoutServlet" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%ActivityDTO u = (ActivityDTO) request.getAttribute("dto");%>


<form id="floatleft" action="ActivityServlet?mode=update&id=<%=u.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="activity">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="activity" name="name" value=<%=u.getName()%>>
    </div>
   </div>
   <div class="row">
    <div class="col-25">
     <label for="pass">Time</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="tim" name="time" value=<%=u.getTime()%>>
	 </div>		 
    </div>
    <button type="submit" >Edit</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>	 
</body>
</html>