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
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th>Manager</th>
                    <th>View</th>
                </tr>
                </thead>
                <tbody>
                <#list departments as department>
                <tr>
                    <td>${department.id}</td>
                    <td>${department.name}</td>
                    <td><#if department.manager??>${department.manager.name}(${department.manager.role.name})</#if></td>
                    <td>
                        <a href="/admin/entity/${hotel.id}/department/${department.id}">
                            <button class="btn btn-warning">View</button>
                        </a>
                    </td>
                </#list>
                </tbody>
            </table>
        </main>
    <#include "rightBar.ftl">
    </div>
</div>
</body>
</html>