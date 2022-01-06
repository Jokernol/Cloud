<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

<rapid:override name="content">
    <div class="offset-md-2 col-md-8">
        <c:forEach items="${requestScope.riskList}" var="risk">
            <ul class="list-unstyled">
                <li class="media mt-4 mb-4">
                    <a href="">
                        <img src="../../../public/static/Avatar/1.jpg" onerror="this.src='../../../public/static/1.jpg'" alt="{{ $user->name }}" class="mr-3 gravatar"/>
                        <h6 class="mt-0 mb-1" style="color: black">risk.key.name</h6>
                    </a>
                    <div class="media-body">
                        <h5 class="mt-0 mb-1">申请内容<small></small></h5>
                            七天内是否发烧:${risk.value.temperature}  近日身体状况:${risk.value.bodySituation} 今日通过地点: ${risk.value.}
                    </div>

                </li>
            </ul>
        </c:forEach>
    </div>
</rapid:override>
<%@include file="../layouts/default.jsp"%>
