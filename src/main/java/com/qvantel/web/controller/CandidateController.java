package com.qvantel.web.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

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
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;

import com.qvantel.dao.CandidateDAO;
import com.qvantel.dao.JobDAO;
import com.qvantel.model.Candidate;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CandidateController {
	
	@Autowired
	private CandidateDAO candidateDAO;
	@Autowired
	private JobDAO jobDAO;
	
	/*@RequestMapping(value="/")
	public ModelAndView home() {
		ModelAndView model = new ModelAndView("home");
		model.addObject("candidateList", candidateDAO.list());
		return model;
	}*/
	
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
	public ModelAndView saveCandidate(@RequestParam CommonsMultipartFile resume, @ModelAttribute("candidate")Candidate candidate, BindingResult result, HttpServletRequest request) {
		//for setting resume file to candidate pojo
		/*f (resume != null && resume.length > 0) {
            for (CommonsMultipartFile aFile : resume){*/
                System.out.println("Saving file: " + resume.getOriginalFilename());
                candidate.setResumeName(resume.getOriginalFilename());
                candidate.setResume(resume.getBytes());
 /*           }
        }*/
		
		candidateDAO.create(candidate);
		ModelAndView model = new ModelAndView("candidateList");
		model.addObject("candidateList", candidateDAO.getAll());
		return model;
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
