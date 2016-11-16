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
            <div class="panel panel-default">
                <div class="panel-heading">
                    <span>New Meal</span>
                </div>
                <div class="panel-body">
                    <form method="post" action="/admin/restaurant/${menu.id}/new">
                        <label for="name">Name</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <input type="text" class="form-control" name="name" placeholder="Name">
                        </div>
                        <label for="price">Price</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <input type="number" step="0.1" class="form-control" name="price" placeholder="Price">
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <input type="submit" class="btn btn-success" value="Save">
                    </form>
                </div>
            </div>
        </main>
    </div>
</div>
</body>
</html>