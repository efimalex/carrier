<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"/>
<div class="content">
    <div class="payment_form">
        <form:form method="post" action="placePayment" class="form" id="payment_form">
            <jsp:include page="../common/providerinfo/providerinfo.jsp"/>
            <jsp:include page="form.jsp"/>
        </form:form>
    </div>
</div>
<jsp:include page="script.jsp"/>