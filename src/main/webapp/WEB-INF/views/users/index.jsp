<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<rapid:override name="content">
    <div class="row" style="margin-top: 5vh">
        <div class="col-md-8">


            <section>

                <c:choose>
                <c:when test="${sessionScope.user.riskRating == 0 }">
                    <div class="alert alert-danger">
                        <strong>提示:</strong> 您还为申请小区疫情码，请点击申请
                    </div>
                    <br>
                    <a href="/pictures/to_upload">
                        <label class="form-control btn btn-info" style="width: 200px;" >申请</label>
                    </a>
                    <hr>

                </c:when>
                <c:otherwise>
                    <c:if test="${sessionScope.user.riskRating == 1 }">
                        <div class="alert alert-danger">
                            <strong>提示:</strong> 您的二维码还未审批，请等待工作人员探访或主动申请前往小区疫情中心
                        </div>
                        <br>
                    </c:if>
                    <c:if test="${sessionScope.user.riskRating == 2 && sessionScope.user.healthCodeType >= 1}">
                        <div class="alert alert-warning">
                            <strong>提示:</strong> 您的风险等级大于中级，请居家隔离，风险降低后可外出
                        </div>

                        <br>
                        <a href="/pictures/to_upload">
                            <label class="form-control btn btn-info" style="width: 200px;" >申请重新评估等级</label>
                        </a>
                    </c:if>

                    <a href="/pictures/to_upload">
                        <label class="form-control btn btn-info" style="width: 200px;" >查看/下载二维码</label>
                    </a>

                </c:otherwise>
                </c:choose>
            </section>
            <h4>最近通知</h4>
            <hr>
            <ul class="list-unstyled">

                    <li class="media mt-4 mb-4">
                        <a href="{{ route('users.show', $user->id )}}">
                            <img src="/upload/static/Avatar/{{$user->name.'.jpg'}}" onerror="this.src='../../../public/static/0.jpg'" alt="{{ $user->name }}" class="mr-3 gravatar"/>
                            <h6 class="mt-0 mb-1" style="color: black">管理员</h6>
                        </a>
                        <div class="media-body">
                            <h5 class="mt-0 mb-1">标题<small>/时间</small></h5>
                            通知通知通知
                        </div>
                    </li>
            </ul>
            <ul class="list-unstyled">

                <li class="media mt-4 mb-4">
                    <a href="{{ route('users.show', $user->id )}}">
                        <img src="/upload/static/Avatar/{{$user->name.'.jpg'}}" onerror="this.src='../../../public/static/fang.jpg'" alt="{{ $user->name }}" class="mr-3 gravatar"/>
                        <h6 class="mt-0 mb-1" style="color: black">管理员</h6>
                    </a>
                    <div class="media-body">
                        <h5 class="mt-0 mb-1">标题<small>/时间</small></h5>
                        通知通知通知
                    </div>
                    <c:if test="${sessionScope.user.type == 0}">
                        <form action="{{ route('statuses.destroy', $status->id) }}" method="POST" onsubmit="return confirm('确定删除?');">
                            <button type="submit" class="btn btn-sm btn-danger">删除</button>
                        </form>
                    </c:if>
                </li>
            </ul>
        </div>
        <aside class="col-md-4">
            <section class="user_info">
                <%@ include file="../shared/user_info.jsp"%>
            </section>
            <section class="stats mt-2">
                <%@ include file="../shared/stats.jsp"%>
            </section>
        </aside>
    </div>
</rapid:override>
<%@include file="../layouts/default.jsp"%>
