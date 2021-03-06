<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<#escape __x as __x?html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>フォーム</title>
<#--<#include "../common/head-css.ftl" />-->
</head>
<body>
<div class="container">
<form class="form-horizontal" method="POST" action="/signup">
<legend>JSR-303 Bean Validation</legend>
<!-- name -->
<div class="control-group">
<label class="control-label" for="name">Name</label>
<div class="controls">
<@spring.formInput 'signUp.name' 'id="name" placeholder="Name"' />
<#if spring.status.error>
<p><@spring.showErrors "<br>", "color:red" /></p>
</#if>
</div>
</div>
<!-- email -->
<div class="control-group">
<label class="control-label" for="email">Email</label>
<div class="controls">
<@spring.formInput 'signUp.email' 'id="email" placeholder="Email"' />
<#if spring.status.error>
<p><@spring.showErrors "<br>", "color:red" /></p>
</#if>
</div>
</div>
<div class="control-group">
<div class="controls">
<button type="submit" name="send" class="btn">送信</button>
</div>
</div>
</form>

</div><!-- /div.container -->
</body>
</html>
</#escape>