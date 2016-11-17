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
                    <span>New Hotel</span>
                </div>
                <div class="panel-body">
                    <form method="post" action="/admin/dashboard/hotel/new/?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data">
                        <label for="name">Name</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <input type="text" class="form-control" name="name" placeholder="Name">
                        </div>
                        <label for="phoneNumber">Phone Number</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <input type="text" class="form-control" name="phoneNumber" placeholder="Phone Number">
                        </div>
                        <div class="control-group ">
                            <label class="control-label" for="">City</label>
                            <div class="input-group input-margin">
                                <select class="form-control" size="1" name="city">
                                <#list cities as city>
                                    <option value="${city.id?c}">${city.name}</option>
                                </#list>
                                </select>
                            </div>
                        </div>
                        <label for="address">Address</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <input type="text" class="form-control" name="address" placeholder="Address">
                        </div>
                        <label for="description">Description</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <textarea class="form-control" name="description" placeholder="Description"></textarea>
                        </div>
                        <label for="image">Hotel photo</label>
                        <div class="input-group input-margin">
                            <span class="input-group-addon"></span>
                            <input type="file" class="form-control" name="image" placeholder="Image">
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