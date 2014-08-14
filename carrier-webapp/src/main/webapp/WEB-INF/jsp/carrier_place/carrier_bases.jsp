<%@ page language="java" contentType="text/html;UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
    <div class="manipulateItemMenu busesMenu">
        <tiles:insertAttribute name="busMenu"/>
    </div>

    <div class="center-block">
        <tiles:insertAttribute name="busBody"/>
    </div>