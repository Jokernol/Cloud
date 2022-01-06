<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<rapid:override name="content">


  <a href="/user/test2">
    <label class="form-control btn btn-info" style="width: 100px;">增加地点</label>
  </a>
  <a href="/pictures/to_upload">
    <label class="form-control btn btn-dark" style="width: 100px;">删除</label>
  </a>
  <section>
    <ul class="imglist">
      <li>
        高风险:
      </li>
      <li>
        <div style="width: 25px;height: 25px; border: 1px solid #ff0000;border-radius: 50%;background-color: #ff0000;">
        </div>
      </li>
      <li>
        中风险:
      </li>
      <li>
        <div style="width: 25px;height: 25px; border: 1px solid yellow;border-radius: 50%;background-color: #ffff00;">
        </div>
      </li>
    </ul>
  </section>

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



    // var icon = new AMap.Icon({
    //   size : new AMap.Size(40,50),
    //   image : '../../../public/upload/1.png',
    //   imageOffset : new AMap.Pixel(0.-60),
    //   imageSiz : new AMap.Size(40,50)
    // });

    // 高风险
    var markers = new AMap.Marker({
      position : new AMap.LngLat(120.024738,30.219455),
      icon : '../../../public/static/icon/1.png',
      extData : 1,
      anchor : 'bottom-center',
      clickable : true,
    })

    markers.on('dblclick',function(e){
      var msg = "即将跳转查看该风险地区详情信息";
      if (confirm(msg)==true){
        setform(e.target.getExtData());
      }else{
        return false;
      }
    })

    function setform(id){
      window.location.href = "/user/list/"+id;
    }


    map.add(markers);

    var circle = new AMap.Circle({
      center : new AMap.LngLat(120.024738,30.219455),
      radius : 100,
      fillColor : 'red',
      strokeColor : '#fff',
    })
    map.add(circle);



    var markers1= new AMap.Marker({
      position : new AMap.LngLat(120.025738,30.209455),
      title : '浙江科技学院',
      icon : '../../../public/static/icon/1.png',
      anchor : 'bottom-center',
      clickable : true,
    })

    map.add(markers1);

    var circle1 = new AMap.Circle({
      center : new AMap.LngLat(120.025738,30.209455),
      radius : 100,
      fillColor : 'yellow',
      strokeColor : '#fff',
    })

    map.add(circle1);

    var markers2= new AMap.Marker({
      position : new AMap.LngLat(120.019398,30.214428),
      title : '浙江科技学院',
      icon : '../../../public/static/icon/2.png',
      anchor : 'bottom-center',
      clickable : true,
    })

    map.add(markers2);



  </script>
</rapid:override>
<%@include file="../layouts/default.jsp"%>
