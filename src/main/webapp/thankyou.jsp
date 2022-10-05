<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <%@ include file="include/head.jsp" %>
        <title>thankyou.jsp</title>
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
            <div id="center">
                <h2>ご登録ありがとうございます。</h2>
                <h3><a href="login.jsp">ログイン画面へ</a></h3>
            </div>
        </div>
        <%@ include file="include/foot.jsp" %>
    </body>
</html>