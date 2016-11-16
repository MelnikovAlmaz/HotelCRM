<html>
<head>
<#include "../head.ftl">
</head>
<body>
<#include "../navBar.ftl">
<div class="container">
    <div class="row">
    <#include "leftBar.ftl">
        <main class="col-lg-7">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th>View</th>
                </tr>
                </thead>
                <tbody>
                <#list menus as menu>
                <tr>
                    <td>${menu.id}</td>
                    <td>${menu.name}</td>
                    <td>
                        <a href="/admin/restaurant/${menu.id}">
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