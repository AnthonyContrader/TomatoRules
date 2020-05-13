<%@ page import="it.contrader.dto.ActivityDTO" import="java.util.*"
		 import="it.contrader.dto.CategoryDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="Activity Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Activity Manager</title>
</head>
<body>
<% 
	request.setAttribute("activesection", "activities");

%>
	<%@ include file="./css/header.jsp"%>
	<%@ include file="./css/navbar.jsp" %>
	
	<div class="main">
		<%
			List<ActivityDTO> list = (List<ActivityDTO>) request.getSession().getAttribute("list");
			List<CategoryDTO> list_C = (List<CategoryDTO>) request.getSession().getAttribute("listCategory");
		%>
		
		<br>

	<table>
		<tr>
			<th>Name</th>
			<th>Time</th>
			<th>Category</th>
			<th></th>
			<th></th> 
		</tr>
		<%
				for (ActivityDTO a : list) {
			%>
			<tr>
				<td><a href="/activity/read?id=<%=a.getId()%>"> <%=a.getName()%>
				</a></td>
				<td><%=a.getTime()%></td>
				<td><%=a.getCategory() %></td>
				<td><a href="/activity/preupdate?id=<%=a.getId()%>">Edit</a></td>


				<td><a href="/activity/delete?id=<%=a.getId()%>">Delete</a></td>

			</tr>
			<%
				}
			%>
		</table>


		<form id="floatright" action="/activity/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="activity">Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="activity" name="name"
						placeholder="inserisci nome">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="tim">Time</label>
				</div>
				<div class="col-75">
					<input type="text" id="tim" name="time"
						placeholder="inserisci tempo">
				</div>
			</div>
			<div class="row">
    		<div class="col-25">
      			<label for="type">Select Category</label>
    		</div>
   		 	<div class="col-75">
 				<select id="category" name="category" required>
 					<option value="" disabled selected>Select Categories</option>
 					<% 			
						for (CategoryDTO c : list_C) {
							%> <option value="<%=c.getId()%>"><%=c.getName()%></option> <%
						}%> 
				</select>
			</div>
			</div>
				
			<button type="submit">Insert</button>
		</form>

	</div>
	<br>
	<%@ include file="./css/footer.jsp"%>
</body>
</html>