<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="menu">
Menu
    <ul>
        <%-- <li>
            <spring:url value="/home" var="homeUrl" htmlEscape="true"/>
            <a href="${homeUrl}">Home</a>
        </li> --%>
        <li><a href="<spring:url value='/user/newRole' />" >New Role</a></li>
        <li><a href="<spring:url value='/user/new' />" >New User</a></li>
        <li><a href="<spring:url value='/job/view' />" >Jobs</a></li>
	    <li><a href="<spring:url value='/candidate/view' />" >Candidates</a></li>
	    <li><a href="#scheduledInterviewsTab">Scheduled Interviews</a></li>
    </ul>
</div>