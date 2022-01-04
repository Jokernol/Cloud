<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<rapid:override name="content">
  <div class="row" style="margin-top: 5vh">
    <div class="col-md-8">
      <section class="status_form">
        <%@ include file="../shared/picture_search.jsp"%>
      </section>
      <h4>相册列表</h4>
      <hr>
      <c:forEach items="${requestScope.pictureList}" var="picture">
        <%@ include file="../picture/pictureList.jsp"%>
      </c:forEach>

    </div>
    <aside class="col-md-4">
      <section class="user_info">
        <%@ include file="../shared/user_info.jsp"%>
      </section>
      <section>
        <%@ include file="../shared/follow.jsp"%>
      </section>
      <section class="stats mt-2">
        <%@ include file="../shared/stats.jsp"%>
      </section>
    </aside>
  </div>
</rapid:override>
<%@include file="../layouts/default.jsp"%>
