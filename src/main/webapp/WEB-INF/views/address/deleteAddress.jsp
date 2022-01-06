<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<rapid:override name="content">
    <section>
        <ul class="imglist">
            <li>
                高风险:
            </li>
            <li>
                <div style="width: 25px;height: 25px; border: 1px solid red;border-radius: 50%;background-color: red;">
                </div>
            </li>
            <li>
                中风险:
            </li>
            <li>
                <div style="width: 25px;height: 25px; border: 1px solid yellow;border-radius: 50%;background-color: yellow;">
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

        <c:forEach items="${requestScope.riskList}" var="risk">

        var markers = new AMap.Marker({
            position : new AMap.LngLat('${risk.x}','${risk.y}'),
            icon : '../../../public/static/icon/1.png',
            extData : '${risk.id}',
            anchor : 'bottom-center',
            clickable : true,
        })

        markers.on('dblclick',function (e){
            var msg = "确定删除该风险地区吗";
            if(confirm(msg)==true){
                setform(e.target.getExtData());
            }else {
                return false;
            }
        })

        map.add(markers);
        var circle = new AMap.Circle({
            center : new AMap.LngLat('${risk.x}','${risk.y}'),
            radius : 100,
            fillColor : '${risk.level}',
            strokeColor : '#fff',
        })
        map.add(circle);


        </c:forEach>
        function setform(id){
            window.location.href="${pageContext.request.contextPath}/riskPlace/deleteRiskPlace/"+id;
        }
        window.onload=function (){
            var str="${param.info1}";
            if (str){
                alert(str);
            }
        }
    </script>
</rapid:override>
<%@include file="../layouts/default.jsp"%>
