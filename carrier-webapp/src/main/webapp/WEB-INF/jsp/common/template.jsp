<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=9;chrome=1"/>
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>" media="screen" rel="stylesheet"
          type="text/css"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css?20140716"/>" type="text/css"/>

    <script type="text/javascript" src="<c:url value='/resources/js/jquery/jquery-1.11.1.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/custom/scripts.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/bootstrap/js/bootstrap.js'/>"></script>
    <title><tiles:insertAttribute name="title"/></title>
</head>
<body>
<div id="wrapper">
    <tiles:insertAttribute name="header"/>
    <div id="cont" class="center-block">
        <tiles:insertAttribute name="content"/>
    </div>
    <tiles:insertAttribute name="footer"/>
</div>
</body>
</html>
