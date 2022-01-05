<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<rapid:override name="content">
    <div class="row" style="margin-top: 5vh">
        <aside class="col-md-4">
            <section>
                <form action="/user/changeAvatar" method="post" enctype="multipart/form-data">
                    <div class="input-group">
                        <div class="form-group">

                            <input type="text" style="border:0px;" class="form-control" placeholder="请选择文件" />
                            <span class="input-group-btn">
                                        <label for="forexIO_file" class="form-control btn btn-info" >选择文件</label>
                                            <input id="forexIO_file" type="file" name="file" onchange="set_placeholder(this)" style="display: none" />
                                    </span>
                        </div>
                    </div>
                    <div class="text">
                        <button type="submit" class="btn btn-primary mt-3 ">上传</button>
                    </div>
                </form>
            </section>
        </aside>
    </div>


</rapid:override>
<%@include file="../layouts/default.jsp"%>
