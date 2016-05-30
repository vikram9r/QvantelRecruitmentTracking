package com.qvantel.dao;

import javax.servlet.http.HttpServletRequest;

import com.qvantel.dto.JQGridDTO;
import com.qvantel.model.Candidate;

public interface CandidateDAO extends HibernateDAO<Candidate, Integer> {
	public JQGridDTO<Candidate> getCandidates(final HttpServletRequest request);
}
