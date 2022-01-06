<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <form action="/chat/form/${requestScope.receiver.id}" method="POST"  style="">
        <textarea class="form-control" rows="3" placeholder="聊聊天..." name="content"></textarea>
        <div class="text-right">
            <button type="submit" class="btn btn-primary mt-3">发送</button>
        </div>
    </form>

