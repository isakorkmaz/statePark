package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCWeatherDAO implements WeatherDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCWeatherDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Weather> getWeatherByParkCode(String parkCode, String tempUnit) {
		List<Weather> weatherList = new ArrayList<Weather>();
		String unit = tempUnit;
		String sqlGetWeatherByParkId = "SELECT * FROM weather WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetWeatherByParkId, parkCode);
		while (results.next()) {
			weatherList.add(mapRowtoWeather(results, tempUnit));
		}
		return weatherList;
	} 

	private Weather mapRowtoWeather(SqlRowSet results, String tempUnit) {
		Weather w = new Weather();
		w.setParkCode(results.getString("parkcode"));
		w.setDay(results.getInt("fivedayforecastvalue"));
		w.setForecast(results.getString("forecast"));
		w.setTempUnit(tempUnit);
		w.setHigh(results.getInt("high"));
		w.setLow(results.getInt("low"));
	    w.setSuggestion(w.suggestionMethod(results.getInt("low"), results.getInt("high"),results.getString("forecast")));
	    return w;
	}
	
}
