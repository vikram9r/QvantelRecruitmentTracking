package com.qvantel.dao;

import java.io.Serializable;

public interface HibernateDAO<E>{
	public Serializable save(E e);
}
