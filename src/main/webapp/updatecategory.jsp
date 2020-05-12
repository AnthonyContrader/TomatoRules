<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.contrader.dto.CategoryDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Category Edit page">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Edit Category</title>
</head>
<body>
<%@ include file="./css/header.jsp" %>
<div class="navbar">
  <a href="/homeadmin.jsp">Home</a>
  <a class="active" href="/category/getall">Categories</a>
  <a href="/user/logout" id="logout">Logout</a>
</div>
<br>
<div class="main">

<%CategoryDTO c = (CategoryDTO) request.getSession().getAttribute("dto");%>


<form id="floatleft" action="/category/update" method="post">
  <div class="row">
    <div class="col-25">
      <label for="category">Name</label>
    </div>
    <div class="col-75">
      <input type="text" id="category" name="name" value=<%=c.getName()%>>
    </div>
  </div>
  <div class="row">
    <div class="col-25">
     <label for="pass">Description</label>
    </div>
    <div class="col-75">
      <input
			type="text" id="desc" name="description" value=<%=c.getDescription()%>> 
    </div>
    	<input type="hidden" name="id" value=<%=c.getId() %>>
  </div>
  
      <button type="submit" >Edit</button>
</form>

	
</div>
<br>
<%@ include file="./css/footer.jsp" %>	

</body>
</html>