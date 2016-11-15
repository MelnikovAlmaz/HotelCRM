<html>
<head>
<#include "head.ftl">
</head>
<body>

<#include "main-header.ftl">

        <#include "search-navbar-form.ftl">

<main class="main">
<#list hotels as hotel>
    <div class="container-fluid row col-lg-8 col-lg-offset-2 col-xs-12 search-hotel-block padding0"
         style="background-color: white; height: 200px">
        <div class="col-xs-3 padding0">
            <div>
                <span>${hotel.price}</span>
            </div>
            <div>
                <a href="/search/${hotel.id}?beginDate=${beginDate}&endDate=${endDate}&guestNumber=${guestNumber}"> <button class="btn btn-warning">Choose room</button> </a>
            </div>
        </div>
        <div class="col-xs-5">
            <div>
                <h3>${hotel.name}</h3>
            </div>
            <div>
                <p class="description_b" >${hotel.description}</p>
            </div>
        </div>
        <div class="col-xs-4 padding0">
            <div style="background-color: #1b6d85; height: 100%; width: 100%"></div>
        </div>
    </div>
</#list>
</main>
<datalist id="hotelNames">
</datalist>
</body>
</html>
