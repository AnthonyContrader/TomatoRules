<%@ page import="it.contrader.dto.ToolDTO" import="java.util.*"%>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport"       content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description"    content="Tool Management">
		<link href="/css/vittoriostyle.css" rel="stylesheet">
		<title>Tool Manager</title>
	</head>
	<body>
	<% 
	
	request.setAttribute("activesection", "tools");

	%>
		<%@ include file="./css/header.jsp"%>
		<%@ include file="./css/navbar.jsp"%>
		
		<div class="main">
			<%
				List<ToolDTO> list = (List<ToolDTO>) request.getSession().getAttribute("list");
			%>
		<br>
			<table>
			
				<thead>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th></th>
					<th></th>
				</tr>
				</thead>
				<tbody>
				<%
					for (ToolDTO t : list) {
				%>
				<tr>
					<td><a href="/tool/read?id=<%=t.getId()%>"> <%=t.getName()%> </a></td>
					<td><%=t.getDescription()%></td>
					<td><a href="/tool/preupdate?id=<%=t.getId()%>">
						<img src="/css/fettine.gif" width=40 height=40 alt="Edit" title="Edit"></a></td>
					<td><a href="/tool/delete?id=<%=t.getId()%>">
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
				</tr>
			</tfoot>
		</table>
		
		
			<form id="floatright" action="/tool/insert" method="post">
				<div class="row">
					<div class="col-25">
						<label for="tool_name">Name</label>
					</div>
					<div class="col-75">
						<input type="text" id="tool_name" name="name"
							placeholder="inserisci il nome">
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="tool_description">Description</label>
					</div>
					<div class="col-75">
						<input type="text" id="tool_description" name="description"
							placeholder="inserisci la descrizione">
					</div>
				</div>
				<button type="submit">Insert</button>
			</form>
		</div>
		<br>
		<%@ include file="./css/footer.jsp"%>
	</body>
</html>
