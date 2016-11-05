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
    			<div><li><a href="/login">Logout</a></li></div>
    		</ul>
    	</header>
    	<main>
		    <h1>Hello <b><c:out value="${pageContext.request.remoteUser}"></c:out></b></h1>
		    <a href="/createRecipe">Create Recipe</a>
		    <h3>Your Recipes:</h3>
		    <c:choose>
		    	<c:when test="${not empty recipes}">
          		 	<section class="uppskriftir">
                		<c:forEach var="recipe" items="${recipes}">
                    		<div class="einUppskrift">
                    			<div class="uppskriftir_mynd">
									<img src=${recipe.image} class="myndFyrirUppskrift">
								</div>
								<section class="uppskriftir_texti">
									<h3>${recipe.recipeName}</h3>
									<a class="forsiduUppskriftirTakki" href="/recipes/${recipe.id}">View Recipe</a>
								</section>
							</div>
                   		</c:forEach>
            		</section>
        		</c:when>

        		<%--If all tests are false, then do this--%>
        		<c:otherwise>
        		    <p>You haven't posted any recipes yet, click on the Create Recipe button to post one right now!</p>
        		</c:otherwise>
   			 </c:choose>
    	</main>
    </body>
    <footer>Class HBV501G, University of Iceland, Fall 2015</footer>
</html>
