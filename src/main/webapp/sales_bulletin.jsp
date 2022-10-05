<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="include/head.jsp" %>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"> 

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" 
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <title>sales_bulletin.jsp</title>
    </head>
    <body>
        <h1>売上速報</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>販売日時</th>
                    <th>商品名</th>
                    <th>顧客住所</th>
                    <th>顧客お名前</th>
                    <th>価格</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="s" items="${saleses.saleArrayList}">
                    <tr>
                        <td>${s.saleDateTime}</td>
                        <td>${s.car.name}</td>
                        <td>${s.customer.pref}${s.customer.address}</td>
                        <td>${s.customer.name}様</td>
                        <td><fmt:formatNumber value="${s.car.price}" type="CURRENCY" currencySymbol="&yen;" maxFractionDigits="0" groupingUsed="true" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <%@ include file="include/foot.jsp" %>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js">
        </script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js">
        </script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" >
        </script>
    </body>
</html>
