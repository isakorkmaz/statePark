package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


@Component
public class JDBCSurveyDAO implements SurveyDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCSurveyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void save(Survey s) {
		String sqlInsertSurvey = "INSERT INTO survey_result (parkcode,emailaddress,state,activitylevel) VALUES (?,?,?,?)";
		jdbcTemplate.update(sqlInsertSurvey,  s.getParkCode(), s.getEmail(),s.getState(),s.getActivityLevel());
	}
	
	@Override
	public List<Survey> getSurveysByParkCode(String parkCode) {
		
		List <Survey> surveyResults =new ArrayList<Survey>();
		String sqlGetSurveys="SELECT * FROM survey_result WHERE parkcode=?";
		SqlRowSet results =jdbcTemplate.queryForRowSet(sqlGetSurveys, parkCode);
		while(results.next()) {
			surveyResults.add(mapRowtSurvey(results));
		}
		return surveyResults;
	}
	
	private Survey mapRowtSurvey(SqlRowSet results) {
		Survey s = new Survey();
		s.setActivityLevel(results.getString("activitylevel"));
		s.setState(results.getString("state"));
		s.setParkCode(results.getString("parkcode"));
		s.setEmail(results.getString("emailaddress"));
		s.setSurveyId(results.getLong("surveyid"));
		return s;
	}
}
