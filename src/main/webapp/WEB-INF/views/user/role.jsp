<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
 <div class="body">
<form:form id="roleForm" method="POST" modelAttribute="role" action="/QvantelRecruitmentTracking/user/createRole">
	   <table>
	        <tr><td><form:label path="roleName"></form:label>Role Name</td><td><form:input path="roleName" class="required" type="text" id="roleName" /></td></tr>
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