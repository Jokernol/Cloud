<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<rapid:override name="content">
    <div class="row" style="margin-top: 5vh">
        <aside class="col-md-4">
            <section>
                <form action="/pictures/upload" method="post" enctype="multipart/form-data">
                        <div class="input-group">
                            <div class="form-group">

                                <input type="text" style="border:0px;" class="form-control" placeholder="请选择文件" />
                                <span class="input-group-btn">
                                        <label for="forexIO_file" class="form-control btn btn-info" >选择文件</label>
                                            <input id="forexIO_file" type="file" name="file" onchange="set_placeholder(this)" style="display: none" />
                                    </span>
                            </div>
                            <!-- /input-group -->
                        <div class="form-group">
                            <label>文件描述：</label>
                            <input type="text" name="intro" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>文件标签：</label>
                            <input type="text" name="tags" class="form-control">
                        </div>

                    </div>
                    <div class="text">
                        <button type="submit" class="btn btn-primary mt-3 ">上传</button>
                    </div>
                </form>
            </section>
        </aside>
        <div class="col-md-8">
            <section>
                <h2>相册列表</h2>
            </section>
            <c:forEach items="${requestScope.pictureList}" var="picture">
                <%@ include file="../picture/pictureList.jsp"%>
            </c:forEach>
        </div>
    </div>


</rapid:override>
<%@include file="../layouts/default.jsp"%>
