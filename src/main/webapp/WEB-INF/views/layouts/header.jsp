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
        <a class="navbar-brand" href="/user/index">个人首页</a>
        <ul class="navbar-nav justify-content-end">


            <c:choose>
                <c:when test="${sessionScope.user != null}">
<%--                    <li class="nav-item"><a class="nav-link" href="/concern/idols/${sessionScope.user.id}">推荐</a></li>--%>

                    <c:if test="${sessionScope.user.type == 0}">
                        <li class="nav-item"><a class="nav-link" href="/user/userList">用户列表</a></li>
                    </c:if>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            ${sessionScope.user.name}
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">

                            <a class="dropdown-item" href="/user/edit">编辑资料</a>
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
                    <li class="nav-item"><a class="nav-link" href="/user/to_fang">帮助</a></li>
                    <li class="nav-item" ><a class="nav-link" href="/user/to_login">登录</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>
