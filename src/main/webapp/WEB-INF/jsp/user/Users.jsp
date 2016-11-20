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
						<sf:form class="form-horizontal" method="POST"
							modelAttribute="user" action="/userbla">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />

							<spring:bind path="name">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<label class="control-label">Name</label>

									<sf:input path="name" type="text" class="form-control"
										id="name" placeholder="Your Name" />
									<br>
									<sf:errors path="name" class="control-label" />

								</div>
							</spring:bind>

							<spring:bind path="userName">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<label class="control-label">Username</label>

									<sf:input style="resize:none" path="userName"
										class="form-control" id="userName"
										placeholder="Choose a Username" />
									<br>
									<sf:errors path="userName" class="control-label" />

								</div>
							</spring:bind>

							<spring:bind path="password">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<label class="control-label">Password</label>

									<sf:input path="password" type="password" class="form-control"
										id="password" placeholder="Choose a Password" />
									<br>
									<sf:errors path="password" class="control-label" />

								</div>
							</spring:bind>

							<spring:bind path="password">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<label class="control-label">Confirm Password</label>
									<sf:input name="password" class="form-control" type="password"
										path="passwordConfirm" placeholder="Retype Password" />
									<br>
									<sf:errors path="passwordConfirm" class="control-label" />

								</div>
							</spring:bind>

							<spring:bind path="email">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<label class="control-label">Email</label>

									<sf:input path="email" type="text" class="form-control"
										id="email" placeholder="Enter Your Email" />
									<br>
									<sf:errors path="email" class="control-label" />

								</div>
							</spring:bind>
							<div class="text-right">
								<button align="right" type="submit" class="myButton">Sign Up</button>
							</div>
						</sf:form>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
<footer class="footer">
	<div class="footer-container">
		<p>Class HBV501G, University of Iceland, Fall 2016</p>
	</div>
</footer>
</html>
