package com.qvantel.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.qvantel.model.User;

public class UserDAOImpl extends HibernateDAOImpl<User, Integer> implements UserDAO {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserDAOImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		super(sessionFactory, User.class);
	}

	@Override
	public User findByUserName(String userName) {
		Criteria crit = getSessionFactory().getCurrentSession().createCriteria(User.class);
		crit.add(Restrictions.eq("userName", userName));
		return (User) crit.uniqueResult();
	}

	@Override
	public Integer create(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return super.create(user);
	}

}
