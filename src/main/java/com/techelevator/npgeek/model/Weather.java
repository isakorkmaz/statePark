package com.techelevator.npgeek.model;

public class Weather {

	private String parkCode;
	private int day;
	private int low;
	private int high;
	private String forecast;
	private String tempUnit = "F";
	private String suggestion;

	private String suggestionLow = "";
	private String suggestionHigh = "";
	private String suggestionDifference = "";
	private String suggestionForecast = "";

	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getLow() {
		return low;
	}

	public void setLow(int low) {
		this.low = tempConverter(low);
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = tempConverter(high);
	}

	public String getForecast() {
		return forecast;
	}

	public void setForecast(String forecast) {
		this.forecast = forecast;
	}

	public String getTempUnit() {
		return tempUnit;
	}

	public void setTempUnit(String tempUnit) {
		this.tempUnit = tempUnit;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {

		this.suggestion = suggestion;
	}

	public String getSuggestionForecast() {
		return suggestionForecast;
	}

	public void setSuggestionForecast(String suggestionForecast) {
		this.suggestionForecast = suggestionForecast;
	}

	private int tempConverter(int temp) {
		if (tempUnit.equals("C") || tempUnit.equals("c")) {
			double n1 = temp;
			double n2 = 5 * (n1 - 32) / 9;
			return (int) n2;
		} else
			return temp;
	}

	public String suggestionMethod(int low, int high, String forecast) {
		if (forecast == "rain") {
			suggestionForecast = "Pack rain gear and waterproof shoes ";
		} else if (forecast == "snow") {
			suggestionForecast = "Pack snowshoes";
		} else if (forecast == "thunderstorms") {
			suggestionForecast = "Seek shelter and  avoid hiking on exposed ridges";
		} else if (forecast == "sunny") {
			suggestionForecast = "Pack sunblock";
		} else {

		}

		if (tempConverter(low) < tempConverter(20)) {
			suggestionLow = "Caution!Frigid tempratures";
		}
		if (tempConverter(high) > tempConverter(75)) {
			suggestionHigh = "Bring extra gallon of water";
		}
		if (tempConverter(high) - tempConverter(low) > tempConverter(20)) {
			suggestionDifference = "Wear breathable layers";
		}
		suggestion = suggestionForecast + "\n" + suggestionLow + "\n" + suggestionHigh + "\n" + suggestionDifference;
		return suggestion;
	}

}
