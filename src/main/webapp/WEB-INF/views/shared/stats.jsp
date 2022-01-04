
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<a href="/concern/idols/${requestScope.user.id}">
    <strong id="following" class="stat">
        ${requestScope.IdolNumber}
    </strong>
    关注
</a>
<a href="/concern/follows/${requestScope.user.id}">
    <strong id="followers" class="stat">
        ${requestScope.followNumber}
    </strong>
    粉丝
</a>
<a>

    <strong id="statuses" class="stat">
        ${requestScope.PictureNumber}
    </strong>
    相册
</a>
