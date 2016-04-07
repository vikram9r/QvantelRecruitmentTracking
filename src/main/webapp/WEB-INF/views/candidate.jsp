<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type = "text/javascript">
	     
         $(document).ready(function() {
        	 $('#candidateForm').ajaxForm({ 
        		 url : 'saveCandidate',
        	     success : function (data) {
        	            $('#candidatesTab').html(data);
        	     }
                 
             });
         });
      </script>
 </head>
 <body>
   <input type = "button" onclick = "viewCandidates();" value = "View Candidates" style="float: right;"/>
	<form:form id="candidateForm" method="POST" modelAttribute="candidate" action="/QvantelRecruitmentTracking/saveCandidate" enctype="multipart/form-data">
	   <table>
			<tr>
				<td><form:label path="job">Application For</form:label></td>
				<td><form:select path="job.id" >
						<form:option value="0" label="Select" />
						<c:forEach items="${jobs}" var="job">
							<c:choose>
					            <c:when test="${job.id == job_id}">
					                <form:option value="${job.id}" selected="true" label="${job.jobTitle}" />
					            </c:when>
					            <c:otherwise>
					                <form:option value="${job.id}" label="${job.jobTitle}" />
					            </c:otherwise>
					        </c:choose>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr><td><form:label path="firstName">First Name</form:label></td><td><form:input path="firstName" class="required" type="text" id="firstName" /></td></tr>
	    <tr>
	        <td><form:label path="middleName">Middle Name</form:label></td>
	        <td><form:input path="middleName" class="required" type="text" id="middleName" /></td>
	    </tr>
	    <tr>
	        <td><form:label path="lastName">Last Name</form:label></td>
	        <td><form:input path="lastName" class="required" type="text" id="lastName" /></td>
	    </tr>
	    <tr>
	        <td><form:label path="mobile">Mobile No</form:label></td>
	        <td><form:input path="mobile" class="required" type="text" id="mobile" /></td>
	    </tr>
	    <tr>
	        <td><form:label path="email">Email ID</form:label></td>
	        <td><form:input path="email" class="required email" type="text" id="email" /></td>
	    </tr>
	    
	    <tr><td><label></label>Attach Resume</td><td><input type="file" name="resume" class="required" id="resume" size="50" /></td></tr>
	    
	    <tr><td><form:label path="gender"></form:label>Gender</td><td><form:select path="gender"><form:option value="0" label="Select" /><form:option value="Male" label="Male" /><form:option value="Female" label="Female" /><form:option value="Others" label="Others" /></form:select></td></tr>
	    <tr><td><form:label path="dateOfBirth"></form:label>Date Of Birth</td><td><form:input path="dateOfBirth" class="required" type="text" id="dateOfBirth" /></td></tr>
	    <tr><td><form:label path="availabilityForInvterview"></form:label>Availability For Invterview</td><td><form:radiobutton path="availabilityForInvterview" value="Yes" label="Yes" /><form:radiobutton path="availabilityForInvterview" value="No" label="No" /></td></tr>
	    <tr><td><form:label path="reasonForChange"></form:label>Reason For Change</td><td><form:textarea path="reasonForChange" class="required" type="text" id="reasonForChange" /></td></tr>
	    <tr><td><form:label path="currentComapany"></form:label>Current Comapany</td><td><form:input path="currentComapany" class="required" type="text" id="currentComapany" /></td></tr>
	    <tr><td><form:label path="addressLine"></form:label>Address Line</td><td><form:textarea path="addressLine" class="required" type="text" id="addressLine" /></td></tr>
	    <tr><td><form:label path="city"></form:label>City</td><td><form:input path="city" class="required" type="text" id="city" /></td></tr>
	    <tr><td><form:label path="state"></form:label>State</td><td><form:input path="state" class="required" type="text" id="state" /></td></tr>
	    <tr><td><form:label path="country"></form:label>Country</td><td><form:input path="country" class="required" type="text" id="country" /></td></tr>
	    <tr><td><form:label path="zipCode"></form:label>Zip Code</td><td><form:input path="zipCode" class="required" type="text" id="zipCode" /></td></tr>
	    <tr><td><form:label path="phone"></form:label>Phone</td><td><form:input path="phone" class="required" type="text" id="phone" /></td></tr>
	    <tr><td><form:label path="preferContactTime"></form:label>Prefer Contact Time</td><td><form:input path="preferContactTime" class="required" type="text" id="preferContactTime" /></td></tr>
	    <tr><td><form:label path="industry"></form:label>Industry</td><td><form:input path="industry" class="required" type="text" id="industry" /></td></tr>
	    <tr><td><form:label path="functionalArea"></form:label>Functional Area</td><td><form:input path="functionalArea" class="required" type="text" id="functionalArea" /></td></tr>
	    <tr><td><form:label path="experienceYears"></form:label>Experience Years</td><td><form:input path="experienceYears" class="required" type="text" id="experienceYears" /></td></tr>
	    <tr><td><form:label path="skillSet"></form:label>Skill Set</td><td><form:input path="skillSet" class="required" type="text" id="skillSet" /></td></tr>
	    <tr><td><form:label path="designation"></form:label>Designation</td><td><form:input path="designation" class="required" type="text" id="designation" /></td></tr>
	    <tr><td><form:label path="currentSalary"></form:label>Current Salary</td><td><form:input path="currentSalary" class="required" type="text" id="currentSalary" /></td></tr>
	    <tr><td><form:label path="expectedSalary"></form:label>Expected Salary</td><td><form:input path="expectedSalary" class="required" type="text" id="expectedSalary" /></td></tr>
	    <tr><td><form:label path="currentLocation"></form:label>Current Location</td><td><form:input path="currentLocation" class="required" type="text" id="currentLocation" /></td></tr>
	    <tr><td><form:label path="prefferedLocation"></form:label>Preffered Location</td><td><form:input path="prefferedLocation" class="required" type="text" id="prefferedLocation" /></td></tr>
	    <tr><td><form:label path="qualification"></form:label>Qualification</td><td><form:input path="qualification" class="required" type="text" id="qualification" /></td></tr>
	    <tr><td><form:label path="experienceSummary"></form:label>Experience Summary</td><td><form:input path="experienceSummary" class="required" type="text" id="experienceSummary" /></td></tr>
	    <tr><td><form:label path="projectDescription"></form:label>Project Description</td><td><form:input path="projectDescription" class="required" type="text" id="projectDescription" /></td></tr>
	    <tr><td><form:label path="noticePeriod"></form:label>Notice Period</td><td><form:input path="noticePeriod" class="required" type="text" id="noticePeriod" /></td></tr>
	    
	    <tr>
	        <td colspan="2">
	            <input type="submit" value="Submit"/>
	        </td>
	    </tr>
	</table>  
	</form:form>
 </body>
</html>