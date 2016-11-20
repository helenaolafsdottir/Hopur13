<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.io.*,java.util.*"%>

<html lang="en">

<head>
<meta charset="utf-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="webjars/bootstrap/3.3.4/css/bootstrap.min.css"
	rel="stylesheet" media="screen">
<link href="/css/main.css" rel="stylesheet" type="text/css">
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
</head>

<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/">Uppskriftabankinn</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/">Home<span class="sr-only">(current)</span></a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Recipes <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="/recipes">Appetizers</a></li>
						<li><a href="/recipes">Baking</a></li>
						<li><a href="/recipes">Breakfast</a></li>
						<li><a href="/recipes">Desserts</a></li>
						<li><a href="/recipes">Dinner</a></li>
						<li><a href="/recipes">Raw</a></li>
					</ul></li>
				<sf:form class="navbar-form navbar-left" method="POST"
					commandName="recipe" action="/search">
					<div class="form-group">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" /> <select
							class="searchcond form-control" name="searchcond">
							<option value="username">User name</option>
							<option value="recipe_name">Recipe name</option>
							<option value="ingredients">Ingredients</option>
						</select> <input class="searchtext form-control" name="search" type="text"
							placeholder="Search" /> <input
							class="searchbutton btn btn-default" type="submit" VALUE="Search" />
					</div>
				</sf:form>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${loggedInUser eq 'anonymousUser'}">
						<li><a href="/login">Login</a></li>
						<li><a href="/userbla">Signup</a></li>

					</c:when>
					<c:otherwise>
						<p class="navbar-text">
							Signed in as
							<c:out value="${pageContext.request.remoteUser}"></c:out>
						</p>
						<li><a href="/myPage">My Page</a></li>
						<form class="navbar-form navbar-right" role="form"
							action="/logout" method="post">
							<div class="form-group">
								<input class="form-control" type="submit" value="Log out" /> <input
									class="form-control" type="hidden"
									name="${_csrf.parameterName}" value="${_csrf.token}" />
							</div>
						</form>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>