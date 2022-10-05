<%@ page pageEncoding="UTF-8" %>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd;">
    <a class="navbar-brand" href="#"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/Search?name=">商品検索 </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/cart.jsp">買い物かご</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/CustomerInfo">${customer.name}さんの会員情報</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/Logout">ログアウトしますか？</a>
            </li>
        </ul>
    </div>
</nav>
<hr>

<%
//以下、ブラウザバック対策
    response.setHeader("Cache-Control", "no-cache,no-store, must-revalidate");//HTTP1.1をサポートしているブラウザ向けの記述
    response.setHeader("Pragma", "no-cache");//HTTP1.0をサポートしているブラウザ向けの記述
    response.setHeader("Expires", "0");//プロキシサーバー対策として、過去の日時を入力して強制的にキャッシュを無効化する
%>

