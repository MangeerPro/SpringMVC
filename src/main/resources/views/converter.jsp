<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8"/>
        <title>HttpMessageConverter Demo</title>
    </head>
    <body>
        <div id="resp"></div>
    <input type="button" onclick="req()" value="请求"/>
    <script src="/assets/js/jquery.js" typt="text/javascript"></script>
    <script>
        function req() {
            $.ajax({
                url:"convert",
                data:"1-chenhao", //后台处理按此格式处理
                type:"POST",
                contentType:"application/x-wisely", //设置的媒体类型为自定义媒体类型
                success:function(data) {
                    $("#resp").html(data)
                }
            })
        }
    </script>
    </body>
</html>