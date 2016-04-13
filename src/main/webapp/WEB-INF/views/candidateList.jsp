<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<c:url var="appContext" value="/" />
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    <script>
    $(document).ready(function() {
	    $('#shareForScreening-dialog').dialog({
	        autoOpen: false,
	        title: 'Whom to share ?'
	    });
	    $('#shareForScreening-button').click(function() {
	    	var candidates = $('input[name=checkboxlist]:checked').map(function()
	                {
	                    return $(this).val();
	                }).get();
	    	$.post( 
	    			"shareProfilesForScreening",
	    			{ candidate_ids: candidates },
	    			function(data) {
	    				$('#shareForScreening-dialog').html(data);
	    			}
	    	);
	        $('#shareForScreening-dialog').dialog('open');
	        return false;
	    });
	    
    });   
  </script>
  <!-- Share for screening dialog box  start-->
  <div id="shareForScreening-dialog" title="Whom to share ?"></div>
 <!-- Share for screening dialog box  end-->
 <div class="body">
 <!-- <input type = "button" id="shareForScreening" value = "Share for screening" style="float: right;" /> -->
 <button id="shareForScreening-button" style="float: right;">Share for Screening</button>
 <input type = "button" onclick="location.href='${appContext}newCandidate';" value = "Create new" style="float: right;" />
	<c:if test="${not empty candidateList}">
	 <table style="border-spacing: 42px 1px;">
	   <tr align="left"><th></th><th>ID</th><th>Name</th><th>Eamil</th><th>Mobile</th><th>Status</th></tr>
	    <c:forEach items="${candidateList}" var="candidate">
	        <tr align="left">
	        	<td><input type="checkbox" name="checkboxlist" value="${candidate.id}"/></td>
	            <td><c:out value="${candidate.id}" /></td>
	            <td><c:out value="${candidate.firstName}" /></td>
	            <td><c:out value="${candidate.email}" /></td>
	            <td><c:out value="${candidate.mobile}" /></td>
	            <td><c:out value="${candidate.status}" /></td>
	            <%-- <td><a href="javascript:viewResume('${candidate.id}');" >view Resume</a></td> --%>
	        </tr>
	    </c:forEach>
	 </table>
	</c:if>
	<c:if test="${empty candidateList}">
	  <p>No data</p>
	</c:if>
  </div>
 </tiles:putAttribute>
</tiles:insertDefinition>