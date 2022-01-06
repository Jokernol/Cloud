<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

<rapid:override name="content">
<div class="offset-md-2 col-md-8">
    <h2 class="mb-4 text-center">用户列表</h2>
    <div class="offset-md-2 col-md-8">
        <div class="list-group list-group-flush">
            <%@ include file="../shared/user_search.jsp"%>
            <c:forEach items="${requestScope.userList}" var="user">
                <div class="list-group-item" style="height: 100px;">

                    <ul class="list-unstyled">

                        <li class="media mt-4 mb-4">

                            <img class="mr-3" src="../../../public/static/Avatar/${user.id}.jpg" onerror="this.src='../../../public/static/Avatar/fang.jpg'" alt="{{ $user->name }}" width=32>
                            <a href="/chat/chat/${user.id}">
                                    ${user.name}
                            </a>/
                            <c:choose>
                                <c:when test="${user.riskRating == 1 }">
                                    <input class="btn btn-sm btn-warning" size="2" value="未审批">
                                </c:when>
                                <c:otherwise>
                                    <c:if test="${user.riskRating ==2 }">
                                        <input  class="btn btn-sm btn-danger" size="2" value="高风险">
                                    </c:if>
                                    <c:if test="${user.riskRating ==0 }">
                                        <input  class="btn btn-sm btn-success" size="2" value="低风险">
                                    </c:if>
                                </c:otherwise>
                            </c:choose>
                            <div class="media-body">
                                <h5 class="mt-0 mb-1">${info.title}<small>${info.time}</small></h5>
                                    ${info.description}
                            </div>
                            <a class="nav-link  btn btn-sm  btn-outline-primary" href="/chat/chat/${user.id}" onclick="return confirm('即将进入聊天')">探访</a>
                            |
                            <a class="nav-link dropdown-toggle btn btn-sm  btn-outline-info" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                修改风险等级
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="/user/changeRiskRating/${user.id}?riskRating=0" onclick="return confirm('确定设为低风险吗');">低风险</a>

                                <a class="dropdown-item" href="/user/changeRiskRating/${user.id}?riskRating=2" onclick="return confirm('确定设为高风险吗');">高风险</a>
                            </div>
                        </li>
                    </ul>

                </div>


            </c:forEach>
        </div>
    </div>
</div>
</rapid:override>
<%@include file="../layouts/default.jsp"%>
