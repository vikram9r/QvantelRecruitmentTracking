package com.qvantel.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profiles_screened")
public class ProfilesScreened implements  Serializable{
	private static final long serialVersionUID = 1L; 
	private Integer id;
	private Integer shared_by_user_id;
	private Integer shared_to_user_id;
	private Integer candidate_id;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column( name = "id", nullable = false  )
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column( name = "shared_by_user_id")
	public Integer getShared_by_user_id() {
		return shared_by_user_id;
	}
	public void setShared_by_user_id(Integer shared_by_user_id) {
		this.shared_by_user_id = shared_by_user_id;
	}
	
	@Column( name = "shared_to_user_id")
	public Integer getShared_to_user_id() {
		return shared_to_user_id;
	}
	public void setShared_to_user_id(Integer shared_to_user_id) {
		this.shared_to_user_id = shared_to_user_id;
	}
	
	@Column( name = "candidate_id")
	public Integer getCandidate_id() {
		return candidate_id;
	}
	public void setCandidate_id(Integer candidate_id) {
		this.candidate_id = candidate_id;
	}


}
