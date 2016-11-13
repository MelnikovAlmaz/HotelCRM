<html>
<head>
<#include "../../head.ftl">
</head>
<body>
<#include "../../navBar.ftl">
<div class="container">
    <div class="row">
    <#include "../leftBar.ftl">
        <main class="col-lg-7">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <span>Department</span>
                </div>
                <div class="panel-body">
                    <form method="post" action="/admin/entity/${hotel.id}/employee/${employee.id}">
                        <label for="name">Name</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <input type="text" class="form-control" name="name" placeholder="Name"
                                   value=${employee.name}>
                        </div>
                        <div class="control-group ">
                            <label class="control-label" for="">Manager</label>
                            <div class="input-group input-margin">
                                <select class="form-control" size="1" name="category">
                                <#list employees as employee>
                                    <option
                                        <#if employee.manager.id == employee.id>selected</#if>
                                        value="${employee.id}">${employee.name} - ${employee.role.name}</option>
                                </#list>
                                </select>
                            </div>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <input type="submit" class="btn btn-success" value="Save">
                    </form>
                </div>
            </div>
        </main>
    </div>
</div>
</body>
</html>