<html>
<head>
<#include "head.ftl">
</head>
<body>
<#include "main-header.ftl">
<#include "search-navbar-form.ftl">
<main class="main">
    <div class="container col-lg-8 col-lg-offset-2">
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
    <#list roomCategories as roomcategory>
        <div class="container-fluid well">
            <div class="col-sm-1">${roomcategory.id}</div>
            <div class="col-sm-4">${roomcategory.name}</div>
            <div class="col-sm-2">${roomcategory.beds}</div>
            <div class="col-sm-3">${roomcategory.price}</div>
            <div class="col-sm-2">
                <button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal">Order
                </button>
                <!-- Button trigger modal -->
                <!-- Modal -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <form action="/search/${hotel.id}" method="post">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-label="Close"><span
                                            aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="myModalLabel">Ordering a room...</h4>
                                </div>
                                <div class="modal-body">
                                    <h3>${hotel.name}</h3>
                                    <div class="form-group">
                                        <label for="begin-date">Begin date</label>
                                        <input type="date" class="form-control" value="${beginDate}" id="begin-date"
                                               name="beginDate">
                                    </div>
                                    <div class="form-group">
                                        <label for="end-date">End date</label>
                                        <input type="date" class="form-control" value="${endDate}" id="end-date"
                                               name="endDate">
                                    </div>
                                    <div class="form-group">
                                        <label for="roomCategory">Room Category</label>
                                        <select class="form-control" size="1" name="roomCategory">
                                            <#list roomCategories as rC>
                                                <option value=${rC.id}>﻿${rC.name}</option>
                                            </#list>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="guestNumber">Guests</label>
                                        <input type="number" step="1" class="form-control" name="guestNumber"
                                               min="1" max="10" style="width: 100px" value=${guestNumber}>
                                    </div>
                                    <#if user??>
                                    <#else>
                                        <h3>Share your contacts, please.</h3>
                                        <label for="name">Name</label>
                                        <div class="form-group">
                                            <input type="text" class="form-control" name="name" placeholder="Name">
                                        </div>
                                        <label for="phoneNumber">Phone Number</label>
                                        <div class="form-group">
                                            <input type="tel" class="form-control" name="phoneNumber"
                                                   placeholder="Phone Number">
                                        </div>
                                        <label for="address">Password</label>
                                        <div class="form-group">
                                            <input type="password" class="form-control" name="password"
                                                   placeholder="Password">
                                        </div>
                                    </#if>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close
                                    </button>
                                    <button type="submit" class="btn btn-primary">Accept</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </#list>
    </div>
</main>
</body>
</html>