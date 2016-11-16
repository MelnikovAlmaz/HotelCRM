<header>
    <section class="login-header">
        <#if user??>
            <p style="padding-top: 5px">Good time of day: ${user.name} </p>

            <div class="btn-group" style="padding-left: 10px">
                <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown">Profile <span class="caret"></span></button>
                <ul class="dropdown-menu" role="menu">
                    <li><a href="#" data-toggle="modal" data-target="#account">My account</a></li>
                    <li><a href="/myorders" >My orders</a></li>
                    <li class="divider"></li>
                    <li><a href="/guest/logout" >Log out</a></li>
                </ul>
            </div>

        <#else>
            <button type="button" class="btn btn-success" data-toggle="modal" data-target="#logging">Log in</button>
            <p class="or"> or </p>
            <button type="button" class="btn btn-success" data-toggle="modal" data-target="#registry">Register</button>
        </#if>
    </section>

    <#include "loggingButtons.ftl">
</header>

