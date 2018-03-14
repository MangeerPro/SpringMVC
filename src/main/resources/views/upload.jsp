<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
        <title>upload file</title>

    </head>
    <body>

        <div class="upload">
            <form action="upload" enctype="multipart/form-data" method="post">
                <input type="file" name="file"/><br/>
                <input type="submit" value="upload">
            </form>
        </div>

    </body>
</html>