<#--@ftlvariable name="user" type="java.util.List<com.springapp.domain.UserInfo>" -->
<#--@ftlvariable name="post" type="java.util.List<com.springapp.domain.Posts>" -->
<#include "template/mainTemplate.ftl">
<@mainTemplate title="User"/>

<#macro l_body>
<ul class="nav nav-pills nav-stacked">
    <li><a href="/">Моя Страница</a></li>
    <li><a href="/friends">Мои Друзья</a></li>
    <li><a href="/im">Мои Сообщения</a></li>
</ul>
</#macro>
<#macro r_body>
<br>
<div class="container" style="width: 550px">
    <div class="container" style="width: 550px">
        <div class="row">
            <div class="col-sm-3">
                <img src="/resources/download.jpg" style="width: 120px; height: 120px">
            </div>
            <div class="col-sm-9">
                Name: ${user.name?html}<br>
                Surname: ${user.surname}<br>
            </div>
        </div>
    </div>
    <br>
    <br>
    <ul class="nav nav-pills ">
        <li><a href="/friends/add2${user.id}">Добавить в друзья</a></li>
    </ul>
    <div class="container" style="width: 550px">
        <div class="row">
            <div class="panel panel-default">
                <header class="panel-heading">Posts</header>
                <div class="panel-body">
                    <#if post?has_content>
                        <#list post as p>
                            <img src="/resources/download.jpg" style="width: 50px; height: 50px">
                            Data: ${p.date?string}  Text: ${p.text}
                            __________________________________________________________________<br>
                        </#list>
                    </#if>
                </div>
            </div>
        </div>
    </div>
</div>

</#macro>




<#--<#include "footer.ftl">-->