<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ja">
    <head>
        <%@ include file="include/head.jsp" %>
        <title>customer_info.jsp</title>
    </head>
    <body>
        <div class="container mt-2">
            <%@ include file="include/menu.jsp" %>
            <form action="UpdateCustomer" method="post" class="needs-validation" novalidate>
                <h1>会員情報の変更</h1>
                <div class="form-row m-4">
                    <div class="col-md-6">
                        <label for="name">お名前</label>
                        <input type="text" class="form-control" id="name" name="name" placeholder="例)今井克哉" required value="${customer.name}">
                        <div class="invalid-feedback">
                            入力してください
                        </div>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="mail">メールアドレス</label>
                        <input type="text" class="form-control" id="mail" name="mail" placeholder="例)imai@saycon.co.jp" required value="${customer.mail}">
                        <div class="invalid-feedback">
                            入力してください
                        </div>
                    </div>
                </div>
                <div class="form-row m-4">
                    <div class="col-md-3 mb-5">
                        <label for="postalCode">郵便番号</label>
                        <input type="text" class="form-control" id="postalCode" name="postalCode" placeholder="例)460-0001" maxlength="8" onKeyUp="AjaxZip3.zip2addr(this, '', 'pref01', 'addr01');" required value="${customer.postalCode}">
                        <div class="invalid-feedback">入力してください</div>
                    </div>
                    <div class="col-md-3">
                        <label for="pref">都道府県</label>
                        <input type="text"class="form-control" id="pref"  name="pref" placeholder="例)愛知県" required value="${customer.pref}">
                        <div class="invalid-feedback">入力してください</div>
                    </div>
                    <div class="col-md-6">
                        <label for="address">住所</label>
                        <input type="text"class="form-control" id="address"  name="address"  placeholder="例)名古屋市中区丸の内" required value="${customer.address}">
                        <div class="invalid-feedback">入力してください</div>
                    </div>
                </div>
                <div class="form-row  m-4">
                    <div class="col-md-3 mb-5">
                        <label for="birthday">誕生日</label>
                        <input type="text"class="form-control" id="birthday"  name="birhday" placeholder="例)1969-11-09"  maxlength="10" required value="${customer.birthday}">
                        <div class="invalid-feedback">入力してください</div>
                    </div>
                    <div class="col-md-3">
                        <label for="mobile">携帯番号</label>
                        <input type="text"class="form-control"  id="mobile"  name="mobile" placeholder="例)090-0000-0000" required value="${customer.mobile}">
                        <div class="invalid-feedback">入力してください</div>
                    </div>
                    <div class="col-md-6">
                        <label for="pass">ご希望のパスワード</label>
                        <input type="password" class="form-control" id="pass" name="pass" required value="${customer.pass}">
                        <div class="invalid-feedback">入力してください</div>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-12">
                        <button type="submit" class="btn btn-warning btn-block">修正する</button>
                    </div>
                </div>
            </form>

        </div><!-- /container -->
        <%@ include file="include/foot.jsp" %>
    </body>
</html>