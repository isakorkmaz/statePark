<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var="pageTitle" value="Submit Survey" />
<%@include file="common/header.jsp"%>

<section>
	<c:url var="submitFormURL" value="/getSurvey" />
	<form:form action="${submitFormURL}" method="POST" modelAttribute="Survey">
		
		<table>
			<tr>
				<td>
					<form:label path="parkCode">Favorite National Park</form:label>
				</td>
				<td>
					<form:select path="parkCode">
						<form:option value="CVNP" label="Cuyahoga Valley National Park" />
						<form:option value="ENP" label="Everglades National Park" />
						<form:option value="GCNP" label="Grand Canyon National Park" />
						<form:option value="GSMNP" label="Great Smokey Mountains National Park" />
						<form:option value="GTNP" label="Grand Teton National Park" />
						<form:option value="MRNP" label="Mount Rainier National Park" />
						<form:option value="RMNP" label="Rocky Mountain National Park" />
						<form:option value="YNP" label="Yellowstone National Park" />
						<form:option value="YNP2" label="Yosimite National Park" />
					</form:select>
					<form:errors path="parkCode" class="error" />
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="email">Email Address</form:label>
				</td>
				<td>
					<form:input path="email" />
					<form:errors path="email" class="error" />
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="state">State of residence</form:label>
				</td>
				<td>
					<form:select path="state">
						<option value="AL">Alabama</option>
						<option value="AK">Alaska</option>
						<option value="AZ">Arizona</option>
						<option value="AR">Arkansas</option>
						<option value="CA">California</option>
						<option value="CO">Colorado</option>
						<option value="CT">Connecticut</option>
						<option value="DE">Delaware</option>
						<option value="DC">District Of Columbia</option>
						<option value="FL">Florida</option>
						<option value="GA">Georgia</option>
						<option value="HI">Hawaii</option>
						<option value="ID">Idaho</option>
						<option value="IL">Illinois</option>
						<option value="IN">Indiana</option>
						<option value="IA">Iowa</option>
						<option value="KS">Kansas</option>
						<option value="KY">Kentucky</option>
						<option value="LA">Louisiana</option>
						<option value="ME">Maine</option>
						<option value="MD">Maryland</option>
						<option value="MA">Massachusetts</option>
						<option value="MI">Michigan</option>
						<option value="MN">Minnesota</option>
						<option value="MS">Mississippi</option>
						<option value="MO">Missouri</option>
						<option value="MT">Montana</option>
						<option value="NE">Nebraska</option>
						<option value="NV">Nevada</option>
						<option value="NH">New Hampshire</option>
						<option value="NJ">New Jersey</option>
						<option value="NM">New Mexico</option>
						<option value="NY">New York</option>
						<option value="NC">North Carolina</option>
						<option value="ND">North Dakota</option>
						<option value="OH">Ohio</option>
						<option value="OK">Oklahoma</option>
						<option value="OR">Oregon</option>
						<option value="PA">Pennsylvania</option>
						<option value="RI">Rhode Island</option>
						<option value="SC">South Carolina</option>
						<option value="SD">South Dakota</option>
						<option value="TN">Tennessee</option>
						<option value="TX">Texas</option>
						<option value="UT">Utah</option>
						<option value="VT">Vermont</option>
						<option value="VA">Virginia</option>
						<option value="WA">Washington</option>
						<option value="WV">West Virginia</option>
						<option value="WI">Wisconsin</option>
						<option value="WY">Wyoming</option>
					</form:select>
					<form:errors path="state" class="error" />
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="activityLevel">Activity Level</form:label>
				</td>
				<td>
					<form:radiobutton path="activityLevel" value="inactive" />Inactive 
					<form:radiobutton path="activityLevel" value="sedentary" />Sedentary
					<form:radiobutton path="activityLevel" value="active" />Active 
					<form:radiobutton path="activityLevel" value="extremelyActive" />Extremely Active
					<form:errors path="activityLevel" class="error" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input class="submit" type="submit" value="Submit" />
				</td>
			</tr>
		</table>
	</form:form>
</section>

<%@include file="common/footer.jsp"%>