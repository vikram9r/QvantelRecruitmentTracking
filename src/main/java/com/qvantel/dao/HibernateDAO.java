package com.qvantel.dao;

import java.io.Serializable;
import java.util.List;


public interface HibernateDAO<E, PK extends Serializable>{
	PK create(E persistentObject);
	E get(PK id);
	List<E> getAll();
	void update(E e);
	void createOrUpdate(E e);
	void delete(E e);

}
