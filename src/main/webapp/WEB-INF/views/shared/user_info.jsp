<a href="/user/changeAvatar">
    <img src="../../../public/static/Avatar/${sessionScope.user.id}.jpg" onerror="this.src='../../../public/static/Avatar/fang.jpg'" class="gravatar">
</a>
    <h1 style="color:black;">${sessionScope.user.name}</h1>



<%--<a href="{{route('users.show', $user->id)}}">--%>
<%--    <img src="/upload/static/Avatar/{{$user->name.'.jpg'}}" onerror="this.src='/upload/static/Avatar/default.jpg'" class="gravatar">--%>

<%--    <h1 style="color:black;">{{$user->name}}</h1>--%>
<%--</a>--%>
