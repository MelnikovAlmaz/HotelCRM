<html xmlns="http://www.w3.org/1999/html">
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
                    <span>Employee</span>
                </div>
                <div class="panel-body">
                    <form method="post" action="/admin/entity/${hotel.id?c}/employee/${employee.id?c}">
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
                                <option <#if employee.role.id?c == role.id?c>selected</#if>
                                        value="${role.id?c}">${role.name}</option>
                            </#list>
                            </select>
                        </div>
                        <label for="salary">Salary</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <input type="number" step="0.1" min="1" class="form-control" name="salary"
                                   placeholder="Salary" value=${employee.salary?c}>
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
                                    <option <#if employeeDepartment.id?c == department.id?c>selected</#if>
                                            value="${department.id?c}">${department.name}</option>
                                </#list>
                                </select>
                            </div>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <input type="submit" class="btn btn-success" value="Save">
                    </form>
                    <div class="panel  panel-default">
                        <div class="panel-heading">
                            <span>WorkSchedule</span>
                        </div>
                        <div class="panel-body">
                        <#if workSchedules??>
                            <#list workSchedules as workschedule>
                                <div class="col-sm-4 panel panel-default">
                                    <div class="panel-heading ">
                                    <span>${workschedule.weekday}</span>
                                    </div>
                                    <div class="panel-body">
                                        <form action="/admin/entity/${hotel.id?c}/employee/${employee.id?c}/workschedule/${workschedule.weekday}" method="post">
                                            <div class="form-group">
                                                <input type="time" class="form-control" name="beginTime"
                                                       value="${workschedule.startTime?time?string("HH:mm")}"/>
                                            </div>
                                            <div class="form-group">
                                                <input type="time" class="form-control" name="endTime"
                                                       value="${workschedule.endTime?time?string("HH:mm")}"/>
                                            </div>
                                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                            <button type="submit" class="btn btn-success">Edit</button>
                                        </form>
                                    </div>
                                </div>
                            </#list>
                        </#if>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>
</body>
</html>