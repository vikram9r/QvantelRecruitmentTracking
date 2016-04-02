package com.qvantel.dao;

import java.io.Serializable;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

public class HibernateDAOImpl<E> extends HibernateDaoSupport implements HibernateDAO<E> {

	@Override
    @Transactional(readOnly = false)
	public Serializable save(E e) {
		return getHibernateTemplate().save(e);
	}

}
