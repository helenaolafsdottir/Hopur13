<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html lang="en">

    <head>
        <title>Uppskriftabankinn</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css"/>"/>  
    </head>
    <body>
		<header>
    		<ul class="nav">
    		    <h1>Uppskriftabankinn</h1>
    			<li><a href="#">Home</a></li>
    			<li><a href="/recipes">Recipes</a></li>
    			<li><a href="/userbla">My Page</a></li>
    			<div class="signupbutton"><li><a href="#">Signup</a></li></div>
    			<div class="loginbutton"><li><a href="#">Login</a></li></div>
    		</ul>
    	</header>
    	<main>
    		<section class="kynning">
    		<p>Uppskriftabankinn is a fun place for every food lover.</p>
    		<p>Here you can share your favourite recipes with the world and get great ideas from other food lovers.</p>
		
		    <ul>
		        <li><a href="/recipes">Click to get a list of all the recipes</a></li>
		        <li><a href="/userbla">Click to sign up to Uppskriftabankinn</a></li>
		        <li><a href="/createRecipe">Click to create a new recipe</a></li>
		    </ul>
		    </section>
    	</main>
    </body>
    <footer>Class HBV501G, University of Iceland, Fall 2015</footer>
</html>
