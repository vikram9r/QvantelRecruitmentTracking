package com.qvantel.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qvantel.dao.CandidateDAO;
import com.qvantel.model.Candidate;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CandidateController {
	
	@Autowired
	private CandidateDAO candidateDAO;
	
	@RequestMapping(value="/")
	public ModelAndView home() {
		ModelAndView model = new ModelAndView("home");
		model.addObject("candidateList", candidateDAO.list());
		return model;
	}
	
	@RequestMapping(value="/viewCandidates")
	public ModelAndView viewCandidates() {
		ModelAndView model = new ModelAndView("home");
		model.addObject("candidateList", candidateDAO.list());
		return model;
	}
	
	@RequestMapping(value="/newCandidate")
	public ModelAndView newCandidate() {
		ModelAndView model = new ModelAndView("candidate");
		model.addObject("candidate", new Candidate());
		return model;
	}
	
	@RequestMapping(value="/saveCandidate")
	public ModelAndView saveCandidate(@ModelAttribute("candidate")Candidate candidate, BindingResult result, HttpServletRequest request) {
		candidateDAO.save(candidate);
		ModelAndView model = new ModelAndView("candidate");
		model.addObject("candidate", new Candidate());
		return model;
	}
	
}
