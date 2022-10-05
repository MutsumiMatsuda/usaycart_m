<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <%@ include file="include/head.jsp" %>
        <title>update_success.jsp</title>
    </head>
    <body>
        <div class="container mt-2">
            <c:if test="${customer == null}" >
                <c:redirect url="login.jsp" />
            </c:if>
            <%@ include file="include/menu.jsp" %>
            <h2>お客様情報を変更しました。</h2>
        </div>
        <%@ include file="include/foot.jsp" %>
    </body>
</html>