<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
        <title>Servlet async support</title>
    </head>
<body>
<script type="text/javascript" src="/assets/js/jquery.js"></script>
<script type="text/javascript">

    deferred(); //页面打开就向后台发送请求

    function deferred() {
        $.get('defer', function (data) {
            console.log(data); //在控制台输出服务端推送的数据
            deferred(); //一次请求完成后再向后台发送请求
        })
    }
</script>
</body>
</html>