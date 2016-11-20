<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.io.*,java.util.*" %>

<html lang="en">

    <head>
   <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">  
        <title>Uppskriftabankinn</title>
		<link href="webjars/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
        <link href="/css/main.css" rel="stylesheet">

        
    </head>
    <body>
		<jsp:include page="/WEB-INF/jsp/navbar.jsp" />		
 

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
</body>
<footer class="footer">
	<div class="footer-container">
		<p>Class HBV501G, University of Iceland, Fall 2016</p>
	</div>
</footer>

</html>