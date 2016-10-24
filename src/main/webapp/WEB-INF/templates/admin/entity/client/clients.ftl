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
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Phone Number</th>
                    <th>Edit</th>
                </tr>
                </thead>
                <tbody>
                <#list clients as client>
                <tr>
                    <td>${client.id}</td>
                    <td>${client.firstName}</td>
                    <td>${client.lastName}</td>
                    <td>${client.phoneNumber}</td>
                    <td>
                        <a href="/admin/entity/client/${client.id}">
                            <button class="btn btn-warning">Edit</button>
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