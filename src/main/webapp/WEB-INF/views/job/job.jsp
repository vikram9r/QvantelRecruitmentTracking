<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<c:url var="appContext" value="/" />
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
 <div class="body">
   <input type = "button" onclick="location.href='${appContext}job/view';" value = "View Jobs" style="float: right;"/>
	<form:form id="jobForm" method="POST" modelAttribute="job" action="${appContext}job/save">
	   <table>

			<tr>
				<td><form:label path="jobTitle"></form:label>Job Title</td>
				<td><form:input path="jobTitle" class="required" type="text"
						id="jobTitle" /></td>
			</tr>
			<tr>
				<td><form:label path="designation"></form:label>Designation</td>
				<td><form:input path="designation" class="required" type="text"
						id="designation" /></td>
			</tr>
			<tr>
				<td><form:label path="industry"></form:label>Industry</td>
				<td><form:input path="industry" class="required" type="text"
						id="industry" /></td>
			</tr>
			<tr>
				<td><form:label path="functionalArea"></form:label>Functional
					Area</td>
				<td><form:input path="functionalArea" class="required"
						type="text" id="functionalArea" /></td>
			</tr>
			<tr>
				<td><form:label path="briefDescription"></form:label>Brief
					Description</td>
				<td><form:input path="briefDescription" class="required"
						type="text" id="briefDescription" /></td>
			</tr>
			<tr>
				<td><form:label path="detailDescription"></form:label>Detail
					Description</td>
				<td><form:textarea path="detailDescription" class="required"
						type="text" id="detailDescription" /></td>
			</tr>
			<tr>
				<td><form:label path="mainSkill"></form:label>Main Skill</td>
				<td><form:input path="mainSkill" class="required" type="text"
						id="mainSkill" /></td>
			</tr>
			<tr>
				<td><form:label path="qualification"></form:label>Qualification</td>
				<td><form:input path="qualification" class="required"
						type="text" id="qualification" /></td>
			</tr>
			<tr>
				<td><form:label path="minimumExperience"></form:label>Minimum
					Experience</td>
				<td><form:input path="minimumExperience" class="required"
						type="text" id="minimumExperience" /></td>
			</tr>
			<tr>
				<td><form:label path="maximumExperience"></form:label>Maximum
					Experience</td>
				<td><form:input path="maximumExperience" class="required"
						type="text" id="maximumExperience" /></td>
			</tr>
			<tr>
				<td><form:label path="startDate"></form:label>Start Date</td>
				<td><form:input path="startDate" class="required" type="text"
						id="startDate" /></td>
			</tr>
			<tr>
				<td><form:label path="lastDate"></form:label>Last Date</td>
				<td><form:input path="lastDate" class="required" type="text"
						id="lastDate" /></td>
			</tr>
			<tr>
				<td><form:label path="recruiters"></form:label>Recruiters</td>
				<td><form:input path="recruiters" class="required" type="text"
						id="recruiters" /></td>
			</tr>
			<tr>
				<td><form:label path="contactName"></form:label>Contact Name</td>
				<td><form:input path="contactName" class="required" type="text"
						id="contactName" /></td>
			</tr>
			<tr>
				<td><form:label path="contactEmail"></form:label>Contact Email</td>
				<td><form:input path="contactEmail" class="required"
						type="text" id="contactEmail" /></td>
			</tr>
			<tr>
				<td><form:label path="emailNotification"></form:label>Email
					Notification</td>
				<td><form:radiobutton path="emailNotification" value="1" label="Yes" /><form:radiobutton path="emailNotification" value="0" label="No" /></td>
			</tr>
			<tr>
				<td><form:label path="city"></form:label>City</td>
				<td><form:input path="city" class="required" type="text"
						id="city" /></td>
			</tr>
			<tr>
				<td><form:label path="state"></form:label>State</td>
				<td><form:input path="state" class="required" type="text"
						id="state" /></td>
			</tr>
			<tr>
				<td><form:label path="country"></form:label>Country</td>
				<td><form:input path="country" class="required" type="text"
						id="country" /></td>
			</tr>
			<tr>
				<td><form:label path="requirementType"></form:label>Requirement
					Type</td>
				<td><form:input path="requirementType" class="required"
						type="text" id="requirementType" /></td>
			</tr>
			<tr>
				<td><form:label path="otherSkills"></form:label>Other Skills</td>
				<td><form:input path="otherSkills" class="required" type="text"
						id="otherSkills" /></td>
			</tr>
			<tr>
				<td><form:label path="noOfOpenings"></form:label>No Of Openings</td>
				<td><form:input path="noOfOpenings" class="required"
						type="text" id="noOfOpenings" /></td>
			</tr>
			<tr>
				<td><form:label path="jobStage"></form:label>Job Stage</td>
				<td><form:input path="jobStage" class="required" type="text"
						id="jobStage" /></td>
			</tr>
			<tr>
				<td><form:label path="makeSalaryVisibleToPublic"></form:label>Make
					Salary Visible To Public</td>
				<td><form:radiobutton path="makeSalaryVisibleToPublic" value="1" label="Yes" /><form:radiobutton path="makeSalaryVisibleToPublic" value="0" label="No" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>  
	</form:form>
 </div>
 </tiles:putAttribute>
</tiles:insertDefinition>