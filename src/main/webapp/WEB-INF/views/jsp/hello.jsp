<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Maven + Spring MVC</title>
 
<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>
 <script type="text/javascript" src="/resources/core/js/angular.min.js"></script>
 <script type="text/javascript" src="/resources/core/js/hello.js"></script>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">Spring 3 MVC Project</a>
	</div>
  </div>
</nav>
 
<div class="jumbotron">
  <div class="container">
	<h1>${title}</h1>
	<p>
		<c:if test="${not empty name}">
			Hello ${name}
		</c:if>
 
		<c:if test="${empty name}">
			Welcome Welcome!
		</c:if>
    </p>
    <p>
		<a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
	</p>
	</div>
</div>


	<h1>Title : ${title}</h1>	
	<h1>Message : ${message}</h1>	

<div ng-app="myApp">
<div  ng-controller="employeecontroller" class="form-horizontal" >
 <div class="col-lg-12 col-sm-12 col-xs-12 alert alert-success" ng-show="successMessagebool ">
        <strong>{{successMessage }}</strong>
</div>
<div class="col-lg-12 col-sm-12 col-xs-12 alert alert-danger" ng-show="errorMessagebool ">
        <strong>{{errorMessage }}</strong>
</div>

<div class="form-group">
    <label class="control-label col-sm-2" for="name">Name :</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="name" ng-model="name" placeholder="Enter Name">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="age">Age : </label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="age" ng-model="age" placeholder="Enter Age">
    </div>
  </div>
<div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="button" class="btn btn-primary" ng-click="Submit()">Submit</button>
    </div>

</div>
	<table ng-controller="myCtrl" class="table table-striped table-bordered table-hover table-responsive table-sm">
		<thead class="thead-inverse">
			<tr>
				<th>Name</th>
				<th>Age</th>
			</tr>
		</thead> 
		<tbody>
			<tr ng-repeat="x in records">
				<td>{{x.name}}</td>
				<td>{{x.age}}</td>
			</tr>
			</tbody>
	</table>
</div>
<div class="container">
 
  <div class="row">
	<div class="col-md-4">
		<h2>Heading</h2>
		<p>ABC</p>
		<p>
			<a class="btn btn-default" href="#" role="button">View details</a>
		</p>
	</div>
	<div class="col-md-4">
		<h2>Heading</h2>
		<p>ABC</p>
		<p>
			<a class="btn btn-default" href="#" role="button">View details</a>
		</p>
	</div>
	<div class="col-md-4">
		<h2>Heading</h2>
		<p>ABC</p>
		<p>
			<a class="btn btn-default" href="#" role="button">View details</a>
		</p>
	</div>
  </div>
 
 
  <hr>
  <footer>
	<p>&copy; Mkyong.com 2015</p>
  </footer>
</div>
 
<spring:url value="/resources/core/css/hello.js" var="coreJs" />
<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" />
 
<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
 
</body>
</html>