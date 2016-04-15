package com.qvantel.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.qvantel.model.Role;

@Repository
public class RoleDAOImpl extends HibernateDAOImpl<Role, Integer> implements RoleDAO{

	@Autowired
	public RoleDAOImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		super(sessionFactory, Role.class);
	}
	
}
