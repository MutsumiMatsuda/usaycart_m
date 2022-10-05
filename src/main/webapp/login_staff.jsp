<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="include/head.jsp" %>
        <title>login_staff.jsp</title>
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
            <form action="LoginStaff" method="post">
                <div class="form-group">
                    <label for="id">スタッフID(imai)</label>
                    <input type="text" class="form-control" id="id" name="id" aria-describedby="emailHelp" placeholder="IDを入れてください">
                </div>
                <div class="form-group">
                    <label for="pass">パスワード(p)</label>
                    <input type="password" class="form-control" id="pass" name="pass" placeholder="パスワードを入れてください">
                </div>
                <button type="submit" class="btn btn-primary" >ログイン</button>
            </form>
        </div>
        <%@ include file="include/foot.jsp" %>
    </body>
</html>

