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
                    <th>Passport</th>
                    <th>Phone Number</th>
                    <th>Edit</th>
                </tr>
                </thead>
                <tbody>
                <#list guests as guest>
                <tr>
                    <td>${guest.id}</td>
                    <td>${guest.name}</td>
                    <td>${guest.passport}</td>
                    <td>${guest.phoneNumber}</td>
                    <td>
                        <a href="/admin/entity/guest/${guest.id}">
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