<header>
    <section class="login-header">
        <#if user??>
            <button type="button" class="btn btn-success">${user.name}</button>
            <p class="or"> or </p>
            <button type="button" class="btn btn-success">Profile</button>
            <#else>
        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#logging">Log in</button>
        <p class="or"> or </p>
        <button type="button" class="btn btn-success" data-toggle="modal" data-target="#registry">Register</button>
        </#if>
    </section>
<#include "loggingButtons.ftl">
</header>

