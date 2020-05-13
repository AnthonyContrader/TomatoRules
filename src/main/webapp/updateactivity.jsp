<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1" import="java.util.*" import="it.contrader.dto.ActivityDTO"
	import="it.contrader.dto.CategoryDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Activity Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Activity</title>
</head>
<body>
<%@ include file="./css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/activity/getall">Activities</a>
  <a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%ActivityDTO a = (ActivityDTO) request.getSession().getAttribute("dto");
List<CategoryDTO> list_C = (List<CategoryDTO>) request.getSession().getAttribute("listCategory");
%>


<form id="floatleft" action="/activity/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="activity">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="activity" name="name" value="<%=a.getName()%>">
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="tim">Time</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="tim" name="time" value="<%=a.getTime()%>"> 
    </div>
    	<input type="hidden" name="id" value =<%=a.getId() %>>
  </div>
  <div class="row">
    <div class="col-25">
      <label for="category">Category</label>
    </div>
   		 <div class="col-75">
 			<select id="category" name="category">
 				<%
					for (CategoryDTO c : list_C) {
				%>
					<option value="<%=c.getId()%>"  <%if(c.getId()==a.getCategory().getId()) {%>selected<%} %>  ><%=c.getName()%></option>
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
<%@ include file="./css/footer.jsp" %>	
</body>
</html>