<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

<head>
    <title>Create a new recipe!</title>
    
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css"/>"/>
</head>
<body>

	<h1>Create Recipe</h1>
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
	
</body>

</html>