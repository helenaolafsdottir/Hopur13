<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

<head>
<title>Uppskriftabankinn</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/main.css"/>" />
<meta charset="UTF-8">
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

	<h1 class="text-center">
		Hello <b><c:out value="${pageContext.request.remoteUser}"></c:out></b>
	</h1>

	<div class="btn-group btn-group-justified text-center">
		<a href="/createRecipe" class="myButton">Create Recipe</a>
		<a href="/changePassword" class="myButton">Change password</a>
		<a href="/favourite" class="myButton">Favourite</a>
		<a href="/following" class="myButton">Following</a>
	</div>


	<c:choose>

		<c:when test="${not empty recipes}">
			<h3 class="text-left">Your Recipes:</h3>
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
			<h3 class="text-center">You haven't posted any recipes yet, click on the Create Recipe
				button to post one right now!</h3>
		</c:otherwise>
	</c:choose>
</body>
<footer class="footer">
	<div class="footer-container">
		<p>Class HBV501G, University of Iceland, Fall 2016</p>
	</div>
</footer>
</html>
