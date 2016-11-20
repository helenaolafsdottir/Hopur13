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


</head>
<body>
	<jsp:include page="/WEB-INF/jsp/navbar.jsp" />

	<section class="outer-wrapper">

		<div class="inner-wrapper">
			<div class="container">
				<div class="row">
					<div class="col-sm-4 col-sm-offset-4">
						<sf:form class="form-horizontal" commandName="login"
							action="/login">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />


							<div class="form-group">
								<label class="control-label">Username</label> <input
									name="username" type="text" class="form-control" id="username"
									placeholder="Enter Your Username" /> <br>
								<%-- 									<sf:errors path="username" class="control-label" /> --%>

							</div>



							<div class="form-group">
								<label class="control-label">Password</label> <input
									name="password" type="password" class="form-control"
									id="password" placeholder="Enter Password" /> <br>
								<%-- 									<sf:errors path="password" class="control-label" /> --%>

							</div>


							<div class="text-right">
								<button type="submit" class="myButton">Login!</button>
							</div>
						</sf:form>

					</div>
				</div>
			</div>
		</div>
		<c:choose>
	   		<c:when test="${resultMessage eq null}">
				
			</c:when>
		
			<c:otherwise>
				<div>${resultMessage}</div>
			</c:otherwise>
		</c:choose>
		<div class="create_recipe_takki_div"><a href="/forgotPassword">Forgot password?</a></div>
	</section>
</body>
<footer class="footer">
	<div class="footer-container">
		<p>Class HBV501G, University of Iceland, Fall 2016</p>
	</div>
</footer>

</html>