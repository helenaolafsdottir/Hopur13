<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

<head>
    <title>Recipe</title>
    
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css"/>"/>
</head>
<body>

	<h1>${recipes.recipeName}</h1>
	
    <table class="oneRecipe">
    	<tr>
    		<td>Ingredients:</td>
        	<td>${recipes.ingredients}</td>
        </tr>
        <tr>
        	<td>Instructions:</td>
   	     	<td>${recipes.instructions}</td>
        </tr>
        <tr>
        	<td>Recipe Group:</td>
   	     	<td>${recipes.recipeGroup}</td>
        </tr>
        <tr>
        	<td>User:</td>
   	     	<td>${recipes.username}</td>
        </tr> 
        <tr>
        	<td><img src="${recipes.image}"/></td>
        </tr> 
     </table>
     
</body>

</html>