<%@ taglib prefix="rapcid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%--
  Created by IntelliJ IDEA.
  User: 25878
  Date: 2021/12/18
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>redamancy</title>
    <link rel="stylesheet" href="../../../public/app.css">

    <style type="text/css">
        .imglist li{float:left;display:inline;}
    </style>


</head>
<body>

<%@ include file="header.jsp"%>
<div class="container">
    <div class="offset-md-12 col-md-12">

        <%@ include file="../shared/messages.jsp"%>

        <rapcid:block name="content">

        </rapcid:block>
        <%@ include file="footer.jsp"%>
    </div>
</div>
<script src="../../../public/app.js"></script>

<script  type="text/javascript">
    function msgHid(){
        document.getElementById("msg").style.display="none";
    }

    setTimeout(msgHid,2000);
</script>
</body>
</html>
