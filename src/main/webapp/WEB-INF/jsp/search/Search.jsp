<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.io.*,java.util.*"%>

<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Uppskriftabankinn</title>
<link href="webjars/bootstrap/3.3.4/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/css/main.css" rel="stylesheet">

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("img").width("100%");
	$("img").height(0.8*($("img").width()));
});
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/navbar.jsp" />
	<c:choose>
		<c:when test="${not empty recipes}">
			<c:forEach var="recipe" items="${recipes}">
				<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12 images">
					<div class="caption">
						<h4>${recipe.recipeName}</h4>
					</div>
						<a href="/recipes/${recipe.id}"><img src="${recipe.image}"
							class="img-thumbnail" /></a>
				</div>
			</c:forEach>
		</c:when>

		<%--If all tests are false, then do this--%>
		<c:otherwise>
			<h3 class="text-center">No Recipes Found!</h3>
		</c:otherwise>
	</c:choose>

</body>
<footer class="footer">
	<div class="footer-container">
		<p>Class HBV501G, University of Iceland, Fall 2016</p>
	</div>
</footer>
</html>


