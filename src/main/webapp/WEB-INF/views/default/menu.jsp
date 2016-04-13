<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="menu">
Menu
    <ul>
        <%-- <li>
            <spring:url value="/home" var="homeUrl" htmlEscape="true"/>
            <a href="${homeUrl}">Home</a>
        </li> --%>
        <li><a href="<spring:url value='/newUser' />" >New User</a></li>
        <li><a href="<spring:url value='/viewJobs' />" >Jobs</a></li>
	    <li><a href="<spring:url value='/viewCandidates' />" >Candidates</a></li>
	    <li><a href="#scheduledInterviewsTab">Scheduled Interviews</a></li>
    </ul>
</div>