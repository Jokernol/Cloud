
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<a href="/user/test">
    <strong id="following" class="stat">
        ${requestScope.allRiskPlace}
    </strong>
    所有险地区数量
</a>
<a href="/user/test">
    <strong id="followers" class="stat">
        ${requestScope.highRiskPlace}
    </strong>
    高风险地区数量
</a>

<a href="/user/test">
    <strong id="dd" class="stat">
        ${requestScope.lowRiskPlace}
    </strong>
    中风险地区数量
</a>
