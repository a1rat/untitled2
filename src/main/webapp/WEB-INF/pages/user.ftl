<#--@ftlvariable name="user" type="java.util.List<com.springapp.domain.UserInfo>" -->
<#--@ftlvariable name="post" type="java.util.List<com.springapp.domain.Posts>" -->
<#include "template/mainTemplate.ftl">
<@mainTemplate title="User"/>
<#macro l_body>
<ul class="nav nav-pills nav-stacked">
    <li><a href="/">Моя Страница</a></li>
    <li><a href="/friends">Мои Друзья</a></li>
    <li><a href="/im">Мои Сообщения</a></li>
    <li><a href="/logout">Выход</a></li>
</ul>
</#macro>
<#macro r_body>
<br>
<div class="container" style="width: 550px">
<div class="container" style="width: 550px;>
<div class="row">
<div class="col-sm-3">
<img src="/resources/download.jpg" style="width: 120px; height: 120px">
</div>
    <div class="col-sm-9">
                Name: ${user.name?html}<br>
                Surname: ${user.surname}<br>
            </div>
</div>
<br>
<br>
<div class="container" style="width: 550px">
<div class="row">
    <form name="sentMessage" class="well" action="/post/write"  method="post" id="contactForm"  novalidate>
    <div class="control-group">
        <div class="controls">
				 <textarea name="text" rows="3" cols="30" wrap="hard" class="form-control"
                           placeholder="Message" id="message" required
                           data-validation-required-message="Please enter your message" minlength="5"
                           data-validation-minlength-message="Min 5 characters"
                           maxlength="999" style="resize:none"></textarea>
        </div>
    </div>
    <div id="success"> </div> <!-- For success/fail messages -->
    <button type="submit" class="btn btn-primary">Send</button><br />
</form>
<div class="panel panel-default">
<header class="panel-heading">Posts</header>
<div class="panel-body">

<#if post?has_content>
<#list post as p>
<img src="/resources/download.jpg" style="width: 50px; height: 50px">
Data:${p.date?string}   <br> Text: ${p.text}
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