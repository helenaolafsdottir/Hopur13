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
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/css/main.css" rel="stylesheet">

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var heights = $("img").map(function() {
			return $(this).height();
		}).get()
		minHeight = Math.min.apply(null, heights);

		$("img").height(minHeight);
	});

	$(document).ready(function() {

		minWidth = $(".thumbnail").width();

		$("img").width(minWidth);
	});
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/navbar.jsp" />
	<c:choose>
		<c:when test="${not empty recipes}">
			<c:forEach var="recipe" items="${recipes}">
				<div class="col-sm-3 images">
					<div class="caption">
						<h4>${recipe.recipeName}</h4>
					</div>
					<div class="thumbnail">
						<a href="/recipes/${recipe.id}"><img src="${recipe.image}"
							class="img-responsive margin" /></a>
					</div>
				</div>
			</c:forEach>
		</c:when>

		<%--If all tests are false, then do this--%>
		<c:otherwise>
			<h3>No Recipes Found!</h3>
		</c:otherwise>
	</c:choose>

</body>
<footer class="footer">
	<div class="footer-container">
		<p>Class HBV501G, University of Iceland, Fall 2016</p>
	</div>
</footer>
</html>


