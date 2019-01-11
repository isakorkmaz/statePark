package com.techelevator.npgeek.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.model.ParkDAO;
import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.SurveyDAO;
import com.techelevator.npgeek.model.SurveyResultDAO;
import com.techelevator.npgeek.model.WeatherDAO;

@Controller
@SessionAttributes("tempUnit")
public class NpgeekController {
	
	@Autowired
	private ParkDAO parkDAO;
	@Autowired
	private WeatherDAO weatherDAO;
	@Autowired
	private SurveyDAO surveyDAO;
	@Autowired
	private SurveyResultDAO surveyResultDAO;
	
	@RequestMapping(path={"/home", "/"}, method=RequestMethod.GET)
	public String displayHomePage(ModelMap model) {
		model.put("parks", parkDAO.getAllParks());
		return "home";
	}
	
	@RequestMapping(path="/details", method=RequestMethod.GET)
	public String displayDetailsPage(@RequestParam String parkCode, ModelMap model) {
		model.put("park", parkDAO.getParkById(parkCode));
		if (model.get("tempUnit") == null) {
			model.put("tempUnit", "F");
		}
		model.put("weathers", weatherDAO.getWeatherByParkCode(parkCode, (String) model.get("tempUnit")));
		return "details";
	}
	
	@RequestMapping(path="/details", method=RequestMethod.POST)
	public String displayUpdatedDetailsPage(@RequestParam String parkCode,
											@RequestParam String tempUnit,
											ModelMap model) {
		model.put("park", parkDAO.getParkById(parkCode));
		model.put("tempUnit", tempUnit);
		model.put("weathers", weatherDAO.getWeatherByParkCode(parkCode, (String) model.get("tempUnit")));
		return "details";
	}
	
	@RequestMapping(path="/getSurvey", method=RequestMethod.GET)
	public String displaySurveyPage(ModelMap model) {
		if ( ! model.containsAttribute("Survey") ) {
			model.put("Survey", new Survey());
		}
		return "getSurvey";
	}
	
	@RequestMapping(path="/getSurvey", method=RequestMethod.POST)
	public String submitSurvey(@Valid @ModelAttribute("Survey") Survey survey,
								BindingResult result,
								RedirectAttributes flash) {
		if (result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Survey", result);
			flash.addFlashAttribute("Survey", survey);
			return "redirect:/getSurvey";
		}
		surveyDAO.save(survey);
		return "redirect:/surveyList";
	}
	
	@RequestMapping(path="surveyList", method=RequestMethod.GET)
	public String displaySurveyListPage(ModelMap model) {
		model.put("surveyResults", surveyResultDAO.countResultsByParkCode());
		return "surveyList";
	}

}
