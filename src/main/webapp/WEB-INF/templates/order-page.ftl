<html xmlns="http://www.w3.org/1999/html">
<head>
<#include "head.ftl">
</head>
<body>
<#include "main-header.ftl">
<main class="main container row">
<#if myOrders??>
    <section class="col-lg-offset-2 col-lg-8">
        <#list myOrders as order>
            <div class="row">
                <form action="/myorders/${order.id}" method="post">
                    <h3>Order № ${order.id}: </h3>
                    <h4>Hotel: ${order.getRoom().getCategory().getHotel().getName()}</h4>
                    <div class="form-group">
                        <label for="begin-date">Begin date</label>
                        <input type="date" class="form-control" value="${order.beginDate?date?string("YYYY-MM-dd")}" name="beginDate">
                    </div>
                    <div class="form-group">
                        <label for="end-date">End date</label>
                        <input type="date" class="form-control" value="${order.endDate?date?string("YYYY-MM-dd")}" name="endDate">
                    </div>
                    <h4>Room category: ${order.getRoom().getCategory().name}</h4>
                    <h4>Guests number: ${order.getRoom().getCategory().getBeds()}</h4>
                    <br>
                    <h4>Price: ${order.getPrice()}</h4>
                    <div class="modal-footer">
                        <a href="/myorders/${order.id}/delete">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancel order</button>
                        </a>
                        <button type="submit" class="btn btn-primary">Save changes</button>
                    </div>
                </form>
            </div>
        </#list>
    </section>
</#if>
</main>
</body>
</html>