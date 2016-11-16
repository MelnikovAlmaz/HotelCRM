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
                    <th>Price</th>
                    <th>Edit</th>
                </tr>
                </thead>
                <tbody>
                <#list meals as meal>
                <tr>
                    <td>${meal.id}</td>
                    <td>${meal.name}</td>
                    <td>${meal.price}</td>
                    <td>
                        <a href="/admin/dashboard/meal/${meal.id}">
                            <button class="btn btn-warning">View</button>
                        </a>
                    </td>
                </#list>
                </tbody>
            </table>
        </main>
    <#include "mealRightBar.ftl">
    </div>
</div>
</body>
</html>