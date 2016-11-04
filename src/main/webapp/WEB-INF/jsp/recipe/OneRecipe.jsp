<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

<head>
	<title>Uppskriftabankinn</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css"/>"/>
    <meta charset="UTF-8">   
</head>
<body>
	<header>
	    <ul class="nav">
	        <h1>Uppskriftabankinn</h1><br>
	    	<li><a href="/">Home</a></li>
	    	<li><a href="/recipes">Recipes</a></li>
	    	<li><a href="/myPage">My Page</a></li>
	    	
	    	<sf:form method="POST" commandName="recipe" action="/search">	
    			<select class="searchcond" name="searchcond">
  					<option value="username">UserName</option>
  					<option value="recipe_name">RecipeName</option>
   					<option value="ingredients">Ingredients</option>
  				</select>
    		    <input class="searchtext" name="search" type="text" placeholder="Leita"/>
        		<input class="searchbutton" type="submit" VALUE="Leita"/>
    		</sf:form>
	    	
	    	<div class="signupbutton"><li><a href="../userbla">Signup</a></li></div>
    		<div class="loginbutton"><li><a href="../login">Login</a></li></div>s
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