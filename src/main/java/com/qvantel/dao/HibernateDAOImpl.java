package com.qvantel.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public class HibernateDAOImpl<E, PK extends Serializable> extends HibernateDaoSupport implements HibernateDAO<E, PK> {

	private Class<E> type;

	public HibernateDAOImpl(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	public HibernateDAOImpl(SessionFactory sessionFactory, Class<E> type) {
		super.setSessionFactory(sessionFactory);
		this.type = type;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=false)
	public PK create(E e) {
		return (PK) getSessionFactory().getCurrentSession().save(e);
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public E get(PK id) {
		E value = (E) getSessionFactory().getCurrentSession().get(type, id);
		if (value == null) {
            return null;
        }

        if (value instanceof HibernateProxy) {
			Hibernate.initialize(value);
	        value = (E) ((HibernateProxy) value).getHibernateLazyInitializer().getImplementation();
        }
        return value;
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<E> getAll() {
		Criteria crit = getSessionFactory().getCurrentSession().createCriteria(type);
		return crit.list();
	}
	
	public void createOrUpdate(E e) {
		getSessionFactory().getCurrentSession().saveOrUpdate(e);
	}


	public void update(E e) {
		getSessionFactory().getCurrentSession().update(e);
	}

	public void delete(E e) {
		getSessionFactory().getCurrentSession().delete(e);
	}


}
