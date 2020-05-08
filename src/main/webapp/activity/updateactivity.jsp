<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.ActivityDTO" import="java.util.List"
    import="it.contrader.dto.CategoryDTO"%>
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

<%ActivityDTO c = (ActivityDTO) request.getAttribute("dto");
CategoryDTO u = (CategoryDTO) request.getAttribute("categorydto");
List<CategoryDTO> listCategory = (List<CategoryDTO>) request.getAttribute("listCategory");
%>


<form id="floatleft" action="ActivityServlet?mode=update&id=<%=c.getId()%>" method="post">
  <div class="row">
    <div class="col-25">
      <label for="activity">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="activity" name="name" value=<%=c.getName()%>>
    </div>
   </div>
   <div class="row">
    <div class="col-25">
     <label for="pass">Time</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="tim" name="time" value=<%=c.getTime()%>>
	 </div>		 
    </div>
    <div class="row">
		<div class="col-25">
			<label for="type">Select Category</label>
		</div>
		<div class="col-75">
			<select id="category" name="rest" required>
				<option value="" disabled selected>Select Categories</option>
				<%
					for (CategoryDTO a : listCategory) {
				%>
				<option value="<%=a.getId()%>"><%=a.getName()%></option>
				<% 
					}
				%>
			</select>
		</div>
	</div>
    <button type="submit" >Edit</button>
</form>

</div>
<br>
<%@ include file="../css/footer.jsp" %>	 
</body>
</html>