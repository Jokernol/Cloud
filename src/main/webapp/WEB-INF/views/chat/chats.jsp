<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<rapid:override name="content">
        <ul class="list-unstyled">
            <c:forEach items="${requestScope.chatList}" var="chat">
                <c:choose>
                    <c:when test="${chat.senderId == sessionScope.user.id}">
                        <%@include file="R_chat.jsp"%>
                    </c:when>
                    <c:otherwise>
                        <%@ include file="L_chat.jsp"%>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </ul>
        <h5>
        </h5>
        <%@include file="form_chat.jsp"%>
        <script>
            $(function () {
                $("html, body").animate({
                    scrollTop: $('html, body').get(0).scrollHeight
                }, 1000);
            });
        </script>
</rapid:override>
<%@include file="../layouts/default.jsp"%>
