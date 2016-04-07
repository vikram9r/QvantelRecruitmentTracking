package com.qvantel.dao;

import com.qvantel.model.User;

public interface UserDAO extends HibernateDAO<User, Integer> {
	public User findByUserName(String userName);
}
