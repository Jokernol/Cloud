<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<rapid:override name="content">
  <form action="${pageContext.request.contextPath}/riskPlace/addRiskPlace" method="post">
      <label>*选择风险等级</label>
      <div class="form-check">
        <input value="yellow" class="form-check-input" type="radio" name="level" id="flexRadioDefault1">
        <label class="form-check-label" for="flexRadioDefault1">
          中风险
        </label>
      </div>
      <div class="form-check">
        <input value="red" class="form-check-input" type="radio" name="level" id="flexRadioDefault2" checked>
        <label class="form-check-label" for="flexRadioDefault2">
          高风险
        </label>
      </div>
    <input type="text" id="X" name="X" value="" hidden/>
    <input type="text" id="Y" name="Y" value="" hidden/>
    <input class="btn btn-sm btn-outline-primary" onclick="return isNull()" value="提交" type="submit" >
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
      document.getElementById("X").value = e.lnglat.getLng();
      document.getElementById("Y").value = e.lnglat.getLat();
      return e.lnglat.getLng(), e.lnglat.getLat();
    };
    map.on('click', clickHandler);
    function isNull(){
      var  x =  document.getElementById("X").value;
      var  y =  document.getElementById("Y").value;
      if (x===""||y===""){
        alert("请选择地点");
        return false;
      }
      return  true;
    }

  </script>
</rapid:override>
<%@include file="../layouts/default.jsp"%>
