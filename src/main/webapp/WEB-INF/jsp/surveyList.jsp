<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:set var="pageTitle" value="Favorite Parks" />
<%@include file="common/header.jsp" %>

<c:forEach var="sr" items="${surveyResults}">
	 <c:set var = "parkCodeLowerCase" value = "${fn:toLowerCase(sr.parkCode)}" /> 
	<table>
		<tr>
			<td rowspan="2">
				<img src="img/parks/${parkCodeLowerCase}.jpg" />
			</td>
			<td>
				<p>${sr.parkName}</p>
			</td>
		</tr>
		<tr>
			<td>
				<p>Number of people who thought this park was awesomesauce: <c:out value="${sr.count}" />.</p>
			</td>
	</table>
</c:forEach>

<%@include file="common/footer.jsp" %>