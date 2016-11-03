<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

    <head>
        <title>Search</title>

        <link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css"/>"/>
    </head>
    <body>
		<h1>Search</h1>

    <%--Note that the `commandName` given here HAS TO MATCH the name of the attribute--%>
    <%--that is added to the model that is passed to the view.--%>
    <%--See PostitNoteController, method postitNoteViewGet(), and find where this attribute is added to the model.--%>

	<c:choose>
        <%--If the model has an attribute with the name `postitNotes`--%>
        <c:when test="${not empty recipes}">
            <%--Create a table for the Postit Notes--%>
            <table class="recipelist">

                <%--For each recipe, that is in the list that was passed in the model--%>
                <%--generate a row in the table--%>
                <%--Here we set `recipe` as a singular item out of the list `postitNotes`--%>
                <c:forEach var="recipe" items="${recipes}">
                    <tr>
                        <%--We can reference attributes of the Entity by just entering the name we gave--%>
                        <%--it in the singular item var, and then just a dot followed by the attribute name--%>

						<%--Create a link based on the name attribute value--%>
                        <td><a href="/recipes/${recipe.id}">${recipe.recipeName}</a></td>
                     
                    
                       <%--The String in the note attribute--%>
                        <td>${recipe.username}</td>
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


