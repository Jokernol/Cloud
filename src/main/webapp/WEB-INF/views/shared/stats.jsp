
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<a href="/user/test">
    <strong id="following" class="stat">
        ${requestScope.IdolNumber}
    </strong>
    所有险地区数量
</a>
<a href="/concern/follows/${requestScope.user.id}">
    <strong id="followers" class="stat">
        ${requestScope.followNumber}
    </strong>
    高风险地区数量
</a>

<a href="/concern/follows/${requestScope.user.id}">
    <strong id="dd" class="stat">
        ${requestScope.followNumber}
    </strong>
    中风险地区数量
</a>
