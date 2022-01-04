<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="text-center mt-2 mb-4" style="display: flex ;justify-content: center">
  <c:choose>
    <c:when test="${requestScope.isFollower}">
      <form action="/concern/cancel/${requestScope.user.id}" method="post">
        <button type="submit" class="btn btn-sm btn-outline-primary">取消关注</button>
      </form>
    </c:when>
    <c:otherwise>
      <form action="/concern/follow/${requestScope.user.id}" method="post">
        <button type="submit" class="btn btn-sm btn-primary">关注</button>
      </form>
    </c:otherwise>
  </c:choose>
</div>


