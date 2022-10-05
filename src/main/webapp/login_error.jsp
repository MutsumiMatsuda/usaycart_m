<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="include/head.jsp" %>
        <title>login_error.jsp</title>
        <style>
            #center {
                height: 200px;
                width: 500px;
                position: absolute;
                left: 50%;
                top: 50%;
                margin-top: -100px;
                margin-left: -250px;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div class="container mt-2">
            <center>
                <div id="center">
                    <h2>エラーが発生しました。</h2>
                    <h3>もう一度ログインしてください。</h3>
                    <h4 style="text-align:center"><a href="login.jsp">ログイン画面へ戻る</a></h4>
                </div>
            </center>
        </div>
        <%@ include file="include/foot.jsp" %>
    </body>
</html>
