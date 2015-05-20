<#--@ftlvariable name="friends" type="java.util.List<com.springapp.domain.Friends>" -->
<#include "template/mainTemplate.ftl">
<@mainTemplate title="Friends"/>

<#macro l_body>
<ul class="nav nav-pills nav-stacked">
    <li><a href="/">Моя Страница</a></li>
    <li><a href="/friends">Мои Друзья</a></li>
    <li><a href="/im">Мои Сообщения</a></li>
</ul>
</#macro>

<#macro r_body>
<ul class="nav nav-pills ">
    <li><a href="/friends">Все Друзья</a></li>
    <li class="active"><a href="/friends/req">Заявки</a></li>
</ul>

<table class="table table-striped">
<thead>
<tr>
    <th></th>
    <th></th>
    <th>Действие</th>
</tr>

    <#if friends?has_content>
        <#list friends as f>
        <tr>
            <th><img src="/resources/download.jpg" style="width: 50px; height: 50px"></th>
            <th><a href="/id/${f.friend_from_user_id.id}">${f.friend_from_user_id.name}</a></th>
            <th><a href="/friends/add${f.friend_from_user_id.id}" type="submit" class="btn btn-sm right">Добавить в друзья</a></th>
        </tr>
        </#list>
    </thead>
    </table>
    </#if>

</#macro>