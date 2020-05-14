
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Homepage for Admin ">
<meta name="author" content="Vittorio Valent">

<title>Home</title>

<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/css/vittoriostyle.css" rel="stylesheet">
</head>

<body>
<% 
	request.setAttribute("activesection", "home");

%>

	<%@include file="css/header.jsp"%>
	<%@include file="css/navbar.jsp"%>


	<!--<div class="navbar">
		<a class="active" href="/homeadmin.jsp">Home</a> 
		<a href=/user/getall>Users</a>		 
		<a href=/activity/getall>Activities</a>
		<a href=/category/getall>Categories</a>
		<a href=/tool/getall>Tools</a>
		<a href="/user/logout" id="logout">Logout</a>
	</div>
 	-->
	<div class="main">
		<h1>Welcome ${user.getUsername()}</h1>
		
La Tecnica del Pomodoro nasce con lo scopo primario di insegnare a considerare il tempo, 
invece che come un nemico capace di generare stress e tensioni 
(soprattutto in presenza di scadenze), 
come un valido alleato pronto a consentirci di realizzare qualunque genere di attività 
nel modo desiderato, 
migliorando al contempo il processo di lavoro e studio.
		

	</div>


	<%@ include file="css/footer.jsp"%>

</body>
</html>