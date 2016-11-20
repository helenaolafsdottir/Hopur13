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
			<div class="container" >
				<div class="row">
					<h2 class="text-center">Create Your Recipe</h2>
					<div class="col-sm-4 col-sm-offset-4">
						<sf:form class="form-horizontal" commandName="recipe"
							action="/createRecipe">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />

							<spring:bind path="recipeName">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<label class="control-label">Recipe Name</label>

									<sf:input path="recipeName" type="text" class="form-control"
										id="recipename" placeholder="Enter Clever Recipe Name" />
									<br>
									<sf:errors path="recipeName" class="control-label" />

								</div>
							</spring:bind>

							<spring:bind path="recipeGroup">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<label class="control-label">Recipe group</label>

									<sf:select path="recipeGroup" class="form-control">
										<sf:option value="appetizer" label="Appetizer" />
										<sf:option value="baking" label="Baking" />
										<sf:option value="breakfast" label="Breakfast" />
										<sf:option value="dessert" label="Dessert" />
										<sf:option value="dinner" label="Dinner" />
										<sf:option value="raw" label="Raw" />
									</sf:select>

								</div>
							</spring:bind>

							<spring:bind path="ingredients">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<label class="control-label">Ingredients</label>

									<sf:textarea style="resize:none" path="ingredients" rows="5"
										class="form-control" id="ingredients"
										placeholder="List the ingredients used. Put each ingredient in a single line." />
									<br>
									<sf:errors path="ingredients" class="control-label" />

								</div>
							</spring:bind>

							<spring:bind path="instructions">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<label class="control-label">Instructions</label>

									<sf:textarea style="resize:none" path="instructions" rows="5"
										class="form-control" id="instructions"
										placeholder="Enter each step used to prepare this masterpiece. Use new lines for each step." />
									<br>
									<sf:errors path="instructions" class="control-label" />

								</div>
							</spring:bind>

							<spring:bind path="image">
								<div class="form-group ${status.error ? 'has-error' : ''}">
									<label class="control-label">Picture</label>

									<sf:input path="image" type="text" class="form-control"
										id="image" placeholder="Upload an image of your creation." />
									<br>
									<sf:errors path="image" class="control-label" />

								</div>
							</spring:bind>
							<div class="text-right">
								<button align="right" type="submit" class="myButton">Save
									Recipe!</button>
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