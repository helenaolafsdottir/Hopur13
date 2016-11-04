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
		
	    <div class="one_recipe">
	    	<td><img class="uppskrift_mynd" src="${recipes.image}"/></td>
	    	<div class="uppskrift_texti">
	    		<p><strong>Ingredients:</strong></p>
	       		<p>${recipes.ingredients}</p>

        		<p><strong>Instructions:</strong></p>
   	    	 	<p>${recipes.instructions}</p>

        		<p><strong>Recipe Group: </strong>${recipes.recipeGroup}</p>

        		<p><strong>User: </strong>${recipes.username}</p>
	        </div> 

	        	
	     </div>
	</main>
</body>
<footer>Class HBV501G, University of Iceland, Fall 2015</footer>

</html>