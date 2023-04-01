<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="include/head.jsp" %>
        <title>ページの有効期限切れ</title>
        <style>
            #center {
                height: 200px;
                width: 300px;
                position: absolute;
                left: 50%;
                top: 50%;
                margin-top: -100px;
                margin-left: -150px;
                text-align: center;
            }
        </style>
        <!--Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    </head>
    <body>
        <div id="center">
            <p>セッションの有効期限が切れました。</br>再度ログインをしてください。</p>
        </div>
        <%@ include file="include/foot.jsp" %>
    </body>
</html>

