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
                            </a>

                            <div class="media-body">
                                <h5 class="mt-0 mb-1">${info.title}<small>${info.time}</small></h5>
                                    ${info.description}
                            </div>
                            <form action="/chat/chat/${user.id}" onsubmit="return confirm('即将进入聊天');">
                                <button type="submit" class="btn btn-sm btn-outline-primary">探访</button>
                            </form>
                            |
                            <form action="/chat/chat/${user.id}" onsubmit="return confirm('是否修改该用户风险等级');">
                                <button type="submit" class="btn btn-sm btn-primary">修改风险等级</button>
                            </form>
                        </li>
                    </ul>

                </div>


            </c:forEach>
        </div>
    </div>
</div>
</rapid:override>
<%@include file="../layouts/default.jsp"%>
