<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
        <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="static/css/search.css" rel="stylesheet" type="text/css"/>
        <style>
            table { border-collapse: collapse; border-spacing: 0px; position:relative;}

            table, th, td { padding: 5px; border: 1px solid black; }
            form {margin: 0 0 20px;}
        </style>
    </head>
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <h1>违章信息</h1>
                    <hr>
                    <div class="container">
                        <form method="POST" class="search">
                            <div class="field">
                                <input type="text" value="${enterString}" class="input-search" id="enterString" name="enterString" required>
                                <label for="input-search">搜索</label>
                            </div>
                            <button class="btn" type="submit">查找</button>
                        </form>
                    </div>
                    <c:if test="${not empty searchInfo}">
                        <table class="table table-striped">
                            <tr>
                                <th>处理编号</th>
                                <th>车主姓名</th>
                                <th>车牌号</th>
                                <th>违章日期</th>
                                <th>违章原因</th>
                                <th>处理决定</th>
                                <th>处理情况</th>
                            </tr>
                            <c:forEach items="${searchInfo}" var="info">
                                <tr>
                                    <td>${info.id}</td>
                                    <td>${info.username}</td>
                                    <td>${info.carplate}</td>
                                    <td>${info.date}</td>
                                    <td>${info.reason}</td>
                                    <td>${info.punish}</td>
                                    <td>${info.process}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:if>
                    <table id="info" class="table table-striped">
                        <tr>
                            <th>处理编号</th>
                            <th>车主姓名</th>
                            <th>车牌号</th>
                            <th>违章日期</th>
                            <th>违章原因</th>
                            <th>处理决定</th>
                            <th>处理情况</th>
                        </tr>
                    </table>
                    <div align="center">
                        <a id="first">首页</a>&nbsp;&nbsp;    
                        <a id="prev">上一页</a>&nbsp;&nbsp;
                        <a id="next">下一页</a>&nbsp;&nbsp;
                        <a id="last">末页</a>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
        <script>
           $(function() {
                loadDataModel(1);
            });
            function loadDataModel(page) {
                $.getJSON("info", { 'page': page }, function(json) {
                    var infoList = json.dataModel;
                    var prevPage = json.currentPage - 1;
                    var nextPage = json.currentPage + 1;
                    var lastPage = json.totalPage;
                    $("#pageInfo").text(json.currentPage + " / " + json.totalPage);
                    if (json.currentPage > 1) {
                        $("#first").attr("href", "javascript:loadDataModel(1)");
                        $("#prev").attr("href", "javascript:loadDataModel(" + prevPage + ")");
                    } else {
                        $("#first").removeAttr("href");
                        $("#prev").removeAttr("href");
                    }
                    if (json.currentPage < json.totalPage) {
                        $("#next").attr("href", "javascript:loadDataModel(" + nextPage + ")")
                        $("#last").attr("href", "javascript:loadDataModel(" + lastPage + ")")
                    } else {
                        $("#next").removeAttr("href");
                        $("#last").removeAttr("href");
                    }
                    $("#info tr:gt(0)").remove();
                    for (var i = 0; i < infoList.length; ++i) {
                        var info = infoList[i];
                        var tr = $("<tr>")
                            .append($("<td>").text(info.id))
                            .append($("<td>").append($("<a>")
                                    .text(info.username).attr("href", "infoDetail?no=" + info.id)))
                            .append($("<td>").text(info.carplate))
                            .append($("<td>").text(info.date))
                            .append($("<td>").text(info.reason))
                            .append($("<td>").text(info.punish))
                            .append($("<td>").text(info.process))
                            .append();
                        $("#info").append(tr);
                    }
                });
            }
        </script>
    </body>
</html>
