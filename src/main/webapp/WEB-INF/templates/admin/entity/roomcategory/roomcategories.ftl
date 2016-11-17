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
                    <th>Beds</th>
                    <th>Price</th>
                    <th>View</th>
                </tr>
                </thead>
                <tbody>
                <#list roomcategories as roomcategory>
                <tr>
                    <td>${roomcategory.id?c}</td>
                    <td>${roomcategory.name}</td>
                    <td>${roomcategory.beds}</td>
                    <td>${roomcategory.price}</td>
                    <td>
                        <a href="/admin/entity/${hotel.id?c}/roomcategory/${roomcategory.id?c}">
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