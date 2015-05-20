<#-- @ftlvariable name="message" type="java.util.List<com.springapp.domain.Message>" -->
<#include "template/mainTemplate.ftl">
<@mainTemplate title="Messages"/>
<#macro l_body>
<ul class="nav nav-pills nav-stacked">
    <li><a href="/">Моя Страница</a></li>
    <li><a href="/friends">Мои Друзья</a></li>
    <li><a href="/im">Мои Сообщения</a></li>
</ul>
</#macro>
<#macro r_body>
<ul class="nav nav-pills">
    <li><a href="/im/pol">Полученные</a></li>
    <li class="active"><a href="/im/otp">Отправленные</a></li>
</ul>

<table class="table table-striped">
<thead>
<tr>
    <th></th>
    <th>Получатель</th>
    <th>Текс</th>
    <th>Действие</th>
</tr>
    <#if message?has_content>
        <#list message as m>
        <tr>
            <th></th>
            <th>${m.to_user_id.name}
            <br>${m.date?string}</th>
            <th>${m.text?html} </th>
            <th><a href="/im/write${m.to_user_id.id}" type="submit" class="btn btn-sm">Ещё одно</a></th>
        </tr>
        </#list>
    </thead>
    </table>
</#if>
</#macro>