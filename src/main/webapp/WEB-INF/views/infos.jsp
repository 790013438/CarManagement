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
                    <td>${course.reason}</td>
                    <td>${course.punish}</td>
                    <td>${info.process}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
