<%@ page language="java" contentType="text/html;UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/carrierplace/buses/lookup/lookupBrandsWithinModel" var="lookupBrandUrl"/>
<script type="text/javascript">
    $(document).ready(function () {
        updateSelectBusModelOptions('${lookupBrandUrl}', 'busBrand', 'busModel');
        setSelectedById('busModel', '${busBean.busModelId}');
    });
</script>
<spring:url value="/carrierplace/buses/save" var="saveBusUrl"/>

<spring:message code="form.bus.edit.caption" var="form_caption"/>
<spring:message code="select.default.optionvalue" var="form_select_default_value"/>
<spring:message code="form.bus.edit.statenumber.label" var="state_number_label"/>
<spring:message code="form.bus.edit.seatcount.label" var="seatcount_label"/>
<spring:message code="form.bus.edit.selectbrand.label" var="selectbrand_label"/>
<spring:message code="form.bus.edit.selectmodel.label" var="selectmodel_label"/>

<div class="panel  panel-primary">
    <div class="panel-heading">
        <div class="form-title">${form_caption}</div>
    </div>
    <div class="panel-body">
        <form:form id="edit_bus_form" action="${saveBusUrl}" modelAttribute="busBean" cssClass="form-horizontal"
                   role="form">
            <div class="form-group">
                <form:label cssClass="col-sm-4 control-label" path="stateNumber"
                            for="sNumber">${state_number_label}</form:label>
                <div class="col-sm-8">
                    <form:input path="stateNumber" cssClass="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <form:label cssClass="col-sm-4 control-label" path="seats">${seatcount_label}</form:label>
                <div class="col-sm-8">
                    <form:input path="seats" cssClass="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <form:label cssClass="col-sm-4 control-label" path="busBrandId">${selectbrand_label}</form:label>
                <div class="col-sm-8">
                    <form:select id="busBrand" path="busBrandId" cssClass="form-control"
                                 onchange="updateSelectBusModelOptions('${lookupBrandUrl}', 'busBrand',  'busModel')">
                        <form:option value="-1">${form_select_default_value}</form:option>
                        <form:options items="${busBrandBean.busBrandSprs}" itemLabel="name" itemValue="id"/>

                    </form:select>
                </div>
            </div>
            <div class="form-group">
                <form:label cssClass="col-sm-4 control-label" path="busModelId">${selectmodel_label}</form:label>
                <div class="col-sm-8">
                    <form:select id="busModel" path="busModelId" cssClass="form-control">
                        <form:option value="${busBean.busModelId}"/>
                    </form:select>
                </div>
            </div>
    </div>
            <div class="modal-footer">
                <tiles:insertAttribute name="editBusFooter"/>
            </div>
        </form:form>

</div>