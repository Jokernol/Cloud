<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<rapid:override name="content">
    <div class="offset-md-2 col-md-8">
        <h2 class="mb-4 text-center">申报用户列表</h2>
        <%@ include file="../shared/user_search.jsp"%>
        <div class="list-group list-group-flush">
            <%@include file="../shared/user.jsp"%>
        </div>
        <div class="mt-3">
        </div>
    </div>
</rapid:override>
<%@include file="../layouts/default.jsp"%>
