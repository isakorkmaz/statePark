package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCSurveyResultDAO implements SurveyResultDAO {
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCSurveyResultDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<SurveyResult> countResultsByParkCode() {
		List<SurveyResult> surveyResults = new ArrayList<SurveyResult>();
		String sqlCountResults = "SELECT sr.parkcode, p.parkname, COUNT(sr.parkcode) AS count " + 
				"FROM survey_result sr " + 
				"INNER JOIN park p ON p.parkcode = sr.parkcode " + 
				"GROUP BY sr.parkcode, p.parkname " + 
				"ORDER BY count DESC";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlCountResults);
		while (results.next()) {
			surveyResults.add(mapRowToSurveyResult(results));
		}
		return surveyResults;
	}
	
	private SurveyResult mapRowToSurveyResult(SqlRowSet results) {
		SurveyResult sr = new SurveyResult();
		sr.setParkCode(results.getString("parkcode"));
		sr.setCount(results.getLong("count"));
		sr.setParkName(results.getString("parkname"));
		return sr;
	}

}
