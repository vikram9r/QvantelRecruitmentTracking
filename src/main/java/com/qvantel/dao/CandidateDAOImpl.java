package com.qvantel.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qvantel.dto.JQGridDTO;
import com.qvantel.model.Candidate;


@Repository
public class CandidateDAOImpl extends HibernateDAOImpl<Candidate, Integer> implements CandidateDAO {
	@Autowired
	public CandidateDAOImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		super(sessionFactory, Candidate.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public JQGridDTO<Candidate> getCandidates(HttpServletRequest request) {
		/** 
		   * The page and rows are sent from the JQGrid component with the Ajax 
		   * query. 
		   *  
		   */  
		  int page = Integer.valueOf(request.getParameter("page")).intValue();  
		  int pageSize = Integer.valueOf(request.getParameter("rows")).intValue();  
		  
		  int startIndex = page == 1 ? 0 : (pageSize * (page - 1));  
		  int endIndex = page == 1 ? pageSize : pageSize * page;  
		  int total = -1;  
		  
		  JQGridDTO<Candidate> jqGridData = new JQGridDTO<Candidate>();  
		  
		  Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(Candidate.class);
		  criteria.setFirstResult(startIndex);
		  criteria.setMaxResults(endIndex);
		  List<Candidate> candidates = (List<Candidate>) criteria.list();
		  total = ((Long)getSessionFactory().getCurrentSession().createQuery("select count(*) from Candidate").uniqueResult()).intValue()/*candidates.size()*/;
		  jqGridData.setPage(page);
		  
		  Integer totalPages = total % pageSize == 0 ? (total/pageSize): (total/pageSize)+1 ;
		  
		  jqGridData.setTotal(totalPages.toString()/*String.valueOf(Math.ceil((double) total / pageSize))*/);
		  jqGridData.setRecords(String.valueOf(total));
		  jqGridData.setRows(candidates);
		  return jqGridData;
	}
	
	
}
