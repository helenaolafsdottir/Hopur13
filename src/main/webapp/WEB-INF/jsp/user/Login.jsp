<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.io.*,java.util.*" %>

<html lang="en">

    <head>
   <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">  
        <title>Uppskriftabankinn</title>
		<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
        <link href="/css/main.css" rel="stylesheet">

        
    </head>
    <body>
		<nav class="navbar navbar-default">
  		<div class="container-fluid">
   		 <!-- Brand and toggle get grouped for better mobile display -->
    	<div class="navbar-header">
     	 <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Uppskriftabankinn</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home<span class="sr-only">(current)</span></a></li>
        <li class="dropdown">
          <a href="/recipes" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Recipes <span class="caret"></span></a>
          	<ul class="dropdown-menu">
            	<li><a href="#">Bakstur</a></li>
            	<li><a href="#">Eftirréttir</a></li>
            	<li><a href="#">Forréttir</a></li>
            	<li><a href="#">Hráfæði</a></li>
            	<li><a href="#">Kvöldmatur</a></li>
            	<li><a href="#">Morgunmatur</a></li>
          	</ul>
        </li>
      </ul>

       		<sf:form class="navbar-form navbar-left" method="POST" commandName="recipe" action="/search">	
       			<div class="form-group">
    				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					
    				<select class="searchcond form-control" name="searchcond">
  						<option value="username">UserName</option>
  						<option value="recipe_name">RecipeName</option>
   						<option value="ingredients">Ingredients</option>
  					</select>
    			    <input class="searchtext form-control" name="search" type="text" placeholder="Leita"/>
        			<input class="searchbutton btn btn-default" type="submit" VALUE="Leita"/>
        			</div>
    		</sf:form>	
     	<ul class="nav navbar-nav navbar-right">
       	 <li><a href="/login">Login</a></li>
       	 <li><a href="/userbla">Signup</a></li>
      	</ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>			
    	</ul>
   				
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
		<section class="create_recipe_form">
			<br>
			<sf:form method="POST" action="/login">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<table class="create_recipe_table">
					<tr>
						<td>Username:</td>
						<td><input name="username" type="text" placeholder="Username here"/></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input name="password" type="password" placeholder="Password here"/></td>
					</tr>
				</table>
				<div class="create_recipe_takki_div"><input class="create_recipe_takki"  type="submit" VALUE="Log In!"/></div>
				<div class="create_recipe_takki_div"><a href="/forgotPassword">Forgot password?</a></div>
			</sf:form>
			<c:choose>
		   		<c:when test="${resultMessage eq null}">
    				
    			</c:when>
    		
    			<c:otherwise>
    				<div>${resultMessage}</div>
    			</c:otherwise>
    		</c:choose>
		</section>
		
		<form class="form-horizontal">
  		<div class="form-group">
    			<label for="inputUsername" class="col-sm-2 control-label">Username</label>
    		<div class="col-sm-6">
      			<input type="text" class="form-control" id="inputUsername" placeholder="Username">
    		</div>
 		</div>
  		<div class="form-group">
    			<label for="inputPassword" class="col-sm-2 control-label">Password</label>
    		<div class="col-sm-6">
      			<input type="password" class="form-control" id="inputPassword" placeholder="Password">
    		</div>
 		</div>
  		<div class="form-group">
    		<div class="col-sm-offset-2 col-sm-10">
      			<button type="submit" class="btn btn-default">Sign in</button>
    		</div>
  		</div>
	</form>	
		
	</main>
	</body>
	<footer class="footer">
    		<div class="footer-container">
    			<p> Class HBV501G, University of Iceland, Fall 2016</p>
    		</div>
    </footer>
    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</html>