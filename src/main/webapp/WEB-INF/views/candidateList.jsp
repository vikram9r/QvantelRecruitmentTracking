<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Candidate List</title>
<script type = "text/javascript" language = "javascript">
         $(document).ready(function() {
			
            $("#createCandidate").click(function(event){
				
               $.post( 
                  "newCandidate",
                  { name: "Zara" },
                  function(data) {
                     $('#candidateList').html(data);
                  }
               );
					
            });
				
         });
      </script>
</head>
<body>
<div id="candidateList">
<input type = "button" id = "createCandidate" value = "Create new" align="left" />
	<c:if test="${not empty candidateList}">
	 <table>
	    <c:forEach items="${candidateList}" var="candidate">
	        <tr>
	            <td><c:out value="${candidate.id}" /></td>
	            <td><c:out value="${candidate.firstName}" /></td>
	            <td><c:out value="${candidate.email}" /></td>
	            <td><c:out value="${candidate.mobile}" /></td>
	        </tr>
	    </c:forEach>
	 </table>
	</c:if>
</div>
</body>
</html>