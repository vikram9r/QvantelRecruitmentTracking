package com.qvantel.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class HibernateDAOImpl<E, PK extends Serializable> implements HibernateDAO<E, PK> {

	@Autowired
    private SessionFactory sessionFactory;
	
	private Class<E> type;
	
	public HibernateDAOImpl() {
		
	}

	public HibernateDAOImpl(SessionFactory sessionFactory, Class<E> type) {
		this.type = type;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	@SuppressWarnings("unchecked")
	@Transactional(readOnly=false)
	public PK create(E e) {
		return (PK) getSessionFactory().getCurrentSession().save(e);
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
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
	
	@Transactional(readOnly=false)
	public void createOrUpdate(E e) {
		getSessionFactory().getCurrentSession().saveOrUpdate(e);
	}


	@Transactional(readOnly=false)
	public void update(E e) {
		getSessionFactory().getCurrentSession().update(e);
	}

	public void delete(E e) {
		getSessionFactory().getCurrentSession().delete(e);
	}


}
