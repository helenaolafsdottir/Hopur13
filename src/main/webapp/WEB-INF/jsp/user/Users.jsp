<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
    <head>
        <title>Uppskriftabankinn</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css"/>"/>
        <meta charset="UTF-8">   
    </head>
    <body>
		<header>
    		<ul class="nav">
    		    <h1>Uppskriftabankinn</h1>
    			<li><a href="/">Home</a></li>
    			<li><a href="/recipes">Recipes</a></li>
    			<li><a href="/myPage">My Page</a></li>
    			
    			<sf:form method="POST" commandName="recipe" action="/search">	
    			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    				<select class="searchcond" name="searchcond">
  						<option value="username">UserName</option>
  						<option value="recipe_name">RecipeName</option>
   						<option value="ingredients">Ingredients</option>
  					</select>
    			    <input class="searchtext" name="search" type="text" placeholder="Leita"/>
        			<input class="searchbutton" type="submit" VALUE="Leita"/>
    			</sf:form>
    			
    			<div class="signupbutton"><li><a href="/userbla">Signup</a></li></div>
    			<c:choose>
		    		<c:when test="${loggedInUser eq 'anonymousUser'}">
    					<div class="loginbutton"><li><a href="/login">Login</a></li></div>
    				</c:when>
    			
    				<c:otherwise>
    					<form action="/logout" method="post"><input type="submit" value="Log out"/>
    						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    					</form>
    				</c:otherwise>
    			</c:choose>
    		</ul>
    	</header>
    	<main>
    		<br>
			<section class="create_recipe_form">
				<sf:form method="POST" modelAttribute="user" action="/userbla">
					<input type="hidden"
						name="${_csrf.parameterName}"
						value="${_csrf.token}"/>
					<table class="create_recipe_table">
						<tr>
							<td> Name:</td>
							<td>
							<spring:bind path="name">
								<sf:input path="name" type="text" placeholder="Name here"/>
								<sf:errors path="name"/>
							</spring:bind>	
							</td>
							
						</tr>
						<tr>
							<td>Username:</td>
							<td><sf:input path="userName" type="text" placeholder="Username here"/></td>
							<td>&nbsp; &nbsp; &nbsp;</td>
							<td><sf:errors path="userName" cssClass="error" /></td>
						</tr>
						<tr>
							<td>Password:</td>
							<td><sf:input name="password" type="password" path="password" placeholder="Password here"/></td>
							<td>&nbsp; &nbsp; &nbsp;</td>
							<td><sf:errors path="password" cssClass="error" /></td>
						</tr>
						<tr>
							<td>Confirm Password:</td>
							<td><sf:input name="password" type="password" path="passwordConfirm" placeholder="Retype password"/></td>
							<td>&nbsp; &nbsp; &nbsp;</td>
							<td><sf:errors path="passwordConfirm" cssClass="error" /></td>
						</tr>
						<tr>
							<td>Email:</td>
							<td><sf:input path="email" type="text" placeholder="Email here"/></td>
							<td>&nbsp; &nbsp; &nbsp;</td>
							<td><sf:errors path="email" cssClass="error" /></td>
						</tr>
					</table>
					<div class="create_recipe_takki_div"><input class="create_recipe_takki"  type="submit" VALUE="Sign Up!"/></div>
				</sf:form>
				<c:choose>
			   		<c:when test="${resultMessage eq null}">
  					</c:when>
  					<c:otherwise>
    					<div>${resultMessage}</div>
    				</c:otherwise>
    			</c:choose>
			</section>
		</main>
	</body>
	<footer>Class HBV501G, University of Iceland, Fall 2015</footer>
</html>
