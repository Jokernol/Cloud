<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<rapid:override name="content">
    <div class="row" style="margin-top: 5vh">
        <div class="col-md-8">


            <section>

                <c:choose>
                <c:when test="${sessionScope.user.riskRating == 1 }">
                    <div class="alert alert-danger">
                        <strong>提示:</strong> 您还为申请小区疫情码，请申请申报风险等级，在此期间切勿随意走动。
                    </div>
                    <br>
                    <a href="/riskData/evaluate">
                        <label class="form-control btn btn-info" style="width: 200px;" >申请</label>
                    </a>
                    <hr>

                </c:when>
                <c:otherwise>
                    <c:if test="${sessionScope.user.riskRating == 2 }">
                        <div class="alert alert-danger">
                            <strong>提示:</strong> 您的申报仍在审批中，如有工作人员探访请配合人员工作(如有需要，右上角可联系社区管理人员)
                        </div>
                        <br>
                    </c:if>
                    <c:if test="${sessionScope.user.riskRating >= 2 && sessionScope.user.healthCodeType == 1}">
                        <div class="alert alert-warning">
                            <strong>提示:</strong> 您的风险等级大于中级，请居家隔离，风险降低后可外出
                        </div>
                        <br>
                    </c:if>
                    <c:if test="${sessionScope.user.riskRating == 0}">
                        <div class="alert alert-success">
                            <strong>提示:</strong> 您的风险较低，但出现请注意安全，请避开高风险地区(本系统可查看风险分布)
                        </div>
                        <br>
                    </c:if>
                    <a href="${pageContext.request.contextPath}/public/static/qrcode/${sessionScope.user.id}.jpg">
                        <label class="form-control btn btn-info" style="width: 200px;" >查看/下载二维码</label>
                    </a>
                </c:otherwise>
                </c:choose>
            </section>
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
                    </li>
                </ul>
            </c:forEach>
        </div>
        <aside class="col-md-4">
            <section class="user_info">
                <%@ include file="../shared/user_info.jsp"%>
            </section>
            <section class="stats mr-4">
                <%@ include file="../shared/stats.jsp"%>
            </section>
            <br>
            <hr>

            <h4>待处理事件</h4>
            <br>
            <hr>
            <c:if test="${requestScope.notReadNum != 0}">
                <a href="/chat/chat/1">
                    <div style="float:left">
                        待回消息
                    </div>
                    <div style="float: right">
            <span style="border-radius: 50%;    height: 20px;    width: 20px;    display: inline-block;    background: #f30303;      vertical-align: top;">
      <span style="display: block;    color: #FFFFFF;    height: 20px;    line-height: 20px;    text-align: center"> ${requestScope.notReadNum}</span>
            </span>
                    </div>
                </a>
                <br>
                <hr>
            </c:if>
        </aside>

    </div>
</rapid:override>
<%@include file="../layouts/default.jsp"%>
