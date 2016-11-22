<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.io.*,java.util.*"%>

<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Uppskriftabankinn</title>
<link
	href="http://localhost:8080/webjars/bootstrap/3.3.4/css/bootstrap.min.css "
	rel="stylesheet">
<link href="/css/main.css" rel="stylesheet">
<script src="http://localhost:8080/webjars/jquery/1.9.1/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/navbar.jsp" />



	<div class="single">
		<div class="container">
			<div class="col-md-8 single-main">
				<h1 class="text-center">${recipes.recipeName}</h1>
				<div class="single-grid text-left">
					<img src="${recipes.image}" alt="" class="img-responsive" />
				</div>
				<div class="text-left">
					<p>
						<strong style="margin-top: 35px" class="fl">${recipes.recipeGroup} created by <strong
							class="fl"> ${recipes.username}</strong></strong>
					</p>
					<p style="margin-top: 35px">
						<strong>Instructions:</strong>
					</p>
					<pre>${recipes.instructions}</pre>
				</div>
			</div>

			<div class="col-md-4 sidebar-outer">
				<div class="sidebar">
					<h3 class="text-center">Ingredients</h3>
					<pre>${recipes.ingredients}</pre>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>

	<div class="container"></div>
</body>
<footer class="footer">
	<div class="footer-container">
		<p>Class HBV501G, University of Iceland, Fall 2016</p>
	</div>
</footer>

</html>