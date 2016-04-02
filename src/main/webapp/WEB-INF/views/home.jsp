<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Qvantel Recruitment Tracking</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#tabs" ).tabs();
  });
  </script>
</head>
<body>
 
<div id="tabs">
  <ul>
    <li><a href="#tabs-1">Candidate list</a></li>
    <li><a href="#tabs-2">Job list</a></li>
    <li><a href="#tabs-3">Scheduled Interviews</a></li>
  </ul>
  <div id="tabs-1">
    <jsp:include page="candidateList.jsp" />
  </div>
  <div id="tabs-2">
    <p>yet to do...</p>
  </div>
  <div id="tabs-3">
    <p>yet to do...</p>
  </div>
</div>
 
 
</body>
</html>
