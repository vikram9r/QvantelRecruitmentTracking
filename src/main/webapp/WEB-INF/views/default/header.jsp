<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="j_spring_security_logout" var="logoutUrl" />

		<!-- csrt support -->
	<form action="/QvantelRecruitmentTracking/j_spring_security_logout" method="post" id="logoutForm">
		<input type="hidden" 
			name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h3 style="float: right;">
			Welcome : ${pageContext.request.userPrincipal.name} | <a
				href="javascript:formSubmit()"> Logout</a>
		</h3>
	</c:if>
<div class="header"><h1>Qvantel Recruitment Tracking</h1></div>