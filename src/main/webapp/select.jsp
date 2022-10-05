<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="include/head.jsp" %>
        <title>select.jsp</title>
    </head>
    <body>
        <div class="container mt-2">
            <c:if test="${customer == null}" >
                <c:redirect url="login.jsp" />
            </c:if>
            <%@ include file="include/menu.jsp" %>
            <p>商品名のキーワードから商品を絞り込み検索できます。</p>
            <form action="Search">
                <div class="form-group">
                    <label for="name">商品名:</label>
                    <input type="text" id="name" name="name" class="form-control" style="width:200px;">
                </div>

                <button type="submit" class="btn btn-primary">検索</button>
            </form>

            <c:if test="${!(empty cars)}" >
                <div class="alert alert-secondary float-right" role="alert">
                    ${cars.getCarsSize()}点の商品があります。
                </div>
                <table class="table table-striped mt-4">
                    <tr><th>商品名</th><th><div class="text-right">価格</div></th><th></th></tr>
                            <c:forEach var = "c" items="${cars.carArrayList}">
                        <tr><td>${c.name}</td><td><div class="text-right"><fmt:formatNumber value="${c.price}" type="CURRENCY" currencySymbol="&yen;" maxFractionDigits="0" groupingUsed="true" /></div></td><td><a href="ShowDetails?name=${c.name}">詳細</a></td></tr>
                            </c:forEach>
                </table>
            </c:if>
        </div>
        <%@ include file="include/foot.jsp" %>
    </body>
</html>
