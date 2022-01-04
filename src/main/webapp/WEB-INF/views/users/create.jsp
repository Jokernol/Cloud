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

                <form method="POST" action="${pageContext.request.contextPath}/user/create">

                    <div class="form-group">
                        <label for="name" >*姓名：</label>
                        <input type="text" name="userName" id="name" class="form-control" value="${user.userName}">
                    </div>

                    <div class="form-group">
                        <label for="intro" >intro：</label>
                        <input type="text" name="intro" id="intro" class="form-control" value="${user.intro}">
                    </div>

                    <div class="form-group">
                        <label for="email">邮箱：</label>
                        <input type="text" id="email" name="email" class="form-control" value="${user.email}">
                    </div>

                    <div class="form-group">
                        <label for="mobile">*电话：</label>
                        <input type="text" id="mobile" name="mobile" class="form-control" value="${user.mobile}">
                    </div>

                    <div class="form-group">
                        <label for="QQ">QQ：</label>
                        <input type="text" id="QQ" name="QQ" class="form-control" value="${user.QQ}">
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
