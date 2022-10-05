<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <%@ include file="include/head.jsp" %>
        <title>Cart.jsp</title>
    </head>
    <body>
        <div class="container mt-2">
            <c:if test="${customer == null}" >
                <c:redirect url="login.jsp" />
            </c:if>
            <%@ include file="include/menu.jsp" %>
            <c:if test="${empty cart}" >
                買い物かごには商品が入っていません。
            </c:if>
            <c:if test="${!(empty message)}" >
                <div class="alert alert-success" role="alert">
                    ${message}
                </div>
            </c:if>
            <c:if test="${!(empty cart)}" >
                <div class="alert alert-secondary float-right" role="alert">
                    合計金額：<fmt:formatNumber value="${cart.total}" type="CURRENCY" currencySymbol="&yen;" maxFractionDigits="0" groupingUsed="true" />
                </div>
                <table class="table table-striped mt-4">
                    <tr><th>商品名</th><th><div class="text-right">価格</div></th></tr>
                            <c:forEach var = "c" items="${cart.list}">
                        <tr><th>${c.name}</th><td><div class="text-right"><fmt:formatNumber value="${c.price}" type="CURRENCY" currencySymbol="&yen;" maxFractionDigits="0" groupingUsed="true" /></div></td></tr>
                            </c:forEach>
                </table>
            </c:if>
        </div>
        <%@ include file="include/foot.jsp" %>
    </body>
</html>