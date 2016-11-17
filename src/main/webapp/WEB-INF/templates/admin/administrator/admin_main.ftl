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
                    <th>Phone Number</th>
                    <th>Address</th>
                    <th>Edit</th>
                </tr>
                </thead>
                <tbody>
                <#list hotels as hotel>
                <tr>
                    <td>${hotel.id?c}</td>
                    <td>${hotel.name}</td>
                    <td>${hotel.phoneNumber}</td>
                    <td>${hotel.address}</td>
                    <td>
                        <a href="/admin/dashboard/hotel/${hotel.id?c}">
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