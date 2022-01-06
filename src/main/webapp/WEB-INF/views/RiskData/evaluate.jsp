<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<rapid:override name="content">
    <div class="offset-md-2 col-md-8" style="margin-top: 5vh;margin-bottom: 5vh">
        <div class="card ">
            <div class="card-header">
                <h5>申请评估风险等级</h5>
            </div>

            <div class="card-body">
                <h6 style="color: #ed969e ">(注意:带*号为必填信息)</h6>

                <form method="POST" action="${pageContext.request.contextPath}/riskData/add/${user.id}">

                    <div class="form-group">
                        <label>*近7日是否有发烧情况</label>
                        <div class="form-check">
                            <input value="近7日有无发烧 ：是" class="form-check-input" type="radio" name="temperature" id="flexRadioDefault1">
                            <label class="form-check-label" for="flexRadioDefault1">
                                是
                            </label>
                        </div>
                        <div class="form-check">
                            <input value="近七日有无： 没有" class="form-check-input" type="radio" name="temperature" id="flexRadioDefault2" checked>
                            <label class="form-check-label" for="flexRadioDefault2">
                                没有
                            </label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="intro" >*身体状况(近日的身体状况，列如是否有咳嗽等)</label>
                        <input type="text" name="bodySituation" id="intro" class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="password">*今期途经地区：</label>
                        <input type="text" id="password" name="viaPlace" class="form-control">
                    </div>
                    <button type="submit" class="btn btn-primary">提交</button>
                </form>
            </div>
        </div>
    </div>
</rapid:override>
<%@include file="../layouts/default.jsp"%>