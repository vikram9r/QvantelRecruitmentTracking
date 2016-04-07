package com.qvantel.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "job")
public class Job {
	private int id;
	private String jobTitle;
	private String designation;
	private Set<Candidate> applicants = new HashSet<Candidate>();
	private String industry;
	private String functionalArea;
	private String briefDescription;
	private String detailDescription;
	private String mainSkill;
	private String qualification;
	private Float minimumExperience = (float)0.0;
	private Float maximumExperience = (float)0.0;
	private Date startDate;
	private Date lastDate;
	private String recruiters;
	private String contactName;
	private String contactEmail;
	private Integer emailNotification = 0;
	private String city;
	private String state;
	private String country;
	private String requirementType;
	private String otherSkills;
	private Integer noOfOpenings = 0;
	private String jobStage;
	private Integer makeSalaryVisibleToPublic = 0;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column( name = "job_id", nullable = false  )
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column( name = "job_title", length = 45  )
	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	@Column( name = "designation", length = 45  )
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "job")
	public Set<Candidate> getApplicants() {
		return applicants;
	}

	public void setApplicants(Set<Candidate> applicants) {
		this.applicants = applicants;
	}

	@Column( name = "industry", length = 45  )
	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	@Column( name = "functional_area", length = 45  )
	public String getFunctionalArea() {
		return functionalArea;
	}

	public void setFunctionalArea(String functionalArea) {
		this.functionalArea = functionalArea;
	}

	@Column( name = "brief_description", length = 45  )
	public String getBriefDescription() {
		return briefDescription;
	}

	public void setBriefDescription(String briefDescription) {
		this.briefDescription = briefDescription;
	}

	@Column( name = "detailed_description", length = 45  )
	public String getDetailDescription() {
		return detailDescription;
	}

	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}

	@Column( name = "main_skill", length = 45  )
	public String getMainSkill() {
		return mainSkill;
	}

	public void setMainSkill(String mainSkill) {
		this.mainSkill = mainSkill;
	}

	@Column( name = "qualification_s", length = 45  )
	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	@Column( name = "minimum_experience" )
	public Float getMinimumExperience() {
		return minimumExperience;
	}

	public void setMinimumExperience(Float minimumExperience) {
		this.minimumExperience = minimumExperience;
	}

	@Column( name = "maximum_experience")
	public Float getMaximumExperience() {
		return maximumExperience;
	}

	public void setMaximumExperience(Float maximumExperience) {
		this.maximumExperience = maximumExperience;
	}

	@Column( name = "start_date"  )
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column( name = "last_date"  )
	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	@Column( name = "recruiter_s", length = 45  )
	public String getRecruiters() {
		return recruiters;
	}

	public void setRecruiters(String recruiters) {
		this.recruiters = recruiters;
	}

	@Column( name = "contact_name", length = 45  )
	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	@Column( name = "contact_email", length = 45  )
	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	@Column( name = "email_notification"  )
	public Integer getEmailNotification() {
		return emailNotification;
	}

	public void setEmailNotification(Integer emailNotification) {
		this.emailNotification = emailNotification;
	}

	@Column( name = "city", length = 45  )
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column( name = "state", length = 45  )
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column( name = "country", length = 45  )
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column( name = "requirement_type", length = 45  )
	public String getRequirementType() {
		return requirementType;
	}

	public void setRequirementType(String requirementType) {
		this.requirementType = requirementType;
	}

	@Column( name = "other_skill", length = 45  )
	public String getOtherSkills() {
		return otherSkills;
	}

	public void setOtherSkills(String otherSkills) {
		this.otherSkills = otherSkills;
	}

	@Column( name = "number_of_openings", length = 45  )
	public Integer getNoOfOpenings() {
		return noOfOpenings;
	}

	public void setNoOfOpenings(Integer noOfOpenings) {
		this.noOfOpenings = noOfOpenings;
	}

	@Column( name = "job_stage", length = 45  )
	public String getJobStage() {
		return jobStage;
	}

	public void setJobStage(String jobStage) {
		this.jobStage = jobStage;
	}

	@Column( name = "make_salary_visible_to_public"  )
	public Integer getMakeSalaryVisibleToPublic() {
		return makeSalaryVisibleToPublic;
	}

	public void setMakeSalaryVisibleToPublic(Integer makeSalaryVisibleToPublic) {
		this.makeSalaryVisibleToPublic = makeSalaryVisibleToPublic;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((designation == null) ? 0 : designation.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((jobTitle == null) ? 0 : jobTitle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Job other = (Job) obj;
		if (designation == null) {
			if (other.designation != null)
				return false;
		} else if (!designation.equals(other.designation))
			return false;
		if (id != other.id)
			return false;
		if (jobTitle == null) {
			if (other.jobTitle != null)
				return false;
		} else if (!jobTitle.equals(other.jobTitle))
			return false;
		return true;
	}
	
}
