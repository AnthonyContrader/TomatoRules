<%@ page import="it.contrader.dto.CategoryDTO" import="java.util.*"
		 import="it.contrader.dto.ToolDTO"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Category Management">
<meta name="author" content="Vittorio Valent">
<link href="/css/vittoriostyle.css" rel="stylesheet">
<title>Category Manager</title>
</head>
<body>
<% 
	request.setAttribute("activesection", "categories");

%>
	<%@ include file="./css/header.jsp"%>
	<%@ include file="./css/navbar.jsp" %>
	
	<div class="main">
		<% 
		List<CategoryDTO> list = (List<CategoryDTO>) request.getSession().getAttribute("list");
		List<ToolDTO> list_T = (List<ToolDTO>) request.getSession().getAttribute("listTool");
		%>
		
		<br>
		
		<table>
		
			<thead>
		 	<tr>
				<th>Name</th>
				<th>Description</th>
				<th>Tool</th>
				<th></th>
				<th></th>
			</tr>
			</thead>
			<tbody>
			<%
				for (CategoryDTO c : list) {
			%>
			<tr>
				<td><a href="/category/read?id=<%=c.getId()%>"> <%=c.getName()%>
				</a></td>
				<td><%=c.getDescription()%></td>
				<td><%=c.getTool().getName() %></td>
				<td><a href="/category/preupdate?id=<%=c.getId()%>">
						<img src="/css/fettine.gif" width=40 height=40 alt="Edit" title="Edit"></a></td>
				<td><a href="/category/delete?id=<%=c.getId()%>">
						<img src="/css/cesto.gif" width=40 height=40 alt="Delete" title="Delete"></a></td>

			</tr>
			<%
				}
			%>
			</tbody>
			<tfoot>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</tfoot>
		</table>
		
		
		<form id="floatright" action="/category/insert" method="post">
			<div class="row">
				<div class="col-25">
					<label for="category">Name</label>
				</div>
				<div class="col-75">
					<input type="text" id="category" name="name"
						placeholder="inserisci nome">
				</div>
			</div>
			<div class="row">
				<div class="col-25">
					<label for="desc">Description</label>
				</div>
				<div class="col-75">
					<input type="text" id="desc" name="description"
						placeholder="inserisci descrizione">
				</div>
			</div>
			<div class="row">
    		<div class="col-25">
      			<label for="type">Select Tool</label>
    		</div>
   		 	<div class="col-75">
 				<select id="tool" name="tool" required>
 					<option value="" disabled selected>Select Tools</option>
 					<% 			
						for (ToolDTO t : list_T) {
							%> <option value="<%=t.getId()%>"><%=t.getName()%></option> <%
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