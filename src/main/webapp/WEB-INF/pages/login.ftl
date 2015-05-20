<#include "template/mainTemplate.ftl">
<@mainTemplate title="Login"/>
<#import "/spring.ftl" as spring />
<#--<#import "/spring.ftl" as spring />-->

<#--<body onload='document.f.j_username.focus();'>-->
<#macro l_body>
<form class="form-horizontal" role="form" action="/login" method="post">
    <div class="form-group">
        <label for="inputEmail1" class="col-lg-2 control-label">Email</label>
        <br>
        <br>

        <div class="col-lg-10">
            <input type="email" class="form-control" name="email" placeholder="Email">
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword1" class="col-lg-2 control-label">Password</label>
        <br>
        <br>

        <div class="col-lg-10">
            <input type="password" class="form-control" name="password" placeholder="Password">
        </div>
    </div>
    <div class="form-group">
        <#--<div class="col-lg-offset-2 col-lg-10">-->
            <button type="submit" class="btn btn-default">Sign in</button>
        <#--</div>-->
        <a href="/signup"  type="submit" class="btn btn-default">Sign up</a>
    </div>
</form>
</#macro>

<#macro r_body>
<#--<#include "signup.ftl">-->
<#--<@hst.html contentRewriter=contentRewriter hippohtml=document.body/>-->
<#--<#include "template/log.jpg">-->
<#--<#list 1..5 as l>-->
<#--<@img src="../log.jpg"></@img>-->
<img src="/resources/download.jpg" style="width: 50px; height: 50px">

<#--</#list>-->

</#macro>

<#--<c:if test="${not empty error}">-->
<#--<div class="errorblock">-->
<#--Your login attempt was not successful, try again.-->
<#--Caused :-->
<#--${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}-->
<#--</div>-->
<#--</c:if>-->
<#--<div class="container">-->
<#--<div class="row">-->
<#--<div class="col-xs-12">-->
<#--<h3>Login with Email and Password (Custom Login Page)</h3>-->
<#--</div>-->
<#--<div class="col-md-6">-->

<#--<form action="/login" method='POST'>-->
<#--<table>-->
<#--<tr>-->
<#--<td><#if message?has_content>-->
<#--${message}-->
<#--</#if></td>-->
<#--<td></td>-->
<#--</tr>-->
<#--<tr>-->
<#--&lt;#&ndash;<td>Email:</td>&ndash;&gt;-->
<#--<td><input class="form-group form-control" type='text' name='email' value=''>-->
<#--</td>-->
<#--</tr>-->
<#--<tr>-->
<#--&lt;#&ndash;<td>Password:</td>&ndash;&gt;-->
<#--<td><input type='password' name='password'/>-->
<#--</td>-->
<#--</tr>-->
<#--&lt;#&ndash;<tr>&ndash;&gt;-->
<#--&lt;#&ndash;<td><input type="checkbox" name="_spring_security_remember_me">Remember me</td>&ndash;&gt;-->
<#--&lt;#&ndash;</tr>&ndash;&gt;-->
<#--<tr>-->
<#--<td colspan='2'><input name="submit" type="submit"-->
<#--value="submit"/>-->
<#--</td>-->
<#--</tr>-->
<#--</table>-->
<#--</form>-->
<#--</div>-->
<#--<div class="col-md-6">-->
<#--<form class="form-horizontal">-->
<#--<div class="control-group">-->
<#--<label class="control-label" for="inputEmail">Email</label>-->
<#--<br>-->
<#--<div class="controls">-->
<#--<input type="text" id="inputEmail" placeholder="Email">-->
<#--</div>-->
<#--</div>-->
<#--<div class="control-group">-->
<#--<label class="control-label" for="inputPassword">Пароль</label>-->
<#--<br>-->
<#--<div class="controls">-->
<#--<input type="password" id="inputPassword" placeholder="Пароль">-->
<#--</div>-->
<#--</div>-->
<#--<div class="control-group">-->
<#--<div class="controls">-->
<#--<button type="submit" class="btn">Войти</button>-->
<#--</div>-->
<#--</div>-->
<#--</form>-->
<#--</div>-->
<#--</div>-->
<#--</div>-->