<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

<head>
	<title>Uppskriftabankinn</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css"/>"/>  
</head>
<body>
	<header>
	    <ul class="nav">
	        <h1>Uppskriftabankinn</h1><br>
	    	<li><a href="/">Home</a></li>
	    	<li><a href="/recipes">Recipes</a></li>
	    	<li><a href="/userbla">My Page</a></li>
	    	<div class="signupbutton"><li><a href="../userbla">Signup</a></li></div>
    		<div class="loginbutton"><li><a href="#">Login</a></li></div>s
	    </ul>
	</header>
	<main>

		<h1>${recipes.recipeName}</h1>
		
	    <table class="oneRecipe">
	    	<tr>
	    		<td>Ingredients:</td>
	        	<td>${recipes.ingredients}</td>
	        </tr>
	        <tr>
	        	<td>Instructions:</td>
	   	     	<td>${recipes.instructions}</td>
	        </tr>
	        <tr>
	        	<td>Recipe Group:</td>
	   	     	<td>${recipes.recipeGroup}</td>
	        </tr>
	        <tr>
	        	<td>User:</td>
	   	     	<td>${recipes.username}</td>
	        </tr> 
	        <tr>
	        	<td><img src="${recipes.image}"/></td>
	        </tr> 
	     </table>
	</main>
</body>
<footer>Class HBV501G, University of Iceland, Fall 2015</footer>

</html>