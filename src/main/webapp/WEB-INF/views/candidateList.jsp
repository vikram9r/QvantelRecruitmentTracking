<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Candidate List</title>
<script type = "text/javascript">
         /* $(document).ready(function() {
			
            $("#createCandidate").click(function(event){
				
               $.post( 
                  "newCandidate",
                  function(data) {
                     $('#candidatesTab').html(data);
                  }
               );
					
            });
				
         }); */
      </script>
</head>
<body>
 <input type = "button" onclick="createCandidate();" value = "Create new" style="float: right;" />
	<c:if test="${not empty candidateList}">
	 <table style="border-spacing: 42px 1px;">
	   <tr align="left"><th>ID</th><th>Name</th><th>Eamil</th><th>Mobile</th></tr>
	    <c:forEach items="${candidateList}" var="candidate">
	        <tr align="left">
	        	<td><input type="checkbox" id="candidate_${candidate.id}"/></td>
	            <td><c:out value="${candidate.id}" /></td>
	            <td><c:out value="${candidate.firstName}" /></td>
	            <td><c:out value="${candidate.email}" /></td>
	            <td><c:out value="${candidate.mobile}" /></td>
	            <td><a href="javascript:viewResume('${candidate.id}');" >view Resume</a></td>
	        </tr>
	    </c:forEach>
	 </table>
	</c:if>
	<c:if test="${empty candidateList}">
	  <p>No data</p>
	</c:if>
</body>
</html>