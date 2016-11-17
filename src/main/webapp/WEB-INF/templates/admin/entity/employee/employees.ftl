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
                    <th>PhoneNumber</th>
                    <th>Role</th>
                    <th>View</th>
                </tr>
                </thead>
                <tbody>
                <#list employees as employee>
                <tr>
                    <td>${employee.id?c}</td>
                    <td>${employee.name}</td>
                    <td>${employee.phoneNumber}</td>
                    <td>${employee.role.name}</td>
                    <td>
                        <a href="/admin/entity/${hotel.id?c}/employee/${employee.id?c}">
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