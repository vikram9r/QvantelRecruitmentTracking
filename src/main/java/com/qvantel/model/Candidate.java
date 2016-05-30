package com.qvantel.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "candidate")
public class Candidate implements  Serializable{
	private static final long serialVersionUID = 1L; 
	private int id;
	private Job job;
	private String firstName;
	private String middleName;
	private String lastName;
	private String mobile;
	private String email;
	private String gender;
	private Date dateOfBirth;
	private String availabilityForInvterview;
	private String reasonForChange;
	private String currentComapany;
	private String addressLine;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	private String phone;
	private byte[] profilePhoto;
	private String resumeName;
	private byte[] resume;
	private Date preferContactTime;
	private String industry;
	private String functionalArea;
	private Float experienceYears;
	private String skillSet;
	private String designation;
	private String currentSalary;
	private String expectedSalary;
	private String currentLocation;
	private String prefferedLocation;
	private String qualification;
	private String experienceSummary;
	private String projectDescription;
	private String noticePeriod;
	private String status;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column( name = "id", nullable = false  )
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "job_id", nullable = false)
	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@Column( name = "first_name", length = 45  )
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column( name = "middle_name", length = 45  )
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column( name = "last_name", length = 45  )
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column( name = "mobile_number", length = 45  )
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column( name = "email", length = 45  )
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column( name = "gender", length = 45  )
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column( name = "date_of_birth"  )
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column( name = "availability_for_interview", length = 45  )
	public String getAvailabilityForInvterview() {
		return availabilityForInvterview;
	}

	public void setAvailabilityForInvterview(String availabilityForInvterview) {
		this.availabilityForInvterview = availabilityForInvterview;
	}

	@Column( name = "reason_for_change", length = 45  )
	public String getReasonForChange() {
		return reasonForChange;
	}

	public void setReasonForChange(String reasonForChange) {
		this.reasonForChange = reasonForChange;
	}

	@Column( name = "current_company", length = 45  )
	public String getCurrentComapany() {
		return currentComapany;
	}

	public void setCurrentComapany(String currentComapany) {
		this.currentComapany = currentComapany;
	}

	@Column( name = "address_line", length = 500  )
	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
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

	@Column( name = "zip_code", length = 45  )
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Column( name = "phone", length = 45  )
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	/*@Column( name = "profile_photo", length = 45  )
	public String getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}*/

	@Column( name = "prefer_contact_time"  )
	public Date getPreferContactTime() {
		return preferContactTime;
	}

	public void setPreferContactTime(Date preferContactTime) {
		this.preferContactTime = preferContactTime;
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

	@Column( name = "experience_years" )
	public Float getExperienceYears() {
		return experienceYears;
	}

	public void setExperienceYears(Float experienceYears) {
		this.experienceYears = experienceYears;
	}

	@Column( name = "skill_set", length = 45  )
	public String getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
	}

	@Column( name = "designation", length = 45  )
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Column( name = "current_salary", length = 45  )
	public String getCurrentSalary() {
		return currentSalary;
	}

	public void setCurrentSalary(String currentSalary) {
		this.currentSalary = currentSalary;
	}

	@Column( name = "expected_salary", length = 45  )
	public String getExpectedSalary() {
		return expectedSalary;
	}

	public void setExpectedSalary(String expectedSalary) {
		this.expectedSalary = expectedSalary;
	}

	@Column( name = "current_location", length = 45  )
	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	@Column( name = "preferred_locatioin", length = 45  )
	public String getPrefferedLocation() {
		return prefferedLocation;
	}

	public void setPrefferedLocation(String prefferedLocation) {
		this.prefferedLocation = prefferedLocation;
	}

	@Column( name = "qualification", length = 45  )
	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	@Column( name = "experience_summary", length = 500  )
	public String getExperienceSummary() {
		return experienceSummary;
	}

	public void setExperienceSummary(String experienceSummary) {
		this.experienceSummary = experienceSummary;
	}

	@Column( name = "projects", length = 500  )
	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	@Column( name = "notice_period", length = 45  )
	public String getNoticePeriod() {
		return noticePeriod;
	}

	public void setNoticePeriod(String noticePeriod) {
		this.noticePeriod = noticePeriod;
	}

	@Column( name = "status", length = 45  )
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column( name = "profile_photo")
	public byte[] getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(byte[] profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	@Column( name = "resume_name")
	public String getResumeName() {
		return resumeName;
	}

	public void setResumeName(String resumeName) {
		this.resumeName = resumeName;
	}

	@Column( name = "resume")
	public byte[] getResume() {
		return resume;
	}

	public void setResume(byte[] resume) {
		this.resume = resume;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
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
		Candidate other = (Candidate) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	

}
