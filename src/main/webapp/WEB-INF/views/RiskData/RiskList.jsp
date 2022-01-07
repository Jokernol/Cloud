<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

<rapid:override name="content">
    <div class="offset-md-2 col-md-8">
        <c:forEach items="${requestScope.riskList}" var="risk">
            <ul class="list-unstyled">
                <li class="media mt-4 mb-4">
                    <a href="">
                        <img src="../../../public/static/Avatar/${risk.value.userId}.jpg" onerror="this.src='../../../public/static/fang.jpg'" alt="{{ $user->name }}" class="mr-3 gravatar"/>
                        <h6 class="mt-0 mb-1" style="color: black">${risk.key.name}</h6>
                    </a>
                    <div class="media-body">
                        <h5 class="mt-0 mb-1">申报内容<small></small></h5>
                        ${risk.value.temperature}  近日身体状况:${risk.value.bodySituation} 今日通过地点: ${risk.value.viaPlace}

                    </div>
                    <a class="nav-link  btn btn-sm  btn-outline-primary" href="/chat/chat/${risk.value.userId}"onclick="return confirm('即将进入聊天')">探访</a>
                    |
                    <a class="nav-link dropdown-toggle btn btn-sm  btn-outline-info" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        处理
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/user/auditDeclaration/${risk.value.userId}?riskRating=0" onclick="return confirm('确定设为低风险吗');">低风险</a>

                        <a class="dropdown-item" href="/user/auditDeclaration/${risk.value.userId}?riskRating=2" onclick="return confirm('确定设为高风险吗');">高风险</a>
                    </div>
                </li>
            </ul>
        </c:forEach>
    </div>
</rapid:override>
<%@include file="../layouts/default.jsp"%>
