package com.qvantel.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qvantel.dao.JobDAO;
import com.qvantel.model.Job;

@Controller
public class JobController {
	
	@Autowired
	private JobDAO jobDAO;
	
	@Transactional(readOnly = true)
	@RequestMapping(value={"/viewJobs"})
	public ModelAndView home() {
		ModelAndView model = new ModelAndView("jobList");
		model.addObject("jobList", jobDAO.getAll());
		return model;
	}
	
	/*@RequestMapping(value="/viewJobs")
	public ModelAndView viewJobs() {
		ModelAndView model = new ModelAndView("jobList");
		model.addObject("jobList", jobDAO.getAll());
		return model;
	}*/
	
	@RequestMapping(value="/newJob")
	public ModelAndView newJob() {
		ModelAndView model = new ModelAndView("job");
		model.addObject("job", new Job());
		return model;
	}
	
	@RequestMapping(value="/saveJob")
	public ModelAndView saveJob(@ModelAttribute("job")Job job, BindingResult result, HttpServletRequest request) {
		jobDAO.create(job);
		ModelAndView model = new ModelAndView("jobList");
		model.addObject("jobList", jobDAO.getAll());
		return model;
	}
}
