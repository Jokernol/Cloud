<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach items="${requestScope.userP}" var="uP">
    <div class="list-group-item">
        <a href="/user/show/${uP.key.id}">
            <img class="mr-3" src="/upload/static/Avatar/{{$user->name.'.jpg'}}" onerror="this.src='../../../public/static/Avatar/fang.jpg'" alt="{{ $user->name }}" width=32>
                ${uP.key.userName}
        </a>
        <c:if test="${sessionScope.user.type == 0}">
            <form action="{{route('users.destroy',$user->id)}}" method="post" class="float-right">
                <button type="submit" class="btn btn-sm btn-danger delete-btn">删除</button>
            </form>
        </c:if>
    </div>
    <div >
        <ul class="imglist">
            <c:forEach items="${uP.value}" var="p">
                <li>
                    <img class="mr-2" src="${p.fname}"  width=150 height="150">
                </li>
        </c:forEach>
        </ul>
    </div>
</c:forEach>
