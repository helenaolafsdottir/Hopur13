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
		<sf:form method="POST" action="/forgotPassword">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<table class="create_recipe_table">
					<tr>
						<td>Email:</td>
						<td><input name="emailForgot" type="email" placeholder="Email here"/></td>
					</tr>
				</table>
				<input type="submit" VALUE="Send email"/>
		</sf:form>
			<c:choose>
		   		<c:when test="${resultMessage eq null}">
    				
    			</c:when>
    		
    			<c:otherwise>
    				<div>${resultMessage}</div>
    			</c:otherwise>
    		</c:choose>
	</main>
</body>

</html>