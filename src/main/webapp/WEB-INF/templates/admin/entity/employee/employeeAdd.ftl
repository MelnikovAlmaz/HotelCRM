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
                    <span>New Employee</span>
                </div>
                <div class="panel-body">
                    <form method="post" action="/admin/entity/${hotel.id}/employee/new">
                        <label for="name">Name</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <input type="text" class="form-control" name="name" placeholder="Name">
                        </div>
                        <label for="phoneNumber">Phone Number</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <input type="text" class="form-control" name="phoneNumber" placeholder="Phone Number">
                        </div>
                        <label for="address">Password</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <input type="password" class="form-control" name="password" placeholder="Password">
                        </div>
                        <label class="control-label" for="role">Role</label>
                        <div class="input-group input-margin">
                            <select class="form-control" size="1" name="role">
                            <#list roles as role>
                                <option value="${role.id}">${role.name}</option>
                            </#list>
                            </select>
                        </div>
                        <label for="salary">Salary</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <input type="number" step="0.1" min="1" class="form-control" name="salary"
                                   placeholder="Salary">
                        </div>
                        <label class="control-label" for="salaryType">Salary Type</label>
                        <div class="input-group input-margin">
                            <select class="form-control" size="1" name="salaryType">
                                <option value="Day">Day</option>
                                <option selected value="Month">Month</option>
                            </select>
                        </div>
                        <div class="control-group ">
                            <label class="control-label" for="department">Department</label>
                            <div class="input-group input-margin">
                                <select class="form-control" size="1" name="departmentId">
                                <#list departments as department>
                                    <option value="${department.id}">${department.name}</option>
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