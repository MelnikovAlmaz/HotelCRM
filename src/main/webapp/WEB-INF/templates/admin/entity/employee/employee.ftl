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
                        <label for="phoneNumber">Phone Number</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <input type="text" class="form-control" name="phoneNumber" placeholder="Phone Number"
                                   value=${employee.phoneNumber}>
                        </div>
                        <label for="address">Password</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <input type="password" class="form-control" name="password" placeholder="Password"
                                   value=${employee.password}>
                        </div>
                        <label class="control-label" for="role">Role</label>
                        <div class="input-group input-margin">
                            <select class="form-control" size="1" name="role">
                            <#list roles as role>
                                <option <#if employee.role.id == role.id>selected</#if>
                                        value="${role.id}">${role.name}</option>
                            </#list>
                            </select>
                        </div>
                        <label for="salary">Salary</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <input type="number" step="0.1" min="1" class="form-control" name="salary"
                                   placeholder="Salary" value=${employee.salary}>
                        </div>
                        <label class="control-label" for="salaryType">Salary Type</label>
                        <div class="input-group input-margin">
                            <select class="form-control" size="1" name="salaryType">
                                <option <#if employee.salaryType == "Day">selected</#if> value="Day">Day</option>
                                <option <#if employee.salaryType == "Month">selected</#if> value="Month">Month</option>
                            </select>
                        </div>
                        <div class="control-group ">
                            <label class="control-label" for="department">Department</label>
                            <div class="input-group input-margin">
                                <select class="form-control" size="1" name="departmentId">
                                <#list departments as department>
                                    <option <#if employeeDepartment.id == department.id>selected</#if> value="${department.id}">${department.name}</option>
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