package com.qvantel.dao;

import java.util.List;

import com.qvantel.model.User;

public interface UserDAO extends HibernateDAO<User> {
	public List<User> list();
}
