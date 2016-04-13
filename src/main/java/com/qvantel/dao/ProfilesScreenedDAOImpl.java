package com.qvantel.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.qvantel.model.ProfilesScreened;

@Repository
public class ProfilesScreenedDAOImpl extends HibernateDAOImpl<ProfilesScreened, Integer> implements ProfilesScreenedDAO {
	@Autowired
	public ProfilesScreenedDAOImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		super(sessionFactory, ProfilesScreened.class);
	}
}
