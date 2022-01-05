<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <div class="list-group-item">
        <a href="/cat/${uP.key.id}">
            <img class="mr-3" src="../../../public/static/Avatar/#{}.jpg" onerror="this.src='../../../public/static/Avatar/fang.jpg'" alt="{{ $user->name }}" width=32>
                ${uP.key.userName} 用户名
        </a>
            <form action="/user/delete/{}" method="post" class="float-right">
                <button type="submit" class="btn btn-sm btn-success">修改</button>
            </form>
        <form action="/user/delete/{}" method="post" class="float-right">
            <button type="submit" class="btn btn-sm btn-success">驳回</button>
        </form>
    </div>
<div >
        <ul class="imglist">
            //申请内容
                <li>
                    <div class="media-body">
                        <h5 class="mt-0 mb-1">${info.title}<small>/${info.time}</small></h5>
                            ${info.description}
                    </div>
                </li>
        </ul>
    </div>
