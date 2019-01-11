<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="pageTitle" value="Park Details" />
<%@include file="common/header.jsp"%>

<c:set var="parkCodeLowerCase" value="${fn:toLowerCase(park.parkCode)}" />
<img class="listImages" src="img/parks/${parkCodeLowerCase}.jpg" />
<p>${park.parkName}</p>
<p>${park.parkDescription}</p>

<c:url var="changeTempUnitURL" value="/details" />

<form action="${changeTempUnitURL}" method="POST">
	<label for="tempUnit">Temp Unit: </label>
	<input type="radio" id="tempUnit" name="tempUnit" value="F" />Fahrenheit
	<input type="radio" id="tempUnit" name="tempUnit" value="C" />Celsius
	<input type="hidden" name="parkCode" value="${park.parkCode}" />
	<input type="submit" value="Change Unit" />
</form>

<div id="allWeatherTables" >
<c:forEach var="weather" items="${weathers}">
	<div class="eachDayWeatherDiv">
	<table class="WeatherTableDay-${weather.day}">
		<tr>
			<td>
			<c:set var="forecastStringArray"
				value="${fn:split(weather.forecast, ' ')}" />
			<c:set var="count" value="1" />
			<c:forEach var="i" items="${forecastStringArray}" begin="1">
				<c:set var="s1" value="${ fn:toUpperCase(fn:substring(i, 0, 1))}" />
				<c:set var="s2" value="${ fn:substring(i,1,fn:length(i)) }" />
				<c:set var="i" value="${s1}${s2}" />
				<c:set var="temp" value="${forecastStringArray[count] = i}" />
				<c:set var="count" value="${count += 1}" />

			</c:forEach>
			<c:set var="imageName" value="${fn:join(forecastStringArray, '')}" />
			<c:url var="weatherImageURL" value="img/weather/${imageName}.png" />
			<img id="weatherImage-${weather.day}" class="weatherImage" src="${weatherImageURL}" />
		
			<div class="highLow">
				<p>High: ${weather.high}&deg;${weather.tempUnit}</p>
				<p>Low: ${weather.low}&deg;${weather.tempUnit}</p>

			</div>
		
			<div class="suggestions">
				<c:if test="${weather.day =='1'}">
					<p>
						<c:out value="${weather.suggestion}" />
					</p>
				</c:if>
			</div>
			</td>
		</tr>


	</table>
	</div>
</c:forEach>
</div>
<%@include file="common/footer.jsp"%>