package com.qvantel.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.qvantel.model.Candidate;

public class CandidateDAOImpl extends HibernateDAOImpl<Candidate> implements CandidateDAO {
	@Override
	@Transactional
	public List<Candidate> list() {
		SessionFactory sessionFactory =  getSessionFactory();
		@SuppressWarnings("unchecked")
		List<Candidate> candidateList = (List<Candidate>) sessionFactory.getCurrentSession()
				.createCriteria(Candidate.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return candidateList;
	}

}
