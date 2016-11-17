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
                    <th>Cleaned</th>
                    <th>Available</th>
                    <th>Category</th>
                    <th>View</th>
                </tr>
                </thead>
                <tbody>
                <#list rooms as room>
                <tr>
                    <td>${room.id?c}</td>
                    <td>${room.number}</td>
                    <td><#if room.cleaned>
                        <span class="glyphicon glyphicon-ok-circle"></span>
                        <#else>
                        <span class="glyphicon glyphicon-remove-circle"></span>
                        </#if>
                    </td>
                    <td><#if room.available>
                        <span class="glyphicon glyphicon-ok-circle"></span>
                        <#else>
                        <span class="glyphicon glyphicon-remove-circle"></span>
                    </#if></td>
                    <td>${room.category.name}</td>
                    <td>
                        <a href="/admin/entity/${hotel.id?c}/room/${room.id?c}">
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