<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
        <style>
            table { border-collapse: collapse; border-spacing: 0px; }

            table, th, td { padding: 5px; border: 1px solid black; }
        </style>
    </head>
    <body>
        <h2>违章信息</h2>
        <table>
            <tr>
                <th>原因</th>
                <th>日期</th>
                <th>处罚决定</th>
                <th colspan="2">处理情况</th>
            </tr>
            <c:forEach items="${infos}" var="info">
                <tr>
                    <td>${info.reason}</td>
                    <td>${info.punish}</td>
                    <td>${info.process}</td>
                </tr>
            </c:forEach>
        </table>
        <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
        <script>
           $(function() {
                loadDataModel(1);
            });
            function loadDataModel(page) {
                $.getJSON("emp", { 'page': page }, function(json) {
                    var empList = json.dataModel;
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
                    $("#empInfo tr:gt(0)").remove();
                    for (var i = 0; i < empList.length; ++i) {
                        var emp = empList[i];
                        var tr = $("<tr>")
                            .append($("<td>").text(emp.no))
                            .append($("<td>").append($("<a>")
                                    .text(emp.name).attr("href", "empDetail?no=" + emp.no)))
                            .append($("<td>").text(emp.sex))
                            .append($("<td>").text(emp.job))
                            .append($("<td>").text(emp.status))
                            .append($("<td>").text(emp.tel))
                            .append($("<td>")
                                    .append($("<a>").text("编辑").attr("href", "editEmp?no=" + emp.no))
                                    .append("&nbsp;&nbsp;")
                                    .append($("<a>").text("删除").attr("href", "delEmp?no=" + emp.no))
                            );
                        $("#empInfo").append(tr);
                    }
                });
            }
        </script>
    </body>
</html>
