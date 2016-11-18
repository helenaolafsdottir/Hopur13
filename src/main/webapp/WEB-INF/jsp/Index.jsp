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
		<link href="webjars/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="/css/main.css" rel="stylesheet" type="text/css">
        <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    	<script type="text/javascript">
    	$( document ).ready(function() {
    var heights = $("img").map(function() {
        return $(this).height();
    }).get()
    minHeight = Math.min.apply(null, heights);
	
    $("img").height(minHeight);
});

$( document ).ready(function() {
   
    minWidth = $(".thumbnail").width();
	
    $("img").width(minWidth);
});
    $('ul.nav li.dropdown').hover(function() {
  $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeIn(500);
}, function() {
  $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeOut(500);
});
    	</script>
    	<script src="webjars/bootstrap/3.3.4/js/bootstrap.min.js"></script>
 
        
    </head>
    <body>
      <main>
   <div class="container fluid">
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
          <a href="/recipes" class="dropdrown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Recipes <b class="caret"></b></a>
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

    	<c:forEach var="recipe" items="${recipes}">
    	<div class="col-sm-3 images"> 
    			<div class="caption">
        			<h4>${recipe.recipeName}</h4>
      			</div>		
   		 		<div class="thumbnail"><a href="/recipes/${recipe.id}"><img src="${recipe.image}" class="img-responsive margin"/></a></div>
 </div>
     	</c:forEach>



    	</main>
    	<footer class="footer">
    		<div class="footer-container">
    			<p> Class HBV501G, University of Iceland, Fall 2016</p>
    		</div>
    	</footer>
    </body>
</html>
