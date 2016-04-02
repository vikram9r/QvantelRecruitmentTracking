package com.qvantel.dao;

import java.util.List;

import com.qvantel.model.Candidate;

public interface CandidateDAO extends HibernateDAO<Candidate> {
	public List<Candidate> list();
}
