<html>
<head>
<#include "head.ftl">
</head>
<body>
<#include "main-header.ftl">

<main class="main">


    <#if myOrders??>
        <#list myOrders as order>
            <form action="/search/${order.getRoom().getCategory().getHotel().id}" method="post">

                <h3>Order № ${order.id}: </h3>

                <h4>Hotel: ${order.getRoom().getCategory().getHotel().getName()}</h4>


                <div class="form-group">
                    <label for="begin-date">Begin date</label>
                    <input type="date" class="form-control" value="${order.getBeginDate()}" id="begin-date"
                           name="beginDate">
                </div>
                <div class="form-group">
                    <label for="end-date">End date</label>
                    <input type="date" class="form-control" value="${order.getEndDate()}" id="end-date"
                           name="endDate">
                </div>

                <h4>Room category: ${order.getRoom().getCategory().name}</h4>
                <h4>Guests number: ${order.getRoom().getCategory().getBeds()}</h4>
                <br>
                <h4>Price: ${order.getPrice()}</h4>
        </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel order</button>
                <button type="submit" class="btn btn-primary">Save changes</button>
            </div>
            </form>




        </#list>
    </#if>



</main>
</body>
</html>