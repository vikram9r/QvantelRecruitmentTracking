package com.qvantel.conveter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.qvantel.dao.JobDAO;
import com.qvantel.model.Job;

public class JobConverter implements Converter<Integer, Job> {

	@Autowired
	private JobDAO jobDAO;
	@Override
	public Job convert(Integer job_id) {
		Job job = jobDAO.get(job_id);
		job.setId(job_id);
		return job;
	}
	

}
