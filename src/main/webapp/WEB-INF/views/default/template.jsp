<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	  <title>Qvantel Recruitment Tracking</title>
	  <!-- <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"> -->
	  <link href="<c:url value='/resources/css/jquery-ui.css' />" rel="stylesheet">
      <link href="<c:url value='/resources/css/jquery-ui.theme.css' />" rel="stylesheet">
      <link href="<c:url value='/resources/css/jquery-ui.structure.min.css' />" rel="stylesheet">
      <link rel="stylesheet" href="<c:url value='/resources/css/ui.jqgrid.css' />">
	  <!-- <link rel="stylesheet" href="/resources/demos/style.css"> -->
	  
	  <script src="<c:url value='/resources/js/jquery-1.11.1.min.js' />"></script>  
	  <script src="<c:url value='/resources/js/jquery-ui.min.js' />"></script>  
	  <script src="<c:url value='/resources/js/i18n/grid.locale-en.js' />"></script>
	  <script src="<c:url value='/resources/js/jquery.jqGrid.min.js' />"></script>
	  
	  <!-- <script src="//code.jquery.com/jquery-1.10.2.js"></script>
	  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script> -->
	  <script src="http://malsup.github.com/jquery.form.js"></script>
	  <script type="text/javascript" src="<c:url value="/resources/js/Candidate.js" />"></script>
    <style type="text/css">
    body {
        margin:0px;
        padding:0px;
        height:100%;
        overflow:hidden;
    }
 
    .page {
        min-height:100%;
        position:relative;
    }
     
    .header {
        padding:10px;
        width:100%;
        text-align:center;
    }
     
    .content {
            padding:10px;
            padding-bottom:20px; /* Height of the footer element */
            overflow:hidden;
    }
     
    .menu {
        padding:50px 10px 0px 10px;
        width:200px;
        float:left;
    }
 
    .body {
        margin:50px 10px 0px 250px;
    }
     
    .footer {
        clear:both;
        position:absolute;
        bottom:0;
        left:0;
        text-align:center;
        width:100%;
        height:20px;
    }
     
    </style>
</head>
<body>
    <div class="page">
        <tiles:insertAttribute name="header" />
        <div class="content">
            <tiles:insertAttribute name="menu" />
            <tiles:insertAttribute name="body" />
        </div>
        <tiles:insertAttribute name="footer" />
    </div>
</body>
</html>