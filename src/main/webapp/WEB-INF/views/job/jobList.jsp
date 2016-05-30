<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<c:url var="appContext" value="/" />
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
 <div class="body">
 <input type = "button" onclick="location.href='${appContext}job/new';" value = "Create new" style="float: right;" />
	<c:if test="${not empty jobList}">
	 <table style="border-spacing: 42px 1px;">
	   <tr align="left"><th>ID</th><th>Title</th><th>Designation</th><th>Min Experience</th></tr>
	    <c:forEach items="${jobList}" var="job">
	        <tr align="left">
	            <td><c:out value="${job.id}" /></td>
	            <td><c:out value="${job.jobTitle}" /></td>
	            <td><c:out value="${job.designation}" /></td>
	            <td><c:out value="${job.minimumExperience}" /></td>
	            <td><a href="${appContext}candidate/applyForJob?job_id=${job.id}" >apply</a></td>
	        </tr>
	    </c:forEach>
	 </table>
	</c:if>
	<c:if test="${empty jobList}">
	  <p>No data</p>
	</c:if>
  </div>
 </tiles:putAttribute>
</tiles:insertDefinition>