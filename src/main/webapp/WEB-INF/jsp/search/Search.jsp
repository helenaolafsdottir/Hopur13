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
    		    <h1>Uppskriftabankinn</h1>
    			<li><a href="/">Home</a></li>
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
		    <%--Note that the `commandName` given here HAS TO MATCH the name of the attribute--%>
		    <%--that is added to the model that is passed to the view.--%>
		    <%--See PostitNoteController, method postitNoteViewGet(), and find where this attribute is added to the model.--%>
		
			<c:choose>
		        <%--If the model has an attribute with the name `postitNotes`--%>
		        <c:when test="${not empty recipes}">
		            <%--Create a table for the Postit Notes--%>
		            <div class="uppskriftir">
		
		                <%--For each recipe, that is in the list that was passed in the model--%>
		                <%--generate a row in the table--%>
		                <%--Here we set `recipe` as a singular item out of the list `postitNotes`--%>
		                <c:forEach var="recipe" items="${recipes}">
							<div class="uppskriftir_mynd">
									<img src=${recipe.image} class="myndFyrirUppskrift">
							</div>
							<section class="uppskriftir_texti">
									
									<h3>${recipe.recipeName}</h3>
									<a class="forsiduUppskriftirTakki" href="/recipes/${recipe.id}">Sko�a Uppskrift</a>
							</section>
							<p>${recipe.recipeName}</p>
		                </c:forEach>
		            </div>
		        </c:when>
		        <c:otherwise>
		            <h3>No recipes!</h3>
		        </c:otherwise>
		    </c:choose>
		</main>
		<footer>Class HBV501G, University of Iceland, Fall 2015</footer>
    </body>
</html>


