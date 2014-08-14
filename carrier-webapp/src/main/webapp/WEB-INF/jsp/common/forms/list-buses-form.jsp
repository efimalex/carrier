<%@ page language="java" contentType="text/html;UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<spring:message code="form.bus.list.caption" var="form_caption"/>
<spring:message code="link.edit" var="link_edit_caption"/>
<spring:message code="link.add" var="link_add_caption"/>
<spring:message code="table.buses.head.index" var="th_index"/>
<spring:message code="table.buses.head.seatcount" var="th_seatcount"/>
<spring:message code="table.buses.head.statenumber" var="th_statenumber"/>

<div class="form-container center-block">
<div class="form-title">${form_caption}</div>
<table>
    <thead>
    <tr>
        <th>${th_index}</th>
        <th>${th_seatcount}</th>
        <th>${th_statenumber}</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${buses}" varStatus="status" var="bus">
        <tr>
            <td align="left">
                    <c:out value="${status.count}"/>
            </td>
            <td>${bus.seats}</td>
            <td>${bus.stateNumber}</td>
            <td><a href='<spring:url value="/carrierplace/buses/${bus.id}/edit"/>'>${link_edit_caption}</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href='<spring:url value="/carrierplace/buses/create"/>'>${link_add_caption}</a>
</div>
