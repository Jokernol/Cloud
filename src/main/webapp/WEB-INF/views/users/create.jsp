<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<rapid:override name="content">
    <div class="offset-md-2 col-md-8" style="margin-top: 5vh;margin-bottom: 5vh">
        <div class="card ">
            <div class="card-header">
                <h5>注册</h5>
            </div>

            <div class="card-body">
                <h6 style="color: #ed969e ">(注意:带*号为必填信息)</h6>

                <form method="POST" action="${pageContext.request.contextPath}/User/regist">

                    <div class="form-group">
                        <label for="name" >*姓名：</label>
                        <input type="text" name="name" id="name" class="form-control" value="${user.name}">
                    </div>

                    <div class="form-group">
                        <label for="intro" >性别</label>
                        <input type="text" name="sex" id="intro" class="form-control" value="${user.sex}">
                    </div>

                    <div class="form-group">
                        <label for="email">*电话:</label>
                        <input type="text" id="email" name="telephone" class="form-control" value="${user.telephone}">
                    </div>

                    <div class="form-group">
                        <label for="habitation">*居住地(门牌号):</label>
                        <input type="text" id="habitation" name="habitation" class="form-control" value="${user.habitation}">
                    </div>

                    <div class="form-group">
                        <label for="QQ">身份证号:</label>
                        <input type="text" id="QQ" name="idCard" class="form-control" value="${user.idCard}">
                    </div>

                    <div class="form-group">
                        <label for="password">*密码：</label>
                        <input type="password" id="password" name="password" class="form-control">
                    </div>

                    <button type="submit" class="btn btn-primary">注册</button>
                </form>
            </div>
        </div>
    </div>
</rapid:override>
<%@include file="../layouts/default.jsp"%>
