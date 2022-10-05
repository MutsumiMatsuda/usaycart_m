<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ja">
    <head>
        <%@ include file="include/head.jsp" %>
        <title>Confirm.jsp</title>
    </head>
    <body>

        <div class="container mt-2">
            <form action="AddCustomer" method="post" class="needs-validation" novalidate>
                <h1>登録情報確認画面</h1>
                <div class="form-row mb-4">
                    <div class="col-md-6">
                        <label for="name">お名前</label>
                        <!--<input type="text" class="form-control" id="name" name="name" placeholder="お名前" required value="${customer.name}" readonly >-->
                        <input type="text" class="form-control" id="name" name="name" placeholder="お名前" required value="<c:out value="${customer.name}" />" readonly >
                        <div class="invalid-feedback">
                            入力してください
                        </div>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label for="mail">メールアドレス</label>
                        <input type="text" class="form-control" id="mail" name="mail" placeholder="メールアドレス" required value="${customer.mail}" readonly >
                        <div class="invalid-feedback">
                            入力してください
                        </div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="col-md-3 mb-5">
                        <label for="postalCode">郵便番号(7桁)</label>
                        <input type="text" class="form-control" id="postalCode" name="postalCode" placeholder="4600001" maxlength="8" onKeyUp="AjaxZip3.zip2addr(this, '', 'pref01', 'addr01');" required value="${customer.postalCode}"  readonly >
                        <div class="invalid-feedback">入力してください</div>
                    </div>
                    <div class="col-md-3">
                        <label for="pref">都道府県</label>
                        <input type="text"class="form-control" id="pref"  name="pref" placeholder="愛知県" required value="${customer.pref}"  readonly >
                        <div class="invalid-feedback">入力してください</div>
                    </div>
                    <div class="col-md-6">
                        <label for="address">住所</label>
                        <input type="text"class="form-control" id="address"  name="address"  placeholder="名古屋市中区丸の内" required value="${customer.address}"  readonly >
                        <div class="invalid-feedback">入力してください</div>
                    </div>
                </div>
                <div class="form-row">
                    <div class="col-md-3 mb-5">
                        <label for="birthday">誕生日</label>
                        <input type="text"class="form-control" id="birthday"  name="birhday" placeholder="1969119"  maxlength="8" required value="${customer.birthday}"  readonly >
                        <div class="invalid-feedback">入力してください</div>
                    </div>
                    <div class="col-md-3">
                        <label for="mobile">携帯番号</label>
                        <input type="text"class="form-control"  id="mobile"  name="mobile" placeholder="09000000000" required value="${customer.mobile}"  readonly >
                        <div class="invalid-feedback">入力してください</div>
                    </div>
                    <div class="col-md-6">
                        <label for="pass">ご希望のパスワード</label>
                        <input type="password" class="form-control" id="pass" name="pass" required value="${customer.pass}"  readonly >
                        <div class="invalid-feedback">入力してください</div>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-6">
                        <button type="submit" class="btn btn-warning btn-block">上記内容で登録する</button>
                    </div>
                    <div class="col-sm-6">
                        <a href="#" onclick="window.history.back(); return false;">直前のページに戻る</a>
                    </div>
                </div>
            </form>

        </div><!-- /container -->
        <%@ include file="include/foot.jsp" %>
    </body>
</html>