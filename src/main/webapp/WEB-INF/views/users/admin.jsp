<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<rapid:override name="content">
    <div class="row" style="margin-top: 5vh">
        <div class="col-md-8">
            <label><i class="bi bi-megaphone" style="font-size: 25px"></i></label>
            <form action="/Info/add" method="POST">
                <input type="text" class="form-control" placeholder="标题..." aria-describedby="sizing-addon1" name="title">
                <textarea class="form-control" rows="3" placeholder="通知..." name="description"></textarea>
                <div class="text-right">
                    <button type="submit" class="btn btn-primary mt-3">发布</button>
                </div>
            </form>
            <h4>最近通知</h4>
            <hr>
            <c:forEach items="${requestScope.infoList}" var="info" >
                <ul class="list-unstyled">
                    <li class="media mt-4 mb-4">
                        <a href="">
                            <img src="../../../public/static/Avatar/1.jpg" onerror="this.src='../../../public/static/1.jpg'" alt="{{ $user->name }}" class="mr-3 gravatar"/>
                            <h6 class="mt-0 mb-1" style="color: black">管理员</h6>
                        </a>
                        <div class="media-body">
                            <h5 class="mt-0 mb-1">${info.title}<small>/${info.time}</small></h5>
                            ${info.description}
                        </div>
                        <form action="/Info/delete/${info.id}" method="POST" onsubmit="return confirm('确定删除?');">
                            <button type="submit" class="btn btn-sm btn-danger"><i class="bi bi-trash" style="font-size: 25px"></i></button>
                        </form>
                    </li>
                </ul>
            </c:forEach>
        </div>
        <aside class="col-md-4">
            <section class="user_info">
                <%@ include file="../shared/user_info.jsp"%>
            </section>
            <section class="stats mt-2">
                <%@ include file="../shared/stats.jsp"%>
            </section>
            <hr>
            <a class="btn-sm btn btn-outline-warning" href="/riskPlace/allAddress">风险地区管理</a>
            <hr>
            <h4>待处理事件</h4>
            <br>
            <hr>
                <a href="/chat/userList" class="btn btn-sm btn-outline-success" >

                    <div style="float:left">
                       待回消息
                    </div>
                    <div style="float: right">
                        <c:if test="${requestScope.notReadNum != 0}">
            <span style="border-radius: 50%;    height: 20px;    width: 20px;    display: inline-block;    background: #f30303;      vertical-align: top;">
      <span style="display: block;    color: #FFFFFF;    height: 20px;    line-height: 20px;    text-align: center"> ${requestScope.notReadNum}</span>
            </span>
                        </c:if>
                    </div>
                </a>
                <a href="/riskData/riskList" class="btn btn-sm btn-outline-dark">
                    <div style="float:left">
                        待处理申报
                    </div>
                    <div style="float: right">
                        <c:if test="${requestScope.notDealRiskData != 0}">
            <span style="border-radius: 50%;    height: 20px;    width: 20px;    display: inline-block;    background: #f30303;      vertical-align: top;">
      <span style="display: block;    color: #FFFFFF;    height: 20px;    line-height: 20px;    text-align: center">${requestScope.notDealRiskData}</span>
            </span>
                        </c:if>
                    </div>
                </a>
                <hr>
        </aside>
    </div>
</rapid:override>
<%@include file="../layouts/default.jsp"%>
