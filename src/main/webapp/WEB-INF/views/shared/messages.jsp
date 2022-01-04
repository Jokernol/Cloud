<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--

  Created by IntelliJ IDEA.
  User: 25878
  Date: 2021/12/18
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<c:forTokens items = "danger,warning,success,info" delims="," var="name">--%>
<%--</c:forTokens>--%>

<c:if test="${requestScope.msg != null && requestScope.info != null}">
    <div class="flash-message" id="msg">
        <p class="alert alert-${requestScope.msg}">
            ${requestScope.info}
        </p>
    </div>
    </c:if>









