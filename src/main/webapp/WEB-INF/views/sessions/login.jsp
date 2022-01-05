<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<rapid:override name="content">

  <div class="offset-md-9 col-md-4" style="margin-top: 5vh" >
    <div class="card ">
      <div class="card-header">
        <h5>登录</h5>
      </div>
      <div class="card-body">


        <form method="POST" action="/session/login">
          <div class="form-group">
            <label for="loginName">账号</label>
            <input type="text" name="name" id="loginName" class="form-control" value="${requestScope.u.name}" >
          </div>

          <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" name="password" id="password" class="form-control">
          </div>

          <div class="form-group">
            <div class="form-check">
              <input type="checkbox" class="form-check-input" name="remember" id="exampleCheck1">
              <label class="form-check-label" for="exampleCheck1">记住我</label>
            </div>
          </div>

          <button type="submit" class="btn btn-primary">登录</button>
        </form>

        <hr>

        <p>还没账号？<a href="/user/regist">现在注册！</a></p>
      </div>
    </div>
  </div>
</rapid:override>
<%@include file="../layouts/default.jsp"%>
