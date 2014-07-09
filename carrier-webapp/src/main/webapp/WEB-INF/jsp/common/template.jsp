<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=9;chrome=1"/>

    <title><tiles:insertAttribute name="title"/></title>

</head>
<body>

<div id="wrapper">
    <tiles:insertAttribute name="header"/>
    <div id="content">
        <div class="content_bot">
            <div class="con_top">
                <div class="con_bot">
                    <div class="container clearfix">
                        <tiles:insertAttribute name="body"/>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <tiles:insertAttribute name="footer"/>
</div>

</body>
</html>
