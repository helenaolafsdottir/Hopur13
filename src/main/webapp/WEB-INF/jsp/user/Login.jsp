<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

<head>
    <title>Log In</title>
    
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/login.css"/>"/>
</head>
<body>

	<h1><a href="/login">Log in</a></h1>
	<sf:form method="POST" action="/login">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<table>
			<tr>
				<td>Username:</td>
				<td><input name="username" type="text" placeholder="Username here"/></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input name="password" type="password" placeholder="Password here"/></td>
			</tr>
		</table>
		
		<input type="submit" VALUE="Innskra mig!"/>
	</sf:form>
</body>

</html>