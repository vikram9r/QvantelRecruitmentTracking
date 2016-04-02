package com.qvantel.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.qvantel.model.User;

public class UserDAOImpl extends HibernateDAOImpl<User> implements UserDAO {

	@Override
	@Transactional
	public List<User> list() {
		SessionFactory sessionFactory =  getSessionFactory();
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listUser;
	}

}
