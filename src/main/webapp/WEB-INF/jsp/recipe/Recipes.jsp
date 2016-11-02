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

	<h1><a href="/recipes">Recipes</a></h1>
	
    <%--Choose what code to generate based on tests that we implement--%>
    <c:choose>
        <%--If the model has an attribute with the name `postitNotes`--%>
        <c:when test="${not empty recipes}">
            <%--Create a table for the Postit Notes--%>
            <table class="recipelist">

                <%--For each recipes, that is in the list that was passed in the model--%>
                <%--generate a row in the table--%>
                <%--Here we set `recipe` as a singular item out of the list `recipes`--%>
                <c:forEach var="recipe" items="${recipes}">
                    <tr>
                        <%--We can reference attributes of the Entity by just entering the name we gave--%>
                        <%--it in the singular item var, and then just a dot followed by the attribute name--%>

                        <%--Create a link based on the name attribute value--%>
                        <td><a href="/recipes/${recipe.id}">${recipe.recipeName}</a></td>
                        <%--The String in the instructions attribute--%>
                        <td>${recipe.instructions}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>

        <%--If all tests are false, then do this--%>
        <c:otherwise>
            <h3>No recipes!</h3>
        </c:otherwise>
    </c:choose>
</body>

</html>