<%--
  Created by IntelliJ IDEA.
  User: eden
  Date: 2019/12/9
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%! int day = 3; %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Hello world</h1>
    <a href="hello">Hello</a>
    <%
        out.println("Your IP address is " + request.getRemoteAddr());
    %>

    <%
        switch(day) {
            case 0:
                out.println("星期天");
                break;
            case 1:
                out.println("星期一");
                break;
            case 2:
                out.println("星期二");
                break;
            case 3:
                out.println("星期三");
                break;
            case 4:
                out.println("星期四");
                break;
            case 5:
                out.println("星期五");
                break;
            default:
                out.println("星期六");
        }
    %>
    <p>
        今天的日期是: <%= (new java.util.Date()).toLocaleString()%>
    </p>

    <%@ include file="WEB-INF/test.jsp" %>
</body>
</html>
