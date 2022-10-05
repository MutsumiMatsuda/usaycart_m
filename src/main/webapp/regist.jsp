<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ja">
    <head>
        <%@ include file="include/head.jsp" %>
        <script src="https://yubinbango.github.io/yubinbango/yubinbango.js" charset="UTF-8"></script>
        <title>regist.jsp</title>
    </head>
    <body>
        <div class="container">

        <div class="container mt-2">
                <c:if test="${!(empty errorMessage)}" >
                    <c:forEach var = "m" items="${errorMessage}">
                        <div class="alert alert-danger" role="alert">
                            ${m}
                        </div>
                    </c:forEach>
                </c:if>
                <form action="Register" method="post" class="needs-validation" novalidate>
                    <h1>会員登録フォーム</h1>
                    <div class="h-adr">
                        <span class="p-country-name" style="display:none;">Japan</span>
                        <div class="form-row m-4">
                            <div class="col-md-6">
                                <label for="name">お名前（例：今井克哉）</label>
                                <input type="text" class="form-control" id="name" name="name" required value="${customer.name}">
                                <div class="invalid-feedback">
                                    入力してください
                                </div>
                            </div>
                            <div class="col-md-6 mb-3">
                                <label for="mail">メールアドレス（ログインIDになります）</label>
                                <input type="text" class="form-control" id="mail" name="mail" required value="${customer.mail}">
                                <div class="invalid-feedback">
                                    入力してください
                                </div>
                            </div>
                        </div>
                        <div class="form-row m-4">
                            <div class="col-md-3 mb-5">
                                <label for="postalCode">郵便番号（例：460-0001）</label>
                                <input type="text" class="form-control p-postal-code" id="postalCode" name="postalCode"  maxlength="8" onKeyUp="AjaxZip3.zip2addr(this, '', 'pref01', 'addr01');" required value="${customer.postalCode}">
                                <div class="invalid-feedback">入力してください</div>
                            </div>
                            <div class="col-md-3">
                                <label for="pref">都道府県（例：愛知県）</label>
                                <input type="text"class="form-control p-region" id="pref"  name="pref"  required value="${customer.pref}">
                                <div class="invalid-feedback">入力してください</div>
                            </div>
                            <div class="col-md-6">
                                <label for="address">住所（例：名古屋市中区丸の内）</label>
                                <input type="text"class="form-control p-locality p-street-address p-extended-address" id="address"  name="address"  required value="${customer.address}">
                                <div class="invalid-feedback">入力してください</div>
                            </div>
                        </div>
                        <div class="form-row m-4">
                            <div class="col-md-3 mb-5">
                                <label for="birthday">誕生日（例：1969-11-09）</label>
                                <input type="text"class="form-control" id="birthday"  name="birhday"  maxlength="10" required value="${customer.birthday}">
                                <div class="invalid-feedback">入力してください</div>
                            </div>
                            <div class="col-md-3">
                                <label for="mobile">携帯番号(例：09012345678)</label>
                                <input type="text"class="form-control"  id="mobile"  name="mobile" maxlength="11" required value="${customer.mobile}">
                                <div class="invalid-feedback">入力してください</div>
                            </div>
                            <div class="col-md-6">
                                <label for="pass">ご希望のパスワード</label>
                                <input type="password" class="form-control" id="pass" name="pass" required value="${customer.pass}">
                                <div class="invalid-feedback">入力してください</div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-12">
                            <button type="submit" class="btn btn-warning btn-block">入力確認画面へ</button>
                        </div>
                    </div>
                </form>
            </div>

        </div><!-- /container -->
        <%@ include file="include/foot.jsp" %>
    </body>
</html>