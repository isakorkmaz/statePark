<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<c:set var="pageTitle" value="National Park Geek Home" />
<%@include file="common/header.jsp" %>

	 <c:forEach var="park" items="${parks}">
	 <c:url var="parkDetailUrl" value="/details" >
	 	<c:param name="parkCode" value="${park.parkCode}"> </c:param>
     </c:url>
	 <c:set var = "parkCodeLowerCase" value = "${fn:toLowerCase(park.parkCode)}" /> 
	 <table class="home-table">
	 	<tr>
	 		<td rowspan="2">
				 <a href="${parkDetailUrl}"><img class="listImages" src="img/parks/${parkCodeLowerCase}.jpg"/></a>
			</td>
			<td>
				 <h3>${park.parkName}</h3>
	 		</td>
	 	</tr>
	 	<tr>
	 		<td>
				 <p>${park.parkDescription}</p>
	 		</td>
	 	</tr>
	 </table>
     </c:forEach>

<%@include file="common/footer.jsp" %>