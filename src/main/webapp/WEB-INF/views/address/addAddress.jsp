<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<rapid:override name="content">
  <form action="${pageContext.request.contextPath}/riskPlace/addRiskPlace" method="post">
    测试:
    <input name="intro">
    <input name="level">
    <input type="text" id="x" name="x" value="" />
    <input type="text" id="y" name="y" value="" />
    <input onclick="return isNull()" value="提交" type="submit" >
  </form>
  <hr>
  <div id="container" style="height: 80%; width: 100%;"></div>
  <script type="text/javascript">
    window._AMapSecurityConfig = {
      securityJsCode:'382f24be18ead30529cb51dba30055d6',
    }
  </script>

  <script type="text/javascript" src="https://webapi.amap.com/maps?v=2.0&key=b9d53d54a2e98673c97e8f4ac89ab070"></script>

  <script>
    var map = new AMap.Map('container', {
      zoom:15,//级别
      center: [120.024738,30.219455],//中心点坐标
      viewMode:'3D'//使用3D视图
    });

    var clickHandler = function(e) {
      map.clearMap();
      var marker = new AMap.Marker({
        position: new AMap.LngLat(e.lnglat.getLng(), e.lnglat.getLat()),
        icon: '../../../public/static/icon/1.png',
        anchor : 'bottom-center',
      });

      map.add(marker);
      document.getElementById("x").value = e.lnglat.getLng();
      document.getElementById("y").value = e.lnglat.getLat();
      return e.lnglat.getLng(), e.lnglat.getLat();
    };
    map.on('click', clickHandler);
    function isNull(){
      var  x =  document.getElementById("x").value;
      var  y =  document.getElementById("y").value;
      if (x===""||y===""){
        alert("请选择地点");
        return false;
      }
      return  true;
    }

  </script>
</rapid:override>
<%@include file="../layouts/default.jsp"%>
