package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCParkDAO implements ParkDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Park> getAllParks() {
		List<Park> parks = new ArrayList<Park>();
		String sqlGetAllParks = "SELECT * FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllParks);
		
		while (results.next()) {
			parks.add(mapRowtoPark(results));
		}
		
		return parks;
	}

	@Override
	public Park getParkById(String parkCode) {
		Park p;
		String sqlGetParkById = "SELECT * FROM park WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetParkById, parkCode);
		
		if(results.next() == false) {
			return null;
		}
		p = mapRowtoPark(results);
		
		return p;
	}
	
	private Park mapRowtoPark(SqlRowSet results) {
		Park p = new Park();
		p.setParkCode(results.getString("parkcode"));
		p.setParkName(results.getString("parkname"));
		p.setState(results.getString("state"));
		p.setAcreage(results.getInt("acreage"));
		p.setElevation(results.getInt("elevationinfeet"));
		p.setMilesOfTrail(results.getDouble("milesoftrail"));
		p.setNumCampsites(results.getInt("numberofcampsites"));
		p.setClimate(results.getString("climate"));
		p.setYearFounded(results.getInt("yearfounded"));
		p.setAnnualVisitors(results.getInt("annualvisitorcount"));
		p.setQuote(results.getString("inspirationalquote"));
		p.setQuoteSource(results.getString("inspirationalquotesource"));
		p.setParkDescription(results.getString("parkdescription"));
		p.setEntryFee(results.getInt("entryfee"));
		p.setNumCampsites(results.getInt("numberofanimalspecies"));
		
		return p;
	}

}
