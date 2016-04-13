<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
 <div class="body">
<form:form id="userForm" method="POST" modelAttribute="user" action="/QvantelRecruitmentTracking/createUser">
	   <table>
	        <tr><td><form:label path="firstName"></form:label>First Name</td><td><form:input path="firstName" class="required" type="text" id="firstName" /></td></tr>
	        <tr><td><form:label path="middleName"></form:label>Middle Name</td><td><form:input path="middleName" class="required" type="text" id="middleName" /></td></tr>
	        <tr><td><form:label path="lastName"></form:label>Last Name</td><td><form:input path="lastName" class="required" type="text" id="lastName" /></td></tr>
	        <tr><td><form:label path="userName"></form:label>User Name</td><td><form:input path="userName" class="required" type="text" id="userName" /></td></tr>
	        <tr><td><form:label path="password"></form:label>Password</td><td><form:password path="password" class="required" id="password" /></td></tr>
	        <tr><td><form:label path="employeeCode"></form:label>Employee Code</td><td><form:input path="employeeCode" class="required" type="text" id="employeeCode" /></td></tr>
	        <tr><td><form:label path="description"></form:label>Description</td><td><form:input path="description" class="required" type="text" id="description" /></td></tr>
	        <tr><td><form:label path="email"></form:label>Email</td><td><form:input path="email" class="required" type="text" id="email" /></td></tr>
	        <tr><td><form:label path="phone"></form:label>Phone</td><td><form:input path="phone" class="required" type="text" id="phone" /></td></tr>
	        <tr><td><form:label path="mobile"></form:label>Mobile</td><td><form:input path="mobile" class="required" type="text" id="mobile" /></td></tr>
	        <%-- <tr><td><form:label path="role"></form:label>Role</td><td><form:input path="role" class="required" type="text" id="role" /></td></tr> --%>
	        <tr>
	        <td colspan="2">
	            <input type="submit" value="Submit"/>
	        </td>
	    </tr>
       </table>
</form:form> 
 </div>
 </tiles:putAttribute>
</tiles:insertDefinition>