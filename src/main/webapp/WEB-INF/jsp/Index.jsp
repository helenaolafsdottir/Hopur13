<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>i


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
		    <section class="forsiduUppskriftir">
		    	<h2>Vins�lar K�kuuppskriftir</h2>
		    	<section class="forsiduUppskrift1">
		    		<a href="/recipes/${recipe1.id}"><img src="${recipe1.image}"/></a>
		    		<h3>${recipe1.recipeName}</h3>
		    		<a href="/recipes/${recipe1.id}" class="forsiduUppskriftirTakki">Sko�a uppskrift</a>
		    	</section>
		    	<section class="forsiduUppskrift2">
		    		<a href="/recipes/${recipe2.id}"><img src="${recipe2.image}"/></a>
		    		<h3>${recipe2.recipeName}</h3>
		    		<a href="/recipes/${recipe2.id}" class="forsiduUppskriftirTakki">Sko�a uppskrift</a>
		    	</section>
		    	<section class="forsiduUppskrift3">
		    		<a href="/recipes/${recipe3.id}"><img src="${recipe3.image}"/></a>
		    		<h3>${recipe3.recipeName}</h3>
		    		<a href="/recipes/${recipe3.id}" class="forsiduUppskriftirTakki">Sko�a uppskrift</a>
		    	</section>
		    	<h2>Vins�lir R�ttir</h2>
		    	<section class="forsiduUppskrift4">
		    		<a href="/recipes/${recipe4.id}"><img src="${recipe4.image}"/></a>
		    		<h3>${recipe4.recipeName}</h3>
		    		<a href="/recipes/${recipe4.id}" class="forsiduUppskriftirTakki">Sko�a uppskrift</a>
		    	</section>
		    	<section class="forsiduUppskrift5">
		    		<a href="/recipes/${recipe5.id}"><img src="${recipe5.image}"/></a>
		    		<h3>${recipe5.recipeName}</h3>
		    		<a href="/recipes/${recipe5.id}" class="forsiduUppskriftirTakki">Sko�a uppskrift</a>
		    	</section>
		    	<section class="forsiduUppskrift6">
		    		<a href="/recipes/${recipe6.id}"><img src="${recipe6.image}"/></a>
		    		<h3>${recipe6.recipeName}</h3>
		    		<a href="/recipes/${recipe6.id}" class="forsiduUppskriftirTakki">Sko�a uppskrift</a>
		    	</section>
		    </section>
    	</main>
    </body>
    <footer>Class HBV501G, University of Iceland, Fall 2015</footer>
</html>
