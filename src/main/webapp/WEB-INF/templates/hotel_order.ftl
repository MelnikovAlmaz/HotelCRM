<html>
<head>
<#include "head.ftl">
</head>
<body>

<#include "main-header.ftl">

<#include "search-navbar-form.ftl">
<main class="main">




    <h1 class="title_b">${hotel.name}</h1>
    <p class="description_b">${hotel.description}</p>


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
                <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal">Order</button>
                <!-- Button trigger modal -->


                <!-- Modal -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">Ordering a room...</h4>
                            </div>
                            <div class="modal-body">

                                <div class="form-group">
                                    <input type="text" class="form-control" id="search" list="hotelNames" name="name" placeholder="City" value=${hotel.city.name}>
                                </div>

                                <div class="form-group">
                                    <input type="text" class="form-control" id="search" list="hotelNames" name="name" value=${hotel.name}>
                                </div>

                                <div class="form-group">
                                    <input type="date" class="form-control" value=${beginDate} id="begin-date" name="beginDate">
                                </div>

                                <div class="form-group">
                                    <input type="date" class="form-control" value=${endDate} id="end-date" name="endDate">
                                </div>

                                <div class="form-group">
                                    <input type="number" step="1" class="form-control" name="guestNumber" style="width: 100px" value=${guestNumber}>
                                </div>

                                <div class="input-group input-margin">
                                    <select class="form-control" size="1" name="city">
                                        <#list roomCategories as rC>
                                        <option value=${rC.id}>﻿${rC.name}</option>
                                        </#list>

                                    </select>
                                </div>


                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary">Accept</button>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
        </#list>
        </tbody>
    </table>
</main>



</body>
</html>