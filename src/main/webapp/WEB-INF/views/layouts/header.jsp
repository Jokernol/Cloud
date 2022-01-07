<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 25878
  Date: 2021/12/18
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container ">
        <a class="navbar-brand" href="/user/index">
            <i class="bi bi-umbrella" style="font-size: 28px;color: aliceblue;"></i></a>
        <i class="bi bi-emoji-sunglasses" style="color: whitesmoke;font-size: 28px;"></i>
        <ul class="navbar-nav justify-content-end">


            <c:choose>
                <c:when test="${sessionScope.user != null}">
<%--                    <li class="nav-item"><a class="nav-link" href="/concern/idols/${sessionScope.user.id}">推荐</a></li>--%>
                    <c:if test="${sessionScope.user.type == 0}">
                        <li class="nav-item"><a class="nav-link" href="/user/highUserList">
                            <i class="bi bi-person-x" style="font-size: 28px;color: whitesmoke;" ></i>
                        </a></li>
                        <li class="nav-item"><a class="nav-link" href="/user/userList">
                            <i class="bi bi-person" style="font-size: 28;color: whitesmoke;" ></i>
                        </a></li>

                    </c:if>
                    <c:if test="${sessionScope.user.type == 1 }">
                        <li class="nav-item"><a class="nav-link" href="/chat/chat/1"><i class="bi bi-chat-dots" style="font-size: 28px;color: whitesmoke;"></i></a></li>
                    </c:if>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <img src="../../../public/static/Avatar/${sessionScope.user.id}.jpg" onerror="this.src='../../../public/static/Avatar/fang.jpg'" style="width: 28px;">
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">

                            <a class="dropdown-item">编辑资料</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" id="logout" href="#">
                                <form action="/user/logout" method="POST">
                                    <button class="btn btn-block btn-danger" type="submit" name="button">退出</button>
                                </form>
                            </a>
                        </div>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="nav-item"><a class="nav-link" href="/welcome.jsp">帮助</a></li>
                    <li class="nav-item" ><a class="nav-link" href="/session/login">登录</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>
