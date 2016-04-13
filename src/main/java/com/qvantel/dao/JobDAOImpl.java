package com.qvantel.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.qvantel.model.Job;

@Repository
public class JobDAOImpl extends HibernateDAOImpl<Job, Integer> implements JobDAO{

	@Autowired
	public JobDAOImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		super(sessionFactory, Job.class);
	}
	
}
