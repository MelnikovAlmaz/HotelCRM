<html>
<head>
<#include "head.ftl">
</head>
<body class="body-image">

<#include "main-header.ftl">


<div id="envelope_l" class="envelope_l">
    <a class="close-btn" title="Закрыть" href="javascript:void(0)" onclick = "document.getElementById('envelope_l').style.display='none';document.getElementById('fade').style.display='none'; document.getElementById('ins').style.display='block'"></a>
    <form method="post" action="обработчик">
        <input class="tel-place" type="text" name="sender_name" onclick="this.value='';" onfocus="this.select()" onblur="this.value=!this.value?'* Your telephone number':this.value;" value="* Your telephone number" />
        <input class="password-place" type="text" name="sender_email" onclick="this.value='';" onfocus="this.select()" onblur="this.value=!this.value?'* Your password':this.value;" value="* Your password"/>
        <input type="submit" name="send" value="Отправить" class="send-message">
    </form>
</div>


<div id="envelope" class="envelope">
    <a class="close-btn" title="Закрыть" href="javascript:void(0)" onclick = "document.getElementById('envelope').style.display='none';document.getElementById('fade').style.display='none'; document.getElementById('ins').style.display='block'"></a>
    <form method="post" action="обработчик">
        <input class="name-place" type="text" name="sender_name" onclick="this.value='';" onfocus="this.select()" onblur="this.value=!this.value?'* Your name':this.value;" value="* Your name" />
        <input class="tel-place" type="text" name="sender_name" onclick="this.value='';" onfocus="this.select()" onblur="this.value=!this.value?'* Your telephone number':this.value;" value="* Your telephone number" />
        <input class="password-place" type="text" name="sender_email" onclick="this.value='';" onfocus="this.select()" onblur="this.value=!this.value?'* Your password':this.value;" value="* Your password"/>
        <input class="pass-confirm-place" type="text" name="sender_email" onclick="this.value='';" onfocus="this.select()" onblur="this.value=!this.value?'* Confirm password':this.value;" value="* Confirm password" />
        <input type="submit" name="send" value="Отправить" class="send-message">
    </form>
</div>

<div class="main-insides" id="ins">
<div class="header-form-area col-lg-offset-2 col-lg-8">
    <h1>Hotel world</h1>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
        <#include "search-navbar-form.ftl">
        </div>
    </nav>
</div>




</div>
<div id="fade" class="black-overlay"></div>

</body>
</html>
