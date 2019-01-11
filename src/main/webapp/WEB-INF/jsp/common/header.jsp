<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title><c:out value="${pageTitle}" /></title>
		<link rel="stylesheet" type="text/css" href="css/site.css" />
	</head>
	
	<body>
		
		<div class="page-header">
			<header>
				<h1>National Park Geek</h1>
			</header>
			<nav>
				<c:url var="homeURL" value="/" />
				<c:url var="surveyURL" value="/getSurvey" />
				<ul>
					<li><a href="${homeURL}">Home</a></li>
					<li><a href="${surveyURL}">Survey</a></li>
				</ul>
			</nav>
		</div>