<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="include/head.jsp" %>
        <title>member_only.jsp</title>
    </head>
    <body>
        <div class="container mt-2">

            <c:if test="${customer == null}" >
                <c:redirect url="login.jsp" />
            </c:if>
            <%@ include file="include/menu.jsp" %>

            <p>${customer.name}様、今日はどのようなご用件でしょうか？</p>
        </div>
        <%@ include file="include/foot.jsp" %>
    </body>
</html>







