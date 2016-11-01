<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

<head>
    <title>Users</title>
    
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/user.css"/>"/>
</head>
<body>

	<h1><a href="/user">Users</a></h1>
	<sf:form method="POST" commandName="user" action="/userbla">
		<table>
			<tr>
				<td> Name:</td>
				<td><sf:input path="name" type="text" placeholder="Name here"/></td>
			</tr>
			<tr>
				<td>Username:</td>
				<td><sf:textarea path="userName" type="text" placeholder="Username here"/></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><sf:textarea path="password" type="text" placeholder="Password here"/></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><sf:textarea path="email" type="text" placeholder="Email here"/></td>
			</tr>
		</table>
		
		<input type="submit" VALUE="Skra mig!"/>
	</sf:form>
</body>

</html>