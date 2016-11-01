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
            <div class="panel panel-default">
                <div class="panel-heading">
                    <span>Hotel</span>
                </div>
                <div class="panel-body">
                    <form method="post" action="/admin/entity/hotel/${hotel.id}">
                        <label for="name">Name</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <input type="text" class="form-control" name="name" placeholder="Name"
                                   value="${hotel.name}">
                        </div>
                        <label for="phoneNumber">Phone Number</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <input type="text" class="form-control" name="phoneNumber" placeholder="Phone Number"
                                   value="${hotel.phoneNumber}">
                        </div>
                        <label for="address">Address</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <input type="text" class="form-control" name="address" placeholder="Address"
                                   value="${hotel.address}">
                        </div>
                        <label for="description">Description</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <textarea class="form-control" name="description" placeholder="Description">${hotel.description}</textarea>
                        </div>
                        <input type="submit" class="btn btn-success" value="Save">
                    </form>
                </div>
            </div>
        </main>
    </div>
</div>
</body>
</html>