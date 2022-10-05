<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="include/head.jsp" %>
        <title>login.jsp</title>
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
            <form action="Login" method="post">
                <div class="form-group">
                    <label for="id">ユーザーID(メールアドレス)</label>
                    <input type="text" class="form-control" id="id" name="id" aria-describedby="emailHelp" placeholder="ユーザーIDを入れてください">
                </div>
                <div class="form-group">
                    <label for="pass">パスワード</label>
                    <input type="password" class="form-control" id="pass" name="pass" placeholder="パスワードを入れてください">
                </div>
                <button type="submit" class="btn btn-primary" >ログイン</button>
                <a href="regist.jsp">会員登録</a>
            </form>
        </div>
        <%@ include file="include/foot.jsp" %>
    </body>
</html>

