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
    	    <h1>Uppskriftabankinn</h1>
    		<li><a href="/">Home</a></li>
    		<li><a href="/recipes">Recipes</a></li>
    		<li><a href="/myPage">My Page</a></li>
    		
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
	<section class="create_recipe_form">
		<h2>Create Your Recipe</h2>
		<sf:form method="POST" commandName="recipe" action="/createRecipe">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<table class="create_recipe_table">
				<tr>
					<td>Recipe Name:</td>
					<td><sf:input path="recipeName" type="text" placeholder="Recipe Name here"/></td>
				</tr>
				<tr>
					<td>Recipe group:</td>
					<td>
						<sf:select path="recipeGroup">
							<sf:option value="Kaka" label="Kaka"/>
							<sf:option value="Matur" label="matur"/>
						</sf:select>
					</td>
				</tr>
				<tr>
					<td>Ingredients:</td>
					<td><sf:input path="ingredients" type="text" placeholder="List the ingredients here"/></td>
				</tr>
				<tr>
					<td class="instruction_text">Instructions:</td>
					<td><sf:textarea class="instructions" path="instructions" type="text" placeholder="Instructions here"/></td>
				</tr>
				<tr>
					<td>Image:</td>
					<td><sf:input path="image" type="textarea" placeholder="Image url here"/></td>
				</tr>
				<tr>
					<td>Username:</td>
					<td><sf:input path="username" type="textarea" placeholder="username here"/></td>
				</tr>
			</table>
			<div class="create_recipe_takki_div"><input class="create_recipe_takki" type="submit" VALUE="Save Recipe!"/></div>
		</sf:form>
		</section>
	</main>	
</body>
<footer>Class HBV501G, University of Iceland, Fall 2015</footer>

</html>