<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<div class="content">
    <div class="manipulateItemMenu busesMenu">
        <tiles:insertAttribute name="busMenu"/>
    </div>

    <div>
        <tiles:insertAttribute name="busBody"/>
    </div>

</div>