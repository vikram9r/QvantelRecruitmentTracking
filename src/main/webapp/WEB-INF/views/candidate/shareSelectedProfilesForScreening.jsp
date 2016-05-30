<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <c:url value="j_spring_security_logout" var="logoutUrl" /> --%>
<form action="profilesScreenedTo" method="post" >
	<select name="profiesScreenedTo">
	  <option value="0">--Select--</option>
	  <c:forEach items="${users}" var="user">
	    <option value="${user.id}">${user.firstName} ${user.lastName}</option>
	  </c:forEach>
	</select>
	<input type="hidden" name="candidate_ids" value="${candidate_ids}" />
	<input type="submit" value="Share" />
</form>