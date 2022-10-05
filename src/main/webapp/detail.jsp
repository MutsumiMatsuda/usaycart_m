<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="include/head.jsp" %>
        <title>deteil.jsp</title>
    </head>
    <body>
        <div class="container mt-2">
            <%@ include file="include/menu.jsp" %>
            <form method="post" action="AddCart">
                <p>商品詳細</p>
                <p><img src="img/${car.carId}.png" width="300" height="200"/></p>
                <p>商品ID：${car.carId}</p>
                <p>商品名：${car.name}</p>
                <p>価格：<fmt:formatNumber value="${car.price}" type="CURRENCY" currencySymbol="&yen;"  groupingUsed="true" /></p>
                <P>～彼女と一緒にどこへ行こうか？～</P>
                <input type ="hidden" value="${car.carId}" name="id">
                <button type="submit" class="btn btn-warning" >カートに入れる</button>
            </form>
        </div>
        <%@ include file="include/foot.jsp" %>
    </body>
</html>
