<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<rapid:override name="content">

  <div id="container" style="height: 100%; width: 100%;"></div>

  <script type="text/javascript">
    window._AMapSecurityConfig = {
      securityJsCode:'382f24be18ead30529cb51dba30055d6',
    }
  </script>

  <script type="text/javascript" src="https://webapi.amap.com/maps?v=1.4.15&key=b9d53d54a2e98673c97e8f4ac89ab070"></script>

  <script>
    var map = new AMap.Map('container', {
      zoom:11,//级别
      center: [116.397428, 39.90923],//中心点坐标
      viewMode:'3D'//使用3D视图
    });
  </script>
</rapid:override>
<%@include file="../layouts/default.jsp"%>
