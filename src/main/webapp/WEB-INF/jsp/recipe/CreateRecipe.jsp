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
    		<div class="signupbutton"><li><a href="#">Signup</a></li></div>
    			<div class="loginbutton"><li><a href="#">Login</a></li></div>
    	</ul>
    </header>
	<main>
		<sf:form method="POST" commandName="recipe" action="/createRecipe">
			<table>
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
					<td><sf:input path="ingredients" type="text" placeholder="Ingredients here"/></td>
				</tr>
				<tr>
					<td>Instructions:</td>
					<td><sf:input path="instructions" type="textarea" placeholder="Instructions here"/></td>
				</tr>
				<tr>
					<td>Image:</td>
					<td><sf:input path="image" type="textarea" placeholder="Image url here"/></td>
				</tr>
				<tr>
					<td>username:</td>
					<td><sf:input path="username" type="textarea" placeholder="username here"/></td>
				</tr>
			</table>
			<input type="submit" VALUE="Save Recipe!"/>
		</sf:form>
	</main>	
</body>
<footer>Class HBV501G, University of Iceland, Fall 2015</footer>

</html>