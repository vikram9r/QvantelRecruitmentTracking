package com.qvantel.web.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.hwpf.HWPFDocumentCore;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.converter.WordToHtmlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;

import com.qvantel.dao.CandidateDAO;
import com.qvantel.dao.JobDAO;
import com.qvantel.dao.ProfilesScreenedDAO;
import com.qvantel.dao.UserDAO;
import com.qvantel.model.Candidate;
import com.qvantel.model.ProfilesScreened;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CandidateController {
	
	@Autowired
	private CandidateDAO candidateDAO;
	@Autowired
	private JobDAO jobDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private ProfilesScreenedDAO profilesScreenedDAO;
	
	@Transactional(readOnly = true)
	@RequestMapping(value="/viewCandidates")
	public ModelAndView viewCandidates() {
		ModelAndView model = new ModelAndView("candidateList");
		model.addObject("candidateList", candidateDAO.getAll());
		return model;
	}
	
	@RequestMapping(value="/newCandidate")
	public ModelAndView newCandidate() {
		ModelAndView model = new ModelAndView("candidate");
		model.addObject("candidate", new Candidate());
		model.addObject("jobs", jobDAO.getAll());
		return model;
	}
	
	@RequestMapping(value="/applyForJob")
	public ModelAndView applyForJob(@RequestParam String job_id) {
		ModelAndView model = new ModelAndView("candidate");
		model.addObject("candidate", new Candidate());
		model.addObject("jobs", jobDAO.getAll());
		model.addObject("job_id", Integer.valueOf(job_id));
		return model;
	}
	
	@RequestMapping(value="/saveCandidate")
	public ModelAndView saveCandidate(/*@RequestParam CommonsMultipartFile resume,*/ @ModelAttribute("candidate")Candidate candidate, BindingResult result, HttpServletRequest request) {
		candidate.setStatus("New");
		candidateDAO.create(candidate);
		ModelAndView model = new ModelAndView("candidateList");
		model.addObject("candidateList", candidateDAO.getAll());
		return model;
	}
	
	@RequestMapping(value="/shareProfilesForScreening")
	public ModelAndView shareProfilesForScreening(@RequestParam(value="candidate_ids[]", required=false) Integer[] candidate_ids) {
		ModelAndView model = new ModelAndView("shareSelectedProfilesForScreening");
		model.addObject("users", userDAO.getAll());
		model.addObject("candidate_ids", Arrays.asList(candidate_ids));
		return model;
	}
	
	@RequestMapping(value="/profilesScreenedTo", method = RequestMethod.POST)
	public ModelAndView profilesScreenedTo(@RequestParam String profiesScreenedTo, @RequestParam(required=false) String candidate_ids, HttpServletRequest request) {
		Integer current_user_id = userDAO.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName()).getId();
		String[] candidates = candidate_ids.replace("[", "").replace("]", "").split(",");
		for(String candidate_id : candidates){
			candidate_id = candidate_id.trim();
			Candidate candidate = candidateDAO.get(Integer.valueOf(candidate_id));
			candidate.setStatus("Shared for Screening");
			candidateDAO.update(candidate);
			ProfilesScreened profilesScreened = new ProfilesScreened();
			profilesScreened.setCandidate_id(Integer.valueOf(candidate_id));
			profilesScreened.setShared_by_user_id(current_user_id);
			profilesScreened.setShared_to_user_id(Integer.valueOf(profiesScreenedTo));
			profilesScreenedDAO.create(profilesScreened);
		}
		return viewCandidates();
	}
	
	@RequestMapping(value="/viewResume")
	public ModelAndView viewResume(@RequestParam String candidate_id) throws Exception {
		ModelAndView model = new ModelAndView("resume");
		Candidate candidate = candidateDAO.get(Integer.valueOf(candidate_id));
		candidate.getResume();
		
		HWPFDocumentCore wordDocument = WordToHtmlUtils//.loadDoc(new ByteArrayInputStream(candidate.getResume()));
				.loadDoc(new FileInputStream("/home/qsslp146/VM_shared/Vikram_CV_12_Aug_2015 (1).doc"));

	    WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(
	            DocumentBuilderFactory.newInstance().newDocumentBuilder()
	                    .newDocument());
	    wordToHtmlConverter.processDocument(wordDocument);
	    Document htmlDocument = wordToHtmlConverter.getDocument();
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    DOMSource domSource = new DOMSource(htmlDocument);
	    StreamResult streamResult = new StreamResult(out);

	    TransformerFactory tf = TransformerFactory.newInstance();
	    Transformer serializer = tf.newTransformer();
	    serializer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
	    serializer.setOutputProperty(OutputKeys.INDENT, "yes");
	    serializer.setOutputProperty(OutputKeys.METHOD, "html");
	    serializer.transform(domSource, streamResult);
	    out.close();

	    String result = new String(out.toByteArray());
	    model.addObject("candidateResume", result);
//	    System.out.println(result);
		
		return model;
	}
	
}
