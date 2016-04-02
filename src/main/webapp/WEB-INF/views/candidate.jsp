<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type = "text/javascript" language = "javascript">
         $(document).ready(function() {
			
            $("#viewCandidates").click(function(event){
				
               $.post( 
                  "viewCandidates",
                  { showType: "view" },
                  function(data) {
                     $('#createCandidate').html(data);
                  }
               );
					
            });
				
         });
      </script>
 </head>
 <body>
  <div id="createCandidate">
   <input type = "button" id = "viewCandidates" value = "View Candidates" />
	<form:form id="candidateForm" method="POST" modelAttribute="candidate" action="/SpringMvcHibernateXML/saveCandidate">
	   <table>
	    <tr>
	        <td><form:label path="firstName">First Name</form:label></td>
	        <td><form:input path="firstName" class="required" type="text" id="firstName" /></td>
	    </tr>
	    <tr>
	        <td><form:label path="middleName">Middle Name</form:label></td>
	        <td><form:input path="middleName" class="required" type="text" id="middleName" /></td>
	    </tr>
	    <tr>
	        <td><form:label path="lastName">Last Name</form:label></td>
	        <td><form:input path="lastName" class="required" type="text" id="lastName" /></td>
	    </tr>
	    <tr>
	        <td><form:label path="mobile">Mobile No</form:label></td>
	        <td><form:input path="mobile" class="required" type="text" id="mobile" /></td>
	    </tr>
	    <tr>
	        <td><form:label path="email">Email ID</form:label></td>
	        <td><form:input path="email" class="required email" type="text" id="email" /></td>
	    </tr>
	    <tr>
	        <td colspan="2">
	            <input type="submit" value="Submit"/>
	        </td>
	    </tr>
	</table>  
	</form:form>
 </div>	
 </body>
</html>