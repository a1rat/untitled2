<#--<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>-->
<#--<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>-->
<#--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"-->
<#--pageEncoding="ISO-8859-1"%>-->
<#--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">-->
<#--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>-->
<#-- @ftlvariable name="user" type="java.util.List<com.springapp.domain.UserInfo>" -->
<#include "../template/mainTemplate.ftl">
<@mainTemplate title="Messages"/>
<#macro l_body>
<ul class="nav nav-pills nav-stacked">
    <li><a href="/">Моя Страница</a></li>
    <li><a href="/friends">Мои Друзья</a></li>
    <li><a href="/im">Мои Сообщения</a></li>
</ul>
</#macro>
<#macro r_body>
<form name="sentMessage" class="well" action="/im/write" method="post" id="contactForm"  novalidate>

    <div class="control-group">
        <div class="controls">
            <label>${user.name?string}</label>
				 <textarea name="text" rows="10" cols="100" class="form-control"
                           placeholder="Message" id="message" required
                           data-validation-required-message="Please enter your message" minlength="5"
                           data-validation-minlength-message="Min 5 characters"
                           maxlength="999" style="resize:none"></textarea>
        </div>
    </div>
    <div id="success"> </div> <!-- For success/fail messages -->
    <button type="submit" class="btn btn-primary">Send</button><br />
</form>
</#macro>

<#--<#import "/spring.ftl" as spring />-->
<#--<html>-->
<#--<head>-->
    <#--<title>Login Page For Security</title>-->
    <#--<style>-->
        <#--.errorblock {-->
            <#--color: #ff0000;-->
            <#--background-color: #ffEEEE;-->
            <#--border: 3px solid #ff0000;-->
            <#--padding: 8px;-->
            <#--margin: 16px;-->
        <#--}-->
    <#--</style>-->
<#--</head>-->
<#--&lt;#&ndash;<body onload='document.f.j_username.focus();'>&ndash;&gt;-->
<#--<h3>Write message</h3>-->


<#--<form  action="/im/write" method='POST'>-->
    <#--<table>-->
        <#--<tr>-->
            <#--<td>Text:</td>-->
            <#--<td><input type='text' name='text' value=''>-->
            <#--</td>-->
        <#--</tr>-->
        <#--<tr>-->
            <#--<td colspan='2'><input name="submit" type="submit"-->
                                   <#--value="Send" />-->
            <#--</td>-->
        <#--</tr>-->
    <#--</table>-->
<#--</form>-->
<#--</body>-->
<#--</html>-->