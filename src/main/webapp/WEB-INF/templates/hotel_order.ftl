<html>
<head>
<#include "head.ftl">
</head>
<body>
<header>
    <section class="login-header"><br></section>
    <section class="container-fluid">
        <div class="container nav-section col-xs-offset-2 col-xs-9">
            <ul class="nav navbar-nav">
                <li>
                    <h3>Hotel world</h3>
                </li>
            </ul>
        <#include "search-navbar-form.ftl">
        </div>
    </section>
    <section class="filter-line">
        <span>H</span>
    </section>
</header>
<main class="main">
    <div class="form-group">
        <input type="date" class="form-control" placeholder="Begin date" id="begin-date" name="beginDate"
               value=${beginDate}>
    </div>
    <div class="form-group">
        <input type="date" class="form-control" placeholder="End date" id="end-date" name="endDate"
               value=${endDate}>
    </div>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Beds</th>
            <th>Price</th>
            <th>Order</th>
        </tr>
        </thead>
        <tbody>
        <#list roomCategories as roomcategory>
        <tr>
            <td>${roomcategory.id}</td>
            <td>${roomcategory.name}</td>
            <td>${roomcategory.beds}</td>
            <td>${roomcategory.price}</td>
            <td>
                <button class="btn btn-success">Order</button>
            </td>
        </#list>
        </tbody>
    </table>
</main>
<datalist id="hotelNames">
</datalist>
</body>
</html>