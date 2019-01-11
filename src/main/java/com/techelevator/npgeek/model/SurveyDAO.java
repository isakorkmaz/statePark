package com.techelevator.npgeek.model;

import java.util.List;

public interface SurveyDAO {
	
	public void save(Survey s);
	
	public List<Survey> getSurveysByParkCode(String parkCode);

}
