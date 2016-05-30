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
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;

import com.qvantel.dao.CandidateDAO;
import com.qvantel.dao.JobDAO;
import com.qvantel.dao.ProfilesScreenedDAO;
import com.qvantel.dao.UserDAO;
import com.qvantel.model.Candidate;
import com.qvantel.model.ProfilesScreened;
import com.qvantel.util.JsonUtil;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/candidate")
public class CandidateController {
	
	@Autowired
	private CandidateDAO candidateDAO;
	@Autowired
	private JobDAO jobDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private ProfilesScreenedDAO profilesScreenedDAO;
	 @Autowired
	 private JavaMailSender mailSender;
	
	@RequestMapping(value="/view")
	public ModelAndView viewCandidates() {
		ModelAndView model = new ModelAndView("candidate/candidateList");
//		model.addObject("candidateList", candidateDAO.getAll());
		return model;
	}
	
	@RequestMapping(value="/loadData")
	public ModelAndView loadCandidates(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("dummy");
		model.addObject("formData", JsonUtil.toJsonObj(candidateDAO.getCandidates(request)));
		return model;
	}
	
	@RequestMapping(value="/new")
	public ModelAndView newCandidate(@RequestParam(value="candidate_id", required=false)  Integer candidate_id) {
		ModelAndView model = new ModelAndView("candidate/candidate");
		if(candidate_id != null && candidate_id != 0)
			model.addObject("candidate", candidateDAO.get(candidate_id));
		else 
			model.addObject("candidate", new Candidate());
		model.addObject("jobs", jobDAO.getAll());
		return model;
	}
	
	@RequestMapping(value="/applyForJob")
	public ModelAndView applyForJob(@RequestParam String job_id) {
		ModelAndView model = new ModelAndView("candidate/candidate");
		model.addObject("candidate", new Candidate());
		model.addObject("jobs", jobDAO.getAll());
		model.addObject("job_id", Integer.valueOf(job_id));
		return model;
	}
	
	@RequestMapping(value="/save")
	public ModelAndView saveCandidate(@RequestParam CommonsMultipartFile resume, @ModelAttribute("candidate")Candidate candidate, BindingResult result, HttpServletRequest request) {
		candidate.setStatus("New");
		candidate.setResumeName(resume.getOriginalFilename());
		candidate.setResume(resume.getBytes());
		candidateDAO.create(candidate);
		ModelAndView model = new ModelAndView("candidate/candidateList");
		model.addObject("candidateList", candidateDAO.getAll());
		return model;
	}
	
	@RequestMapping(value="/shareProfilesForScreening")
	public ModelAndView shareProfilesForScreening(@RequestParam(value="candidate_ids[]", required=false) Integer[] candidate_ids) {
		ModelAndView model = new ModelAndView("candidate/shareSelectedProfilesForScreening");
		model.addObject("users", userDAO.getAll());
		model.addObject("candidate_ids", Arrays.asList(candidate_ids));
		
		/*final String emailTo = "";
		final String subject = "";
		final String message = "";

		mailSender.send(new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				messageHelper.setTo(emailTo);
				messageHelper.setSubject(subject);
				messageHelper.setText(message);
			}
		});*/

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
		ModelAndView model = new ModelAndView("candidate/resume");
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
