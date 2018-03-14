<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>SSE Demo</title>
    </head>
    <body>
    <script type="text/javascript" src="<c:url value="/assets/js/jquery.js" />"></script>
    <script type="text/javascript">
        if(!! window.EventSorurce) {  //EventSource对象新式浏览器支持
            var source = new EventSource('push');
            s='';
            source.addEventListener('message', function(e) {    //添加客户端SSE消息
                s += e.data + "<br/>";
                $("#msgFromPush").html(s);
            });

            source.addEventListener('open', function (e) {
                console.log("连接打开.");
            }, false);
            source.addEventListener('error', function (e) {
                if (e.readyState == EventSource.CLOSED) {
                    console.log("连接关闭")
                } else {
                    console.log(e.readyState);
                }
            }, false)
        } else {
            console.log("您的浏览器不支持SSE");
        }
    </script>
    </body>
</html>