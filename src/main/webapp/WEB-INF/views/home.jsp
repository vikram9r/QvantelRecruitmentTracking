<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
  <title>Qvantel Recruitment Tracking</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <script src="http://malsup.github.com/jquery.form.js"></script> 
  <script type="text/javascript" src="<c:url value="/resources/js/Candidate.js" />"></script>
 
  
</head>
<body>
 
<div id="tabs">
  <ul>
    <li><a href="#jobsTab" onclick="viewJobs();">Jobs</a></li>
    <li><a href="#candidatesTab" onclick="viewCandidates();">Candidates</a></li>
    <li><a href="#scheduledInterviewsTab">Scheduled Interviews</a></li>
  </ul>
  <div id="jobsTab">
    <jsp:include page="jobList.jsp" />
  </div>
  <div id="candidatesTab">
    <jsp:include page="candidateList.jsp" />
  </div>
  <div id="scheduledInterviewsTab">
    <p>yet to do...</p>
  </div>
</div>
 
 
</body>
</html>
