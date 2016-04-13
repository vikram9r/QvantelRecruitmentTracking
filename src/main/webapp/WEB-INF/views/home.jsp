<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%-- <head>
  <title>Qvantel Recruitment Tracking</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <script src="http://malsup.github.com/jquery.form.js"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/Candidate.js" />"></script>
 
  <!-- <script type="text/javascript">
  $(function() {
    $( "#tabs" ).tabs();
  });
  </script> -->
</head> --%>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
 
	<div id="body">
	  <ul>
	    <li><a href="<c:url value='/viewJobs' />" >Jobs</a></li>
	    <li><a href="<c:url value='/viewCandidates' />" >Candidates</a></li>
	    <li><a href="#scheduledInterviewsTab">Scheduled Interviews</a></li>
	  </ul>
	</div>
 
 
</tiles:putAttribute>
</tiles:insertDefinition>
