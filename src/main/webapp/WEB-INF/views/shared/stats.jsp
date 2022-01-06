
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<a >
    <strong id="following" class="stat">
        ${requestScope.allRiskPlace}
    </strong>
    所有风险地区数量
</a>
<a>
    <strong id="followers" class="stat">
        ${requestScope.highRiskPlace}
    </strong>
    高风险地区数量
</a>

<a >
    <strong id="dd" class="stat">
        ${requestScope.lowRiskPlace}
    </strong>
    中风险地区数量
</a>
