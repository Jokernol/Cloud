<a href="">
    <img src="/upload/static/Avatar/{{$user->name.'.jpg'}}" onerror="this.src='../../../public/static/Avatar/fang.jpg'" class="gravatar">
</a>
<a href="{{route('users.show', $user->id)}}">
    <h1 style="color:black;">${requestScope.user.userName}</h1>
</a>



<%--<a href="{{route('users.show', $user->id)}}">--%>
<%--    <img src="/upload/static/Avatar/{{$user->name.'.jpg'}}" onerror="this.src='/upload/static/Avatar/default.jpg'" class="gravatar">--%>

<%--    <h1 style="color:black;">{{$user->name}}</h1>--%>
<%--</a>--%>
