<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

    <head>
        <title>Uppskriftabankinn</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css"/>"/>  
        <meta charset="UTF-8"> 
    </head>
    <body>
		<header>
    		<ul class="nav">
    		    <h1>Uppskriftabankinn</h1>
    			<li><a href="/">Home</a></li>
    			<li><a href="/recipes">Recipes</a></li>
    			<li><a href="#">My Page</a></li>
    			
    			<sf:form method="POST" commandName="recipe" action="/search">
    			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>	
    				<select class="searchcond" name="searchcond">
  						<option value="username">UserName</option>
  						<option value="recipe_name">RecipeName</option>
   						<option value="ingredients">Ingredients</option>
  					</select>
    			    <input class="searchtext" name="search" type="text" placeholder="Leita"/>
        			<input class="searchbutton" type="submit" VALUE="Leita"/>
    			</sf:form>
    			
    			<div class="signupbutton"><li><a href="/userbla">Signup</a></li></div>
    			<div class="loginbutton"><li><a href="/login">Login</a></li></div>
    		</ul>
    	</header>
    	<main>
		
    	</main>
    </body>
    <footer>Class HBV501G, University of Iceland, Fall 2015</footer>
</html>
